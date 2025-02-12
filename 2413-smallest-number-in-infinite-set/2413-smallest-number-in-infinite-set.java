class SmallestInfiniteSet {

    private TreeSet<Integer> set;
    private int nextNum;

    public SmallestInfiniteSet() {
        set = new TreeSet<>();
        nextNum = 1;
    }
    
    public int popSmallest() {
        if(!set.isEmpty()) {
           return set.pollFirst();
        }
        return nextNum++;
    }
    
    public void addBack(int num) {
        if(num < nextNum && !set.contains(num)) {
            set.add(num);
        } 
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */