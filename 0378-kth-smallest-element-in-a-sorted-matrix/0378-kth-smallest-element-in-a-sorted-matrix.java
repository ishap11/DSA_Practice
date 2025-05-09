class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        // Step 1: Flatten the matrix into a 1D array
        List<Integer> flattened = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                flattened.add(matrix[i][j]);
            }
        }

        // Step 2: Sort the flattened array
        Collections.sort(flattened);
        
        // Step 3: Return the k-th smallest element
        return flattened.get(k - 1);
    }
}