/**
* This class contains code to be used for Person
* @author David Zhou
* @version 1.0
*/

public class Person {

    private double money;

    /**
    * This sets the amount of money a person has when the program is initialized
    */
    public Person() {
        money = 5000.00;
    }

    /**
    * This is a getter to look at how much money and individual has
    * @return the amount of money a person has
    */
    public double getMoney() {
        return money;
    }

    /**
    * This is a setter to decrease the balance of the individuals budget
    * @param i price of the item
    */
    public void setMoney(double i) {
        money -= i;
    }

}
