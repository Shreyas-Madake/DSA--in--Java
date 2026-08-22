package SDE_sheet;

public class Q51_checkDivisibility {
    public boolean checkDivisibility(int n) {
        int temp = n;
        int sum = 0;
        int pro = 1;

        while (temp > 0) {
            int rem = temp % 10;
            sum += rem;
            pro *= rem;
            temp /= 10;
        }
// we used temp as Condition 1: The problem requires processing individual digits of a number (which means using % 10 and / 10 inside a loop).
//
//Condition 2: The problem requires comparing or dividing the original complete number at the end.
        int totalSum = sum + pro;
        return n % totalSum == 0;
    }
}
