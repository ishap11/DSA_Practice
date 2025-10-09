class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return new ArrayList<>();
        }

        return getKpc(digits);
    }

    String[] codes = {"" , "" , "abc" , "def" , "ghi" , "jkl" , "mno" , "pqrs" , "tuv" , "wxyz"};

    public List<String> getKpc(String str){
        if(str.length() == 0){
            List<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        char ch = str.charAt(0);
        String res = str.substring(1);

        List<String> rres = getKpc(res);
        List<String> mres = new ArrayList<>();

        String chcode = codes[ch - '0'];
        for(int i = 0 ; i< chcode.length() ;i++){
            char code = chcode.charAt(i);

            for(String s : rres){
                mres.add(code + s);
            }
        }

        return mres;
    }
}