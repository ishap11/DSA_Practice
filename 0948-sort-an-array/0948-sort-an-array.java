class Solution {

    public static void merge(int[]nums, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;  
        int right = mid + 1; 

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            } else {
                temp.add(nums[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(nums[left]);
            left++;
        }
        while (right <= high) {
            temp.add(nums[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
    }

    public static void mergeSort(int[] nums, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2 ;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high); 
        merge(nums, low, mid, high); 
    }

    public int[] sortArray(int[] nums) {

        // Brute force -> TC- O(nlogn) SC - O(1)
        // Arrays.sort(nums);
        // return nums;

        // TLE =>Insertion sort
        // for(int i=1; i< nums.length; i++){
        //     int key = nums[i];
        //     int j = i-1;
        //     while (j >= 0 && nums[j] > key) {
        //         nums[j + 1] = nums[j];
        //         j = j - 1;
        //     }
        //     nums[j + 1] = key;
        // }
        // return nums;

        // merge sort ->TC -O(nlogn) SC -O(n)
        int low = 0;
        int high = nums.length - 1;
        mergeSort(nums, low, high);
        return nums;
        
    }
    
}