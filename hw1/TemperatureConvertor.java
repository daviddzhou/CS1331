// I am a good boy and did this homework assignment by myself

import java.util.Scanner;

public class TemperatureConvertor {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter a temperature in degrees Fahrenheit: ");
        double n = reader.nextDouble();
        double k = (n + 459.67) * (5.0 / 9.0);
        double roundOff = Math.round(k * 100.0) / 100.0;
        System.out.print(n + " degrees Fahrenheit is " + roundOff);
        reader.close();
    }

}
