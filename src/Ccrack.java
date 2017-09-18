

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Scanner;

public class Ccrack {

    public static String word;
    public static void ask(){
        int num=0;
        Scanner code = new Scanner(System.in);
        System.out.print("Please Enter the sentence you wish to");
            System.out.print(" decode:");
            word = code.nextLine();
        }
    public static void workDecode(int i) {

        char tmp[] = word.toCharArray();
        String result = "";
        int tNum = i ;
        for (char c : tmp) {
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    result = result + (char) (((c + tNum - (int) 'A') % 26) + (int) 'A');
                } else if (Character.isLowerCase(c)) {
                    result = result + (char) (((c + tNum - (int) 'a') % 26) + (int) 'a');
                }
            }else {
                result = result + c;
            }
        }
            System.out.println("key = " + tNum + ". Phrase: " + result + ".");

    }
    public static void main(String[]args){

        ask();
        for (int i = 0; i < 25; i++) {
            workDecode(i);
        }
    }
}
