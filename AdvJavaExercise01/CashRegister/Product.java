// This class represent a Product
public class Product {

    private String productName;
    private double productPrice;
//----------------------------------------------------------------------------------------------------------------------
    //Ctor
    public Product(String name, double price){
        this. productName = name;
        this.productPrice = price;
    }
//----------------------------------------------------------------------------------------------------------------------
    // Returns a String that represent the Product
    public String toString(){
        return ("|Product name: " + this.getName() + "| |Product Price: " + this.getPrice() + "|");
    }
//----------------------------------------------------------------------------------------------------------------------
    // Returs the price of the product
    public double getPrice(){
        return this.productPrice;
    }
//----------------------------------------------------------------------------------------------------------------------
    // Returns  the name of the product
    public String getName(){
        return this.productName;
    }
//----------------------------------------------------------------------------------------------------------------------
}
