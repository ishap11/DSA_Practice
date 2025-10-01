class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int toalCost =0;
        int totalGas = 0;

        int currGas = 0;
        int start = 0;

        for(int i = 0 ; i< gas.length ; i++){
            totalGas += gas[i];
            toalCost += cost[i];

            currGas += gas[i] - cost[i];

            if(currGas < 0){
                start = i+1;
                currGas  = 0;
            }
        }

        return toalCost > totalGas ? -1 : start;
    }
}