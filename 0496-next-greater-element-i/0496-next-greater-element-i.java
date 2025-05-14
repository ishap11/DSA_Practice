class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // BRUTE FORCE
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     int[] res = new int[nums1.length] ;

    //     for (int i = 0; i < nums2.length; i++) {
    //     int nextGreater = -1;

    //     for (int j = i + 1; j < nums2.length; j++) {
    //         if (nums2[j] > nums2[i]) {
    //             nextGreater = nums2[j];
    //             break; 
    //         }
    //     }

    //     map.put(nums2[i], nextGreater); 
    //    }
 

    //     for(int i=0 ; i< nums1.length ; i++) {
    //         res[i] = map.getOrDefault(nums1[i], -1);
    //     }

    //     return res;


    // ================CODE =======================================

        // HashMap<Integer, Integer> map = new HashMap<>(); 
        // Stack<Integer> stack = new Stack<>();

        // for (int i = nums2.length - 1; i >= 0; i--) {
        //     int current = nums2[i];

        
        //     while (!stack.isEmpty() && stack.peek() <= current) {
        //         stack.pop();
        //     }

        //     int nextGreater = stack.isEmpty() ? -1 : stack.peek();
        //     map.put(current, nextGreater);

        //     stack.push(current);
        // }

        // int[] result = new int[nums1.length];
        // for (int i = 0; i < nums1.length; i++) {
        //     result[i] = map.getOrDefault(nums1[i], -1);
        // }

        // return result;



        // ==================CODE========================
        int n= nums2.length;
        Stack<Integer> st = new Stack<>();
        int[] nextGreater = new int[10001];
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && st.peek()<=nums2[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                nextGreater[nums2[i]]=-1;
            }
            else
            {
                nextGreater[nums2[i]]=st.peek();
            }
            st.push(nums2[i]);
        }

        for(int i=0;i<nums1.length;i++)
        {
            nums1[i]= nextGreater[nums1[i]];
        }
        return nums1;
    
    }
}