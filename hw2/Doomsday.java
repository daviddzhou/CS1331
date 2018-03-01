// I am a good boy and did this homework assignment by myself
import java.util.Scanner;

public class Doomsday {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String answer = "y";
        while (answer.equals("y")) {
            System.out.println("Welcome to the Doomsday Calculator!");
            System.out.print("Enter year (1900-1999): ");
            int year = reader.nextInt();
            System.out.print("Enter month (1-12): ");
            int month = reader.nextInt();
            System.out.print("Enter day: ");
            int day = reader.nextInt();
            int[] leapArray = new int[]{4, 29, 7, 4, 9, 6, 11, 8, 5, 10, 7, 12};
            int[] yearArray = new int[]{3, 28, 7, 4, 9, 6, 11, 8, 5, 10, 7, 12};
            int dDay = 0;
            String doomsDay = "";
            boolean leap = true;
            boolean valid = false;
            int tempVal = 0;
            int yearRemainder = year % 4;
            int yearRemainder100 = year % 100;
            int yearRemainder400 = year % 400;
            //this is the if for invalid dates
            if (yearRemainder == 0) {
                if (yearRemainder100 == 0) {
                    if (yearRemainder400 == 0) {
                        leap = false;
                    }
                } else {
                    leap = true;
                }
            } else {
                leap = false;
            }


            if ((year <= 1899) || (year >= 2000) || (month <= 0)
                || (month >= 13) || (day <= 0) || (day >= 32)) {
                valid = false;
            } else {
                if ((((month == 4) || (month == 6) || (month == 9)
                    || (month == 11)) && (day < 31))) {
                    valid = true;
                }
                if ((((month == 1) || (month == 3) || (month == 5)
                    || (month == 7) || (month == 10) || (month == 12))
                    && (day < 31))) {
                    valid = true;
                }
                if ((month == 2) && !leap) {
                    if (day <= 28) {
                        valid = true;
                    }
                } else {
                    if (day <= 29) {
                        valid = true;
                    }
                }
            }

            if (valid) {
                int anchorDay = 3;
                int twoYear = (year - 1900) / 12;
                int modYear = (year - 1900) % 12;
                int modYearDiv = (modYear / 4);
                int sumDouble = (twoYear + modYear + modYearDiv + anchorDay);
                int modSum = (sumDouble % 7);

                if (leap) {
                    tempVal = leapArray [month - 1];
                    dDay = day - tempVal;
                } else {
                    tempVal = yearArray [month - 1];
                    dDay = day - tempVal;
                }
                dDay = (dDay % 7);
                dDay = (int) ((dDay + modSum) + 7) % 7;
                switch (dDay) {
                case 0: doomsDay = "Sunday";
                break;
                case 1: doomsDay = "Monday";
                break;
                case 2: doomsDay = "Tuesday";
                break;
                case 3: doomsDay = "Wednesday";
                break;
                case 4: doomsDay = "Thursday";
                break;
                case 5: doomsDay = "Friday";
                break;
                case 6: doomsDay = "Saturday";
                break;
                default: valid = false;
                break;
                }
                System.out.println(month + "/" + day + "/" + year
                    + " was on a " + doomsDay + System.lineSeparator());
                System.out.println("Do you want to enter another "
                    + "date(type 'y' or 'n')");
                answer = reader.next();
            } else {
                System.out.println("The entered date is invalid!"
                    + System.lineSeparator());
                System.out.println("Do you want to enter another "
                    + "date(type 'y' or 'n')");
                answer = reader.next();
            }
        }
    }
}
