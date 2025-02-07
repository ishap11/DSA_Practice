class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();

        int i=0; 
        int j = s.length() -1;

        while(i<j) {
            if(isVowel(arr[i]) && isVowel(arr[j])) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }else if(isVowel(arr[i])){
                j--;
            }else if(isVowel(arr[j])){
                i++;
            }else{
                i++;
                j--;
            }
        }
        return new String(arr);
    }

    boolean isVowel(char ch) {
        if(ch == 'a' || ch == 'A') return true;
        else if(ch == 'e' || ch == 'E') return true;
        else if(ch == 'i' || ch =='I') return true;
        else if(ch == 'o' || ch =='O') return true;
        else if(ch == 'u' || ch =='U') return true;
        else return false;
    }
}