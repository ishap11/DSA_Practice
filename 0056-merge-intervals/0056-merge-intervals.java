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
        Pair[] pairs = new Pair[intervals.length];
        for(int i = 0 ; i < intervals.length ; i++){
            pairs[i] = new Pair(intervals[i][0], intervals[i][1]);
        }
        Arrays.sort(pairs);
        
        Stack<Pair> st = new Stack<>();
        for(int i = 0 ; i < pairs.length ; i++){
            if(st.isEmpty()){
                st.push(pairs[i]);
            } else {
                if(st.peek().et < pairs[i].st){
                    st.push(pairs[i]); 
                } else {
                    st.peek().et = Math.max(st.peek().et, pairs[i].et);
                }
            }
        }

        ArrayList<Pair> list = new ArrayList<>(st);
        Collections.sort(list, (a, b) -> a.st - b.st);
    
        int[][] res = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            res[i][0] = list.get(i).st;
            res[i][1] = list.get(i).et;
        }
        
        return res;
    }
}
