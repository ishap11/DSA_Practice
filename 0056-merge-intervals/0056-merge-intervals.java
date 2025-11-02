import java.util.*;

class Solution {
    static class Pair implements Comparable<Pair> {
        int st;
        int et;
        
        Pair(int st , int et){
            this.st = st;
            this.et = et;
        }
        
        public int compareTo(Pair o){
            if(this.st == o.st){
                return this.et - o.et;
            } else {
                return this.st - o.st;
            }
        }
    }
    
    public int[][] merge(int[][] intervals) {
        // Step 1: Convert to Pair array
        Pair[] pairs = new Pair[intervals.length];
        for(int i = 0 ; i < intervals.length ; i++){
            pairs[i] = new Pair(intervals[i][0], intervals[i][1]);
        }
        
        // Step 2: Sort by start time (and then end time)
        Arrays.sort(pairs);
        
        // Step 3: Use stack to merge
        Stack<Pair> st = new Stack<>();
        for(int i = 0 ; i < pairs.length ; i++){
            if(st.isEmpty()){
                st.push(pairs[i]);
            } else {
                if(st.peek().et < pairs[i].st){
                    st.push(pairs[i]); // no overlap
                } else {
                    // merge overlapping intervals
                    st.peek().et = Math.max(st.peek().et, pairs[i].et);
                }
            }
        }
        
        // Step 4: Convert stack to sorted list
        ArrayList<Pair> list = new ArrayList<>(st);
        Collections.sort(list, (a, b) -> a.st - b.st);
        
        // Step 5: Convert to int[][] for LeetCode output
        int[][] res = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            res[i][0] = list.get(i).st;
            res[i][1] = list.get(i).et;
        }
        
        return res;
    }
}
