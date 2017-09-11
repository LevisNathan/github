import java.util.Scanner;

public class caesar {
    public static int choice=0;
    public static int num=0;
    public static String word;
    public static void intro(){
        Scanner pick = new Scanner(System.in);
        System.out.println("Type in 0 for encode, type 1 for decode: ");
        choice = pick.nextInt();
    }
    public static void number(){
        Scanner text = new  Scanner(System.in);
        System.out.print("Please enter key shift number: ");
        num = text.nextInt();
    }
    public static void ask(){
        int num=0;
        Scanner code = new Scanner(System.in);
        System.out.print("Please Enter the sentence you wish to");
        if (choice==0){
            System.out.print(" encode:");
            word = code.nextLine();
            workEncode();
        }else{
            System.out.print(" decode:");
            word = code.nextLine();
            workDecode();
        }
    }
    public static void workEncode(){

        char[] tmp = word.toCharArray();
        String result = "";
        for(char c: tmp){
            if(Character.isLetter(c)){
                result = result +(char)(((c + num - (int)'a') % 26) + (int)'a');
            } else {
                result = result + c;
            }
        }
        System.out.println(result);
    }
    public static void workDecode(){

        char tmp[]=word.toCharArray();
        String result = "";
        int tNum = num*-1;
        for(char c: tmp){
            if(Character.isLetter(c)){
                result = result +(char)(((c + tNum - (int)'a') % 26) + (int)'a');
            } else {
                result = result + c;
            }
        }
        System.out.println(result);
    }
    public static void main(String[]args){
        intro();
        number();
        ask();
    }
}
