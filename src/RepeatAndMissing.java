// Find the repeating and Missing numbers in the array

public class RepeatAndMissing {

    private static int[] findRepeatAndMissingBrute(int[] arr){
        int[] hasharr = new int[arr.length+1];
        int repeat = -1;
        int missing  =-1;

        for (int j : arr) {
            hasharr[j]++;
        }

        for(int i  = 1; i <= hasharr.length;i++){
            if(hasharr[i] == 2) repeat = i;
            else if(hasharr[i]==0) missing = i;

            if(repeat!=-1&&missing!=-1)
                break;
        }

        return new int[]{repeat,missing};
    }

    private static int[] findRepeatAndMissingOptimal(int[] arr){
        //S-Sn
        //S2 -Sn2
        long n = arr.length;
        long Sn = (n*(n+1)) / 2;
        long Sn2 = (n*(n+1) *(2*n+1)) /6;
        long S = 0, S2 = 0;

        for (int i :arr) {
            S +=i;
            S2 += (long) i * i;
        }

        long val1 = S - Sn;
        long val2  =S2 -Sn2;

        val2 = val2/val1;

        long repeat = (val1+val2)/2;
        long missing = repeat - val1;

        return new int[] {(int)repeat,(int)missing};
    }

    public static void main(String[] args){
        int[] arr = {4,3,6,2,1,2};

        int[] ans = findRepeatAndMissingOptimal(arr);
        System.out.println("The repeating number is = "+ans[0]+" And The Missing number is = " +ans[1]);
    }
}