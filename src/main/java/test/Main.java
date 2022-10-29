package test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            int res = sc.nextInt();
            while (n --> 1) {
                int a = sc.nextInt();
                res = Lcmm(res, a);
            }
            System.out.println(res);
        }
    }

    private static int Lcmm(int res, int a) {
        return res / gcd(res, a) * a;
    }

    private static int gcd(int res, int a) {
        int c = res % a;
        while (c != 0) {
            res = a;
            a = c;
            c = res % a;
        }
        return a;
    }
}
