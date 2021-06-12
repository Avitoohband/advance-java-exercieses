public class PolynomNumbers{

    private double factor;
    private int exponent;
//----------------------------------------------------------------------------------------------------------------------
    //Ctor
    public PolynomNumbers(double fac, int expo) {
        this.factor = fac;
        this.exponent = expo;
    }
//----------------------------------------------------------------------------------------------------------------------
    // Returns factor
    public double getFactor() {
        return this.factor;
    }
//----------------------------------------------------------------------------------------------------------------------
    // Returns exponent
    public int getExponent() {
        return this.exponent;
    }
//----------------------------------------------------------------------------------------------------------------------
    // returns if exponents are equal

    public boolean isExponentsEquals(PolynomNumbers other) {
        return this.getExponent() == other.getExponent();
    }
//----------------------------------------------------------------------------------------------------------------------
    // returns if factors are equal
    public boolean isFactorEquals(PolynomNumbers other) {
        return this.getFactor() == other.getFactor();
    }
//----------------------------------------------------------------------------------------------------------------------
    // Returns if both factors and exponents are equal
//    public boolean equals (PolynomNumbers other){
//        return this.isExponentsEquals(other) && this.isFactorEquals(other);
//    }
//----------------------------------------------------------------------------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof PolynomNumbers)) return false;
        PolynomNumbers that = (PolynomNumbers) o;
        return Double.compare(this.getFactor(), that.getFactor()) == 0 &&
                this.getExponent() == that.getExponent();
    }
//----------------------------------------------------------------------------------------------------------------------
    public String toString(){
        if (this.getFactor() == 0)
            return "";

        String res = this.getFactor() + "";
        if (this.getExponent() == 0){ // exponents is zero, which means x^0 = 1, x doesn't need to be printed
             res +=" ";
        }
        else if(this.getExponent() == 1){ //  exponent is 1 and doesn't need to be printed
            res +="x ";
        }
        else{ // exponents is bigger than 1 and need to be printed
            res += "x^" + this.getExponent() + " ";
        }

        return res;
    }
//----------------------------------------------------------------------------------------------------------------------

}
