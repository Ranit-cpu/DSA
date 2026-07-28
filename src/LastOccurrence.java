import java.util.Scanner;
import java.util.Arrays;

public class LastOccurrence {

    private static int lastOccurrence(int[] arr, int target){
        int start = 0, end = arr.length - 1;
        int ans = -1;

        while(start <= end){
            int mid = start + (end- start) / 2;

            if(arr[mid] == target){
                ans = mid;
                start = mid + 1;
            }
            else if(arr[mid] < target){
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the target element = ");
        int target  = scanner.nextInt();

        int[] arr = {1,2,5,8,5,6,8,7,3,5};

        Arrays.sort(arr);

        int ans = lastOccurrence(arr, target);
        System.out.println("Last Occurrence = " + ans);
    }
}