class Solution {
    public int numRescueBoats(int[] people, int limit) {

        // TC - O(nlogn) SC - O(1)
        int count =0;
        Arrays.sort(people);
        int i=0;
        int j= people.length -1;

        while(i <= j){
            int sum = people[i] + people[j];
            if(sum <= limit){
                count++;
                i++;
                j--;
            }else{
                count++;
                j--;
            }
        }
        return count;
    }
}