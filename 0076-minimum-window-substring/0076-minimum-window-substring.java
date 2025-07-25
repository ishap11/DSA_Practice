class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        String ans = "" ;
        HashMap<Character , Integer> map1 = new HashMap<>();
        for(int i=0 ; i< t.length() ; i++) {
            char ch = t.charAt(i);
            map1.put(ch , map1.getOrDefault(ch , 0)+1);
        }

        int mct = 0;
        int dmct = t.length();
        int i= -1;
        int j = -1;
        HashMap<Character , Integer> map2 = new HashMap<>();

        while(true) {
             boolean f1 = false;
            boolean f2 = false;
            while(i< s.length() - 1 && mct < dmct) {
                f1 = true;

                i++;
                char ch = s.charAt(i);

                map2.put(ch , map2.getOrDefault(ch , 0) + 1);

                if(map2.getOrDefault(ch , 0) <= map1.getOrDefault(ch , 0) ){
                    mct++;
                }
            }

            while(j<i && mct == dmct) {
                f2 = true;
                String pans = s.substring(j+1 , i+1);

                if(ans.length() == 0 || pans.length() < ans.length()) {
                    ans = pans;
                }

                j++;
                char ch = s.charAt(j);

                if(map2.get(ch) == 1) {
                    map2.remove(ch);
                } else {
                    map2.put(ch  ,map2.get(ch) - 1);
                }

                if(map2.getOrDefault(ch , 0) < map1.getOrDefault(ch , 0 )) {
                    mct--;
                }
            }

            if(f1 == false && f2 == false) break;
        }
        return ans;
    }
}