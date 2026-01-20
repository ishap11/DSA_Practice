class Solution {
    public List<Integer> countSmaller(int[] nums) {

        int n = nums.length;
        int[] index = new int[n];
        int[] count = new int[n];

        for (int i = 0; i < n; i++) index[i] = i;

        mergeSort(nums, index, count, 0, n - 1);

        List<Integer> ans = new ArrayList<>();
        for (int c : count) ans.add(c);
        return ans;
    }

    private void mergeSort(int[] nums, int[] index, int[] count, int l, int r) {
        if (l >= r) return;

        int mid = (l + r) / 2;
        mergeSort(nums, index, count, l, mid);
        mergeSort(nums, index, count, mid + 1, r);
        merge(nums, index, count, l, mid, r);
    }

    private void merge(int[] nums, int[] index, int[] count, int l, int mid, int r) {

        int[] temp = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0;
        int rightSmaller = 0;

        while (i <= mid && j <= r) {
            if (nums[index[j]] < nums[index[i]]) {
                rightSmaller++;
                temp[k++] = index[j++];
            } else {
                count[index[i]] += rightSmaller;
                temp[k++] = index[i++];
            }
        }

        while (i <= mid) {
            count[index[i]] += rightSmaller;
            temp[k++] = index[i++];
        }

        while (j <= r) {
            temp[k++] = index[j++];
        }

        for (int p = 0; p < temp.length; p++) {
            index[l + p] = temp[p];
        }
    }
}
