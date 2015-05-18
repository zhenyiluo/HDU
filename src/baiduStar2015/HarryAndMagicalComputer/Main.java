package baiduStar2015.HarryAndMagicalComputer;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-5-18.
 */
public class Main {
    private static void solve(Scanner sc, PrintWriter pw) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] mark = new boolean[n];
        ArrayList<Integer>[] g = new ArrayList[n];
        for(int i = 0; i < n; i++){
            g[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < m; i++){
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            g[a].add(b);
        }

        while(true){
            boolean flag = false;
            for(int i = 0; i< n; i++){
                if(!mark[i]){
                    boolean tmp = true;
                    for(int num : g[i]){
                        if(!mark[num]){
                           tmp = false;
                            break;
                        }
                    }
                    if(tmp){
                        flag = true;
                        mark[i] = true;
                    }
                }
            }

            if(!flag){
                break;
            }
        }

        boolean ans = true;
        for(int i = 0; i < n && ans; i++){
            if(!mark[i]){
                ans = false;
            }
        }

        if(ans){
            pw.println("YES");
//            System.out.println("YES");
        }else{
            pw.println("NO");
//            System.out.println("NO");
        }
    }

    public static void main(String[] args){
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
