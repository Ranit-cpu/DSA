class FloorAndCeil {
    public static int[] getFloorAndCeil(int[] nums, int x) {

        int low = 0, high = nums.length - 1;
        int floor = -1, ceil = -1;


        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] <= x){
                floor = nums[mid];
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        low = 0;
        high = nums.length - 1;

        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] >= x){
                ceil = nums[mid];
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return new int[]{floor,ceil};
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 7, 8, 10};
        int x = 5;
//        Solution finder = new Solution();
        int[] res = getFloorAndCeil(arr, x);
        System.out.println("The floor and ceil are: " + res[0] + ", " + res[1]+" respectively.");
    }
}