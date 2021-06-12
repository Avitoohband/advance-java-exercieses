import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Polynom {

    private ArrayList<PolynomNumbers> factorsAndExponents = new ArrayList<PolynomNumbers>();

    //----------------------------------------------------------------------------------------------------------------------
    // Ctor
    public Polynom(double[] fac, int[] expo) throws InvalidArrayCallException{

        if (fac.length != expo.length) {
            throw new InvalidArrayCallException("EXCEPTION! Invalid length of arrays. Must be equals!");
        }
        for (int i = 0; i < fac.length; i++) {
            if (fac[i] == 0) {
                continue;
            }
            PolynomNumbers polNum = new PolynomNumbers(fac[i], expo[i]);
            this.factorsAndExponents.add(polNum);
        }

        Collections.sort(this.factorsAndExponents, new Comparator<PolynomNumbers>() {

            public int compare(PolynomNumbers num1, PolynomNumbers num2) {
                return Integer.valueOf(num2.getExponent()).compareTo(num1.getExponent());
            }
        });
    }

    //----------------------------------------------------------------------------------------------------------------------
    // Copy CTor
    public Polynom(Polynom other) {
        for (int i = 0; i < other.getSizeOfArray(); i++) {
            this.factorsAndExponents.add(other.getPolynomNumber(i));
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    // Returns the Polynom after beehing subtracted with the given Polynom(Other)
    //equals all of the values ,put  the subtracted value in the array and removes the value from the other array(temp)
    //than go though the rest to the values and just add them to the array

    public Polynom minus(Polynom other) {
        Polynom polynomToReturn = null;

        double[] newFactors = new double[this.getSizeOfArray() + other.getSizeOfArray()];
        int[] newExponents = new int[this.getSizeOfArray() + other.getSizeOfArray()];
        int newIndex = 0;
        Polynom tempPolynom = new Polynom(other);

        int i = 0 ;

        while (i < this.getSizeOfArray()){
            PolynomNumbers currentPolynumNumbers = this.getArray().get(i);
            if (!this.getNewFactorAndExponent(currentPolynumNumbers ,tempPolynom, Menu.getOpMinus(), newFactors, newExponents, newIndex)){
                newFactors[newIndex] = this.getArray().get(i).getFactor();
            }
            newExponents[newIndex++] = this.getArray().get(i++).getExponent();
        }

        this.fillRestPlusOrMinus(tempPolynom, Menu.getOpMinus(), newFactors, newExponents, newIndex);

        polynomToReturn = buildPolynom(newFactors,newExponents);
        return polynomToReturn;
    }
//----------------------------------------------------------------------------------------------------------------------
    // Returns the Polynom after beehing subtracted with the given Polynom(Other)
    //equals all of the values ,put  the subtracted value in the array and removes the value from the other array(temp)
    //than go though the rest to the values and just add them to the array

    public Polynom plus(Polynom other) {
        Polynom polynomToReturn = null;

        double[] newFactors = new double[this.getSizeOfArray() + other.getSizeOfArray()];
        int[] newExponents = new int[this.getSizeOfArray() + other.getSizeOfArray()];
        int newIndex = 0;
        Polynom tempPolynom = new Polynom(other);

        int i = 0 ;

        while (i < this.getSizeOfArray()){
            PolynomNumbers currentPolynumNumbers = this.getArray().get(i);
            if (!this.getNewFactorAndExponent(currentPolynumNumbers ,tempPolynom, Menu.getOpPlus(), newFactors, newExponents, newIndex)){
                newFactors[newIndex] = this.getArray().get(i).getFactor();
            }
            newExponents[newIndex++] = this.getArray().get(i++).getExponent();
        }


        this.fillRestPlusOrMinus(tempPolynom, Menu.getOpPlus(), newFactors, newExponents, newIndex);

        polynomToReturn = buildPolynom(newFactors, newExponents);
        return polynomToReturn;
    }

//----------------------------------------------------------------------------------------------------------------------
    private boolean getNewFactorAndExponent(PolynomNumbers current, Polynom tempPolynom, String operator, double[] newFactors, int [] newExponents, int newIndex){

            for(int i = 0 ; i < tempPolynom.getSizeOfArray() ; i++){
                // gets the Polynom Numbers object of the given index j
                PolynomNumbers tempPolynomNumbers = tempPolynom.getArray().get(i);

                // if exponents equals, sub or sum the factors
                if (current.isExponentsEquals(tempPolynomNumbers)){

                    // checks what is the desired operator
                    if(operator.equals(Menu.getOpPlus())){ // Operator is Plus
                        double newFactor = current.getFactor() + tempPolynomNumbers.getFactor();
                        newFactors[newIndex] = newFactor;
                    }

                    else{  // Operator in Minus
                        double newFactor = current.getFactor() - tempPolynomNumbers.getFactor();
                        newFactors[newIndex] = newFactor;
                    }
                    tempPolynom.getArray().remove(tempPolynomNumbers);
                    return true;
                }
            }
        return false;
    }
//----------------------------------------------------------------------------------------------------------------------
    private void fillRestPlusOrMinus(Polynom tempPolynom, String operator, double[] newFactors, int [] newExponents, int newIndex){
        int i = 0 ;

        while (i < tempPolynom.getSizeOfArray()){ // add the rest values to the array (Polynom)
            if(operator.equals(Menu.getOpPlus())){
                newFactors[newIndex] = tempPolynom.getArray().get(i).getFactor();
                newExponents[newIndex++] = tempPolynom.getArray().get(i++).getExponent();
            }
            else{  // Operator is minus
                newFactors[newIndex] = -tempPolynom.getArray().get(i).getFactor();
                newExponents[newIndex++] = tempPolynom.getArray().get(i++).getExponent();
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    // Builds the polynom and handle the exception if needed.
    // Returns the polynom
    public static Polynom buildPolynom(double[] factors, int[] exponents){

        Polynom pol = null;
        try{
            pol = new Polynom(factors,exponents);
        }
        catch(InvalidArrayCallException e){
            System.out.println(e.getMessage());
        }
        return pol;
    }
//----------------------------------------------------------------------------------------------------------------------
    public String toString() {
        String pol = "";

        if(this.getSizeOfArray() == 0){
            return pol += "0";
        }


        for (int i = 0; i < this.factorsAndExponents.size(); i++) {
            pol += this.getArray().get(i);
            // checks for what sign to put before the factor
            if (i != this.factorsAndExponents.size() - 1) {
                pol += (this.factorsAndExponents.get(i + 1).getFactor() > 0) ? "+ " : "";
            }
        }
        return pol;
    }

//----------------------------------------------------------------------------------------------------------------------
    // Returns the derivative of the given polynom
    public Polynom derivate(){
        double[] newFactors = new double[this.getSizeOfArray()];
        int[] newExponents = new int[this.getSizeOfArray()];

        for(int i = 0 ; i < this.getSizeOfArray() ; i++){
            if (this.getArray().get(i).getExponent() == 0){
                newFactors[i] = 0;
            }
            else{
                newFactors[i] = this.getArray().get(i).getFactor() * this.getArray().get(i).getExponent();
                newExponents[i] = this.getArray().get(i).getExponent() - 1;
            }
        }

        return buildPolynom(newFactors, newExponents);
    }

//----------------------------------------------------------------------------------------------------------------------
    // Checks if the given Polynom is equal to the current Polynom and retunrs true or false respectively

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Polynom)) return false;
        Polynom that = (Polynom) o;

        if (this.getSizeOfArray() != that.getSizeOfArray()){
            return false;
        }

        for (int i = 0 ; i < this.getSizeOfArray() ; i++){
            if (!(this.getArray().get(i).equals(that.getArray().get(i)))){
                return false;
            }
        }

        return true;
    }
//----------------------------------------------------------------------------------------------------------------------

    // Returns the array size
    private int getSizeOfArray() {
        return this.factorsAndExponents.size();
    }

//----------------------------------------------------------------------------------------------------------------------
    // Returns the PolynomNumber object at a certain index
    private PolynomNumbers getPolynomNumber(int i) {
        return this.factorsAndExponents.get(i);
    }

//----------------------------------------------------------------------------------------------------------------------
    // Returns the array with factors and exponents
    private ArrayList<PolynomNumbers> getArray() {
        return this.factorsAndExponents;
    }
//----------------------------------------------------------------------------------------------------------------------
}
