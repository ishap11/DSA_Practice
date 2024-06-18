class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        HashMap<Character , Integer> map = new HashMap<>();
        for(char ch : p.toCharArray()){
            map.put(ch , map.getOrDefault(ch , 0)+1);
        }
        int count = map.size();

        List<Integer > ans = new ArrayList<>();
        int i=0;
        int j =0;
        int k  = p.length();
        

        while(j< s.length()){
            // calculations
            char ch1 = s.charAt(j);
            if(map.containsKey(ch1)){
                map.put(ch1 , map.get(ch1)-1);
                if(map.get(ch1) == 0){
                    count--;
                }
            }
            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
                // ans
                if(count == 0){
                    ans.add(i);
                }
                char ch2 = s.charAt(i);
                if(map.containsKey(ch2)){
                    map.put(ch2  , map.get(ch2)+1);
                    if(map.get(ch2) == 1){
                        count++;
                    }
                }
                // slide window
                i++;
                j++;
            }
        }
        return ans;
    }
}