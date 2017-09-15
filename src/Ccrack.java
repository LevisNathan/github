

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
        int tNum = i * -1;
        for (char c : tmp) {
            if (Character.isLetter(c)) {
                result = result + (char) (((c + tNum - (int) 'a') % 26) + (int) 'a');
            } else {
                result = result + c;
            }
        }

//        boolean test = false;
//        for (char c : result.toCharArray()) {
//            if(Character.isAlphabetic(c)) {
//                test =true;
//            }
//        }
//        if(test){
            System.out.println("key = " + tNum * -1 + ". Phrase: " + result + ".");
//        }
    }
    public static void main(String[]args){

        ask();
        for (int i = 0; i < 25; i++) {
            workDecode(i);
        }
    }
}
