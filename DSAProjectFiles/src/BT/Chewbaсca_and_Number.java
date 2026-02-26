package BT;

import java.util.Scanner;

public class Chewbaсca_and_Number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int number = sc.nextInt();
        for (int i = 0; i < number; i++) {
            int t = sc.nextInt();
            if (x % 10 == t) {
                x=9-t;
            }
        }
        System.out.println(x);
    }
}