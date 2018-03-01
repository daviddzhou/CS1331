import java.util.Random;

/**
* This class contains code to be used for MarketSim
* @author David Zhou
* @version 1.0
*/

public class MarketSim {

    /**
    * this is the main method which takes in input arguments
    *@param args there are three args - people, days, and random seed
    */
    public static void main(String[] args) {

        try {
            int person = Integer.parseInt(args[0]);
            int days = Integer.parseInt(args[1]);
            int seed = Integer.parseInt(args[2]);
            Business company = new Business();
            Person[] people = new Person[person];
            for (int i = 0; i < person; i++) {
                Person buyer = new Person();
                people[i] = buyer;
            }
            Random itemNum = new Random(seed);
            int transactions = 0;
            int numberSold = 0;
            Item bestSelling = new Item();
            double totalSales = 0.0;
            Item[] products = company.itemList();

            int maxSold = -1;
            double start = System.nanoTime();
            for (int i = 0; i < days; i++) {
                for (Person buyer : people) {
                    int randItem = itemNum.nextInt(products.length);
                    Item bought = products[randItem];
                    company.purchase(buyer, bought);
                    for (Item all : products) {
                        if (all.getCounter() > maxSold) {
                            bestSelling = all;
                            maxSold = all.getCounter();
                        }
                    }
                }
            }
            double elapsedTime = (System.nanoTime() - start) / 1e6;

            for (int j = 0; j < products.length; j++) {
                transactions += products[j].getCounter();
                if (products[j].getStock() > 0) {
                    numberSold++;
                }
                totalSales += products[j].getCounter()
                    * products[j].getPrice();
            }

            System.out.printf("Running simulation with %d people over %d days"
                + "...\n", person, days);
            System.out.printf("Simulation Report: %s\n", company.getName());
            System.out.printf("Execution Time: %.2f ms\n", elapsedTime);
            System.out.println("========================================"
                + "========================");
            System.out.printf("Days of simulation: %d\n", days);
            System.out.printf("Total Transactions: %d\n", transactions);
            System.out.printf("Total Sales: %.2f\n", totalSales);
            System.out.printf("Number of Items being sold: %d\n", numberSold);
            System.out.printf("Best selling Item: " + "\"%s\"\n",
                bestSelling.getName());
            System.out.println("========================================"
                + "========================");

            /*Simulation Report: Amazon
            Execution time: 0.08ms
            ================================================================
            Days of simulation: 10
            Total Transactions: 50
            Total Sales: $3823.58
            Number of Items being sold: 10
            Best selling Item: "Jaybird X2"
            ================================================================
            */

        } catch (Exception e) {
            System.out.println("MarketSim requires 3 to arguments to be run."
                + "Usage: java MarketSim <people> <days> <seed>");
        }

    }
}
