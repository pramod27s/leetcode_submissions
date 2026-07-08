class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = Integer.MAX_VALUE;

        int left = 1;
        int right = 0;
        for (int pile : piles) {
            if (pile > right) {
                right = pile;
            }
        }
        int mid = 0;
        int ans = right;

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (add(piles, mid) <= h) {
                ans = mid;
                right = mid - 1;
            }
            if (add(piles, mid) > h) {
                left = mid + 1;
            }

        }

        return ans;

    }

    private long add(int[] piles, int k) {
        long sum = 0;

        for (int pile : piles) {
            sum += (pile + k - 1) / k;
        }

        return sum;

    }
}