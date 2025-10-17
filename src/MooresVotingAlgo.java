//import java.io.*;

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
      public static void main(String[] args)
      {
            int[] arr = { 1, 2, 2, 2, 1, 1 };
            int majority = findMajority(arr);
            System.out.println(" The majority element is : "+ majority);
      }
}
