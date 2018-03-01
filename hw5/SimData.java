
/**
 * This class contains data to be used for MarketSim
 * @author Thomas Lilly
 * @version 1.0
 */

public class SimData {

    /* Please use this array to test your classes.
     * Feel free to add data to test resizing
     */
    private static String[][] businessData = {
        {"Amazon"},
        {"Fitbit", "129.89", "40"},
        {"Amazon Echo", "179.99" , "34"},
        {"Roses", "139.99", "100"},
        {"Chocolate", "30.40", "57"},
        {"Jaybird X2", "128.50", "20"},
        {"Basketball", "28.44", "176"},
        {"Shawl", "12.99", "230"},
        {"CLRS", "66.32", "281"},
        {"HDMI Cable", "4.96", "132"},
        {"Stationery", "9.89", "75"}
    };

    /**
    * this is a getter that you get a 2d String array
    *@return 2d string array of all products
    */
    public static String[][] getData() {
        return businessData;
    }
}
