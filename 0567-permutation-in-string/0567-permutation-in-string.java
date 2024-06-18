class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character , Integer > map = new HashMap<>();
        for(char ch : s1.toCharArray()){
            map.put(ch , map.getOrDefault(ch , 0)+1);
        }
        int count = map.size();
        int i=0;
        int j=0;
        int ans = 0;
        int k = s1.length();
        boolean flag = false;

        while(j< s2.length()){
            char ch  = s2.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch , map.get(ch)-1);
                if(map.get(ch) == 0){
                    count--;
                }
            }
            if(j-i+1 < k){
                j++;
            }
            else if(j-i+1 ==k){
                if(count == 0) {
                    flag = true;
                    return true;
                }
                char ch1 = s2.charAt(i);
                if(map.containsKey(ch1)) {
                    map.put(ch1 , map.get(ch1)+1);
                    if(map.get(ch1) == 1){
                        count++;
                    }
                }
                i++;
                j++;
            }

        }
        return false;
    }
}