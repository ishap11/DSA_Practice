class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        // Arrays.sort(target);
        // Arrays.sort(arr);

        // return Arrays.equals(target, arr);


        HashMap<Integer , Integer > map = new HashMap<>();
        for(int num : target){
            map.put(num , map.getOrDefault(num , 0)+1);
        }

        for(int num : arr){
            if(!map.containsKey(num)){
                return false;
            }
            int count = map.get(num);
                if (count == 1) {
                   map.remove(num);
            } else {
                map.put(num, count - 1);
            }
        }
        return map.isEmpty();
    }

}