// This class represent the Cash Register
import java.util.ArrayList;

public class CashRegister {
    private double cash;
    private double totalSells;
    private ArrayList<AccountLine> lines = new ArrayList<AccountLine>();

//----------------------------------------------------------------------------------------------------------------------
    //Empty Ctor
    public CashRegister()
    {
        this.cash = 0;
        this.totalSells = 0;
    }
//----------------------------------------------------------------------------------------------------------------------
    //Ctor
    public CashRegister(double cash)
    {

        this.cash = formatDouble(cash);
        this.totalSells = 0;
    }
//----------------------------------------------------------------------------------------------------------------------
    //Adding new product to the list(Cart)
    public void addNewProduct(Product newProduct, int amount){

        // checks if product already on the list
        int productIndex = this.getLineIndex(newProduct.getName());
        if(productIndex != -1)
        {
            AccountLine newLine = this.lines.get(productIndex);
            newLine.setAmount(newLine.getAmount() + amount);
        }
        else{ // product is not on the list
            AccountLine newLine = new AccountLine(newProduct, amount);
            this.lines.add(newLine);
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    // Prints the current client's shopping list
    public void printClientList()
    {
        if(lines.size() == 0){
            System.out.println("The list is empty!");
            return;
        }
        for(AccountLine item : this.lines){
            System.out.println(item);
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    // Prints the current client's Bill
    public String getBill(){
        return String.format("Total Products: %d \nTotal Price: %.2f\n",this.getTotalAmount(), this.getTotalPrice());
    }
//----------------------------------------------------------------------------------------------------------------------
    // Returns the total price for the current client's purchase
    private double getTotalPrice(){
        double totalPrice = 0;
        for(AccountLine item : this.lines){
            totalPrice += item.getTotalPrice();
        }
        return formatDouble(totalPrice);
    }
//----------------------------------------------------------------------------------------------------------------------
    // Returns the total amount or products the current clint's has in his purchase
    private int getTotalAmount(){
        int total = 0;
        for(AccountLine item : this.lines)
        {
            total += item.getAmount();
        }
        return total;
    }
//----------------------------------------------------------------------------------------------------------------------
    // Checkout method, close the ongoing buying with the client - getting payed
    public void checkout(double cash){
        cash = this.formatDouble(cash);

        // if have enough money, check if change is needed
        if (cash >= this.getTotalPrice())
        {
            if(this.giveChange(cash)) {
                this.resetAccount();
            }
        }
        else // cash < Total Price - client does not have enough money
        {
            System.out.println("Not Enough Money!");
        }

    }
//----------------------------------------------------------------------------------------------------------------------
    // Change the amount of cash in the CashRegister
    private void setCash(double cash){
        this.cash = cash;
    }
//----------------------------------------------------------------------------------------------------------------------
    // Returs the current amount of cash in the CashRegister
    public double getCash(){return this.formatDouble(this.cash);}
//----------------------------------------------------------------------------------------------------------------------
    // Give the client change, if there is not enough change in the CashRegister,
    // it returns false
    private boolean giveChange(double cash)
    {
        if (this.getCash() - (cash - this.getTotalPrice()) >= 0){
            this.setCash(this.getCash() + this.getTotalPrice());
            this.setTotalSells(this.getTotalSells()+this.getTotalPrice());

            System.out.format("The change for the client is: %.2f\n" , ((cash - this.getTotalPrice())));
            return true;
        }
        else{
            System.out.println("There is not enough cash in the register for the change");
            return false;
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    // Resets the purchase for new clients to come
    private void resetAccount(){
        this.lines.clear();
    }
//----------------------------------------------------------------------------------------------------------------------
    // Removing product from the purchase list
    public void removeProduct(String prodcutName, int amount){
        if (amount < 0) return;
        int productIndex = this.getLineIndex(prodcutName);
        if(productIndex != -1) {
            if (amount >= this.lines.get(productIndex).getAmount()) {
                System.out.println(this.lines.get(productIndex).getAmount() + " " + prodcutName + "s have been removed from the list");
                this.lines.get(productIndex).setAmount(0);
            } else // amount to remove smaller than the amount
            {
                this.lines.get(productIndex).setAmount(this.lines.get(productIndex).getAmount() - amount);
                System.out.println(amount + " " + prodcutName + "s have been removed from the list");
            }
            if(lines.get(productIndex).getAmount() == 0){
                lines.remove(lines.get(productIndex));
            }

        }
        else{ // Item is not on the list
            System.out.println("There is no " + prodcutName +" in the list");
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    // Format the cash to be "00.00"
    private double formatDouble(double number){
        return Math.round(number*100)/100.0;
    }

//----------------------------------------------------------------------------------------------------------------------
   // Updates the total sells value
    private void setTotalSells(double cash){
        this.totalSells = cash;
    }
//----------------------------------------------------------------------------------------------------------------------
    // Returns Total Sells
    public double getTotalSells(){
        return this.totalSells;
    }
//----------------------------------------------------------------------------------------------------------------------
    // Get the indices of a certain product
    private int getLineIndex(String productName){
        for(AccountLine item : this.lines){
            if(item.getProduct().getName().equals(productName)){
                return lines.indexOf(item);
            }
        }
        return -1; // Product does not exist in the list
    }
//----------------------------------------------------------------------------------------------------------------------
}
                                                      