class Solution {
    public String fractionToDecimal(int numerator, int denominator) {

        if(numerator == 0) return "0";

        boolean isNegative = (numerator < 0) ^ (denominator < 0);

        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        long ans = num / den;
        long rem = num % den;

        StringBuilder sb = new StringBuilder();
        if(isNegative) sb.append("-");
        sb.append(ans);

        if(rem == 0){
            return sb.toString();
        }

        sb.append('.');

        HashMap<Long , Integer> map = new HashMap<>();

        while(rem != 0){
            if(map.containsKey(rem)){
                int idx = map.get(rem);
                sb.insert(idx, '(');
                sb.append(')');
                break;
            }
            map.put(rem, sb.length());
            rem *= 10;
            sb.append(rem / den);
            rem %= den;
        }

        return sb.toString();
    }
}
