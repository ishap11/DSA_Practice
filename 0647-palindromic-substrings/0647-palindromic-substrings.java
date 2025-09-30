class Solution {
    public int countSubstrings(String s) {
        int n = s.length();

        int count = 0;

        for(int center = 0 ; center < 2*n-1 ; center++){
            int left = center/2;
            int right = left + center%2;

            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                count++;
                left--;
                right++;
            }
        }
        return count;
    }
}

/*
Step 1: How left and right are chosen

center / 2 → decides the left index.

center % 2 → decides if we take odd or even length palindrome.

Example for string "aaa", n = 3:

total centers = 2*3 - 1 = 5 → centers: 0,1,2,3,4

center	left	right	Meaning
0	0	0	Palindrome at index 0 ('a')
1	0	1	Between 0 and 1 ("aa")
2	1	1	Palindrome at index 1 ('a')
3	1	2	Between 1 and 2 ("aa")
4	2	2	Palindrome at index 2 ('a')
Step 2: Expanding

Inside the while loop:

As long as left and right are valid indices and characters match → it's a palindrome.

Every expansion gives us 1 palindrome.

Then expand outward: left--, right++.

Example:

For "aaa" at center = 2 (left=1, right=1):

"a" → count++

expand → left=0, right=2 → "aaa" → count++

✅ Dry Run on "aaa"

Palindromes found:

center 0 → "a"

center 1 → "aa"

center 2 → "a", "aaa"

center 3 → "aa"

center 4 → "a"

Total = 6 palindromes.

✅ Dry Run on "abc"

Palindromes found:

center 0 → "a"

center 1 → (fails, "a" != "b")

center 2 → "b"

center 3 → (fails, "b" != "c")

center 4 → "c"

Total = 3 palindromes.
 */