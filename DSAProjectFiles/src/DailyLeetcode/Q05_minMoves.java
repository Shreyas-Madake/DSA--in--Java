package DailyLeetcode;

public class Q05_minMoves {
    public int minMoves(int[] nums) {
        int n = nums.length;

        int sum = 0;
        int minEl = nums[0];
        //we first find out the min
        for(int n1:nums){

            if (n1 < minEl) {
                minEl = n1;
            }

        }

        // then subtract the min with every element and took its sum
        // we did as we needed to make them similar so instead of adding it we just subtracted so we can know how many steps each element needs to be like min elemnt
        for (int num : nums) {


            sum =sum+(num-minEl);
        }

        return sum ;
    }
}
