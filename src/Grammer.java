import java.util.Scanner;

public class Grammer {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        System.out.println(checks(word, 'A', 'Z') || checks(word, 'a', 'z') || checks(word.substring(1), 'a', 'z'));
    }

    private static boolean checks(String word, char start, char end){

        for(char ch : word.toCharArray()){
            if(ch < start || ch > end) {
                return false;
            }
        }
        return true;
    }

//    private static boolean allSmall(String word){
//        for(char ch : word.toCharArray()){
//            if(ch < 'a' || ch > 'z') {
//                return false;
//            }
//        }
//        return true;
//    }
}