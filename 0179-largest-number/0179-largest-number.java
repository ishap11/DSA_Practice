class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            arr[i] = nums[i] + "";
        }

        Arrays.sort(arr , (a,b)->{
            String ab = a + b;
            String ba = b + a;

            if (ab.compareTo(ba) > 0) {
                return 1;
            } else if (ab.compareTo(ba) < 0) {
                return -1;
            } else {
                return 0;
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i = arr.length - 1 ; i >= 0 ; i--){
            sb.append(arr[i]);
        }

        if(sb.charAt(0) == '0'){
            return "0";
        }

        return sb.toString();
    }
}