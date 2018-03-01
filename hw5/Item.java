/**
* This class contains code to be used for Item
* @author David Zhou
* @version 1.0
*/

public class Item {

    private String name;
    private double price;
    private int stock;
    private int counter;



    /**
    *This constructor does nothing except catch constructions with no parameters
    */
    public Item() {
        //nothing
    }

    /**
    *This is a constructor for the Item object
    * @param n name of the Item
    * @param p price of the Item
    * @param s stock of the Item
    */
    public Item(String n, double p, int s) {
        name = n;
        price = p;
        stock = s;
    }

    /**
    *This is a getter for the item name
    *@return name of Item
    */
    public String getName() {
        return name;
    }

    /**
    *This is a getter for the item price
    *@return price of the Item
    */
    public Double getPrice() {
        return price;
    }

    /**
    *This is a getter for the item stock
    *@return remaining stock of an item
    */
    public int getStock() {
        return stock;
    }

    /**
    *This is a getter for item counter
    *@return stock of the item
    */
    public int getCounter() {
        return counter;
    }

    /**
    *This is a method
    *@param p is the person that we are adjusting budget for
    */
    public void updateStock(Person p) {
        if ((p.getMoney() >= price) && (stock > 0)) {
            stock--;
            p.setMoney(price);
            counter++;
        }
    }
}
