package baiduStar2015.HaveMeal;

/**
 * Created by Zhenyi Luo on 15-5-18.
 */

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    private static void solve(Scanner sc, PrintWriter pw) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        pw.println((m-1)% n);
//        System.out.println((m-1)% n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        while(sc.hasNextInt()){
            solve(sc, pw);
        }
        pw.close();
        pw.flush();
        sc.close();
    }
}