class Solution {
    public int characterReplacement(String s, int k) {

        int[] counts = new int[26];
        int i = 0, max = 0, maxFreq = 0;

        for (int j = 0; j < s.length(); j++) {
            counts[s.charAt(j) - 'A']++;
            maxFreq = Math.max(maxFreq, counts[s.charAt(j) - 'A']);
            
            while ((j - i + 1) - maxFreq > k) {
                counts[s.charAt(i) - 'A']--;
                i++;
            }
            max = Math.max(max, j - i + 1);
        }

        return max;
    }
}