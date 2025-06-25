class Solution {
    public boolean isAnagram(String s, String t) {
        // if (s.length() != t.length()) return false;

        // char[] sArr = s.toCharArray();
        // char[] tArr = t.toCharArray();

        // Arrays.sort(sArr);
        // Arrays.sort(tArr);

        // for (int i = 0; i < sArr.length; i++) {
        //     if (sArr[i] != tArr[i]) {
        //         return false;
        //     }
        // }

        // return true;

        // char[] sch = s.toCharArray();
        // char[] tch = t.toCharArray();

        // Arrays.sort(sch);
        // Arrays.sort(tch);
        // return Arrays.equals(sch, tch);


        // if (s.length() != t.length()) return false;
        // int[] count = new int[26];

        // for(int i= 0 ; i< s.length() ; i++) {
        //     count[s.charAt(i) - 'a']++;
        //     count[t.charAt(i) - 'a']--;
        // }

        // for (int c : count) {
        //     if (c != 0) return false;
        // }

        // return true;


        HashMap<Character , Integer > map = new HashMap<>();

        for(int i=0 ; i< s.length() ; i++){
            char ch = s.charAt(i);
            map.put(ch , map.getOrDefault(ch,  0) + 1);
        }

        for(int i=0 ; i < t.length();  i++) {
            char ch = t.charAt(i);
            
            if(map.containsKey(ch) == false) {
                return false;
            }
            else if(map.get(ch) == 1) {
                map.remove(ch);
            } else{
                map.put(ch , map.getOrDefault(ch, 0) - 1);
            }
        }
        return map.size() == 0;
    }
}