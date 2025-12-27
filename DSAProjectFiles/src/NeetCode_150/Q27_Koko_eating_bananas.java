package NeetCode_150;

public class Q27_Koko_eating_bananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canEat(piles, h, mid)) {
                right = mid;  // Try a slower speed
            } else {
                left = mid + 1;  // Need faster speed
            }
        }

        return left;  // left == right, the minimum valid k
    }

    private boolean canEat(int[] piles, int h, int speed) {
        long hours = 0;
        for (int pile : piles) {
            hours += (pile + speed - 1) / speed;
            if (hours > h) return false;
        }
        return hours <= h;
    }
}
