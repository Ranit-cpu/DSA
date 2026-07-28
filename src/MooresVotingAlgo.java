import java.util.Scanner;

class MooresVotingAlgo
{
      // Function to find majority element
      public static int findMajority(int[] nums)
      {
            int count = 0, candidate = -1;
            
            // Finding majority candidate
            for (int index = 0; index < nums.length; index++) {
                  if (count == 0) {
                        candidate = nums[index];
                        count = 1;
                  }
                  else {
                        if (nums[index] == candidate)
                              count++;
                        else
                              count--;
                  }
            }
            
            //return candidate;
            
            // Checking if majority candidate occurs more than
            // n/2 times
            count = 0;
            for(int index = 0; index < nums.length; index++)
            {
                  if (nums[index] == candidate)
                        count++;
            }
            if (count > (nums.length / 2))
                  return candidate;
            return -1;
      }
      
      // Driver code
      public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);

          System.out.println("Enter elements (space separated):");
          String input = sc.nextLine();

          String[] parts = input.trim().split("\\s+");
          int[] arr = new int[parts.length];

          for (int i = 0; i < parts.length; i++) {
              arr[i] = Integer.parseInt(parts[i]);
          }

          int majority = findMajority(arr);

          if (majority != -1)
              System.out.println("The majority element is: " + majority);
          else
              System.out.println("No majority element found.");

          sc.close();
      }
}
