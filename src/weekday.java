import java.util.Scanner;
/*
https://www.youtube.com/watch?v=714LTMNJy5M
Use this sight to build the formula.
*/
public class weekday {

    public static int dateTonum(int date){
        int num = 0;


        return num;
    }

    public static String weekdayPrint(int num) {
        String day = null;
        if (num == 6) {
            day = "Saturday";
        } else if (num == 5){
            day = "Friday";
        } else if (num == 4){
            day = "Thursday";
        } else if (num == 3){
            day = "Wednesday";
        } else if (num == 2){
            day = "Tuesday";
        } else if (num == 1){
            day = "Monday";
        } else if (num == 0){
            day = "Sunday";
        }
        return day;

    }


    public static void main(String[] args) {
        int date = 0;
        Scanner x = new Scanner(System.in);

        System.out.print("Enter date: ");
        date = x.nextInt();
        System.out.println();

        System.out.print("The day " +date +" is on a: ");

        System.out.println(weekdayPrint(dateTonum(date)));
    }
}
