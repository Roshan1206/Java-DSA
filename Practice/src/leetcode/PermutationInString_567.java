package leetcode;

class PermutationInString_567 {

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
    }
    public static boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for (int i = 0; i < n; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) matches++;
        }

        if (matches == 26) return true;

        for (int i = n; i < m; i++) {
            int outChar = s2.charAt(i - n) - 'a';
            int inChar = s2.charAt(i) - 'a';

            // remove outgoing char from window
            if (s2Count[outChar] == s1Count[outChar]) matches--;
            s2Count[outChar]--;
            if (s2Count[outChar] == s1Count[outChar]) matches++;

            // add incoming char to window
            if (s2Count[inChar] == s1Count[inChar]) matches--;
            s2Count[inChar]++;
            if (s2Count[inChar] == s1Count[inChar]) matches++;

            if (matches == 26) return true;
        }

        return false;
    }
}