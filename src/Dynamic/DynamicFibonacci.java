package Dynamic;

import java.util.Scanner;

public class DynamicFibonacci {

    public static void main(String[] args){

        int n;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of the series = ");
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println(fib(i)+" ");
        }

    }

    private static int fib(int n){
        if(n <= 1)
            return n;
        return fib(n-1) + fib(n-2);
    }
}