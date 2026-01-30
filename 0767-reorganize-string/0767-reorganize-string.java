class Solution {
    public String reorganizeString(String s) {
        HashMap<Character , Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);

            map.put(ch , map.getOrDefault(ch , 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a ,b) -> map.get(b) - map.get(a));
        pq.addAll(map.keySet());

        StringBuilder sb = new StringBuilder();
        char prev = '#';

        while(pq.size() > 0){
            char curr = pq.remove();

            sb.append(curr);
            map.put(curr , map.get(curr) - 1);

            if(prev != '#' && map.get(prev) > 0){
                pq.add(prev);
            }

            prev = curr;
        }

        return s.length() == sb.length() ? sb.toString() : "";
    }
}