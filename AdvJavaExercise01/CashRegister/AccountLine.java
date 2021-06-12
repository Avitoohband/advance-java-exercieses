// This class represent a "Line" in the account
public class AccountLine {
    private Product prod;
    private int amount;
    private double totalPrice;
//----------------------------------------------------------------------------------------------------------------------
    //Ctor - product only
    public AccountLine(Product newProduct){
        this.prod = newProduct;
        this.amount = 1;
        this.totalPrice = this.amount * prod.getPrice();
    }
//----------------------------------------------------------------------------------------------------------------------
  //Ctor - with amount
    public AccountLine(Product newProduct, int amount){
        this.prod = newProduct;
        this.amount = amount;
        this.totalPrice = this.amount * this.prod.getPrice();
    }
//----------------------------------------------------------------------------------------------------------------------
    // Returns a String that represent the line
    public String toString(){
        return String.format(this.getProduct() + " Amount: %d Total price: %.2f", this.getAmount(), this.getTotalPrice());
    }
//----------------------------------------------------------------------------------------------------------------------
    // Returns the product object
    public Product getProduct(){
        return this.prod;
    }
//----------------------------------------------------------------------------------------------------------------------
    // Returns the amount of the product
    public int getAmount(){
        return this.amount;
    }
//----------------------------------------------------------------------------------------------------------------------
    // Changes the amount of the product
    public void setAmount(int newAmount){
        this.amount = newAmount;
        this.totalPrice = this.amount * this.prod.getPrice();
    }
//----------------------------------------------------------------------------------------------------------------------
    // Returns total price for the product
    public double getTotalPrice(){
        return this.totalPrice;
    }
//----------------------------------------------------------------------------------------------------------------------
}
