import java.util.Scanner;

public class Lexography {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String[] strs = new String[n];

        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
        }

        int cols = strs[0].length();
        int count = 0;

        for (int i = 0; i < cols; i++) {
            for (int j = 1; j < n; j++) {
                if(strs[j].charAt(i) < strs[j-1].charAt(i)){
                    count ++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
