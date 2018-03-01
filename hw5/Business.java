/**
* This class contains code to be used for Business
* @author David Zhou
* @version 1.0
*/
public class Business {

    private String[][] info = SimData.getData();

    /**
    * This is a getter for the name of the business you are looking for
    *@return name of the business
    */
    public String getName() {
        return info[0][0];
    }

    /**
    *This is a method that will help parse through the info
    * @return Item array of products sold
    */
    public Item[] itemList() {
        Item[] products = new Item[info.length - 1];
        for (int i = 1; i <= info.length - 1; ++i) {
            String itemName = info[i][0];
            double itemPrice = Double.parseDouble(info[i][1]);
            int itemStock = Integer.parseInt(info[i][2]);
            products[i - 1] = new Item(itemName, itemPrice, itemStock);
        }
        return products;
    }

    /**
    @param person the person that is buying
    @param toBuy the item that the person is buying
    */
    public void purchase(Person person, Item toBuy) {
        toBuy.updateStock(person);
    }
}
