class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        String ans ="";

        HashMap<Character , Integer> map2 = new HashMap<>();
        for(int i=0; i< t.length() ; i++){
            char ch = t.charAt(i);
            map2.put(ch , map2.getOrDefault(ch,0) +1);
        }

        int mct =0;
        int dmct = t.length();

        HashMap<Character , Integer> map1 = new HashMap<>();
        int i= -1;
        int j= -1;
        
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            // acquire
            while(i< s.length()-1 && mct < dmct ){
                i++;
                char ch = s.charAt(i);
                map1.put(ch , map1.getOrDefault(ch,0) +1);

                if(map1.get(ch).intValue() <= map2.getOrDefault(ch, 0).intValue() ){
                    mct++;
                }
                f1 = true;
            }
         

            // collect ans and release
            while(j < i && mct == dmct){
                String pans = s.substring(j + 1, i + 1);
                
                if(ans.isEmpty()|| pans.length() < ans.length()){
                    ans = pans;
                }
                j++;

                char ch = s.charAt(j);

                if(map1.get(ch) == 1){
                    map1.remove(ch);
                }else{
                    map1.put(ch , map1.get(ch) - 1);
                }
                if(map1.getOrDefault(ch,0)  < map2.getOrDefault(ch,0) ){
                    mct--;
                }
                f2 = true;
            }
            if (!f1 && !f2) break;
        }
        return ans;   
    }
}