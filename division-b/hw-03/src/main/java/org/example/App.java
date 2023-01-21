package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App
{
    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        int c = Integer.parseInt(str[2]);

        System.out.println(App.getResult(a, b, c));
    }

    public static int getResult(int x, int y, int year) {
        if (x > 12 || y > 12 || x == y) return 1;
        return 0;
    }
}
