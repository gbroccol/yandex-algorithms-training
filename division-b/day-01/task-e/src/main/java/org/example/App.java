package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Падает на втором тесте

public class App 
{
    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        int d = Integer.parseInt(br.readLine());
        String[] strings = br.readLine().split(" ");
        int[] point = new int[strings.length];
        System.out.println(App.getResult(d, point[0], point[1]));
    }

    public static int getResult(int d, int xo, int yo) {

        // найти все случаи, когда точка лежит за пределами квадрата
        // если вошли внутрь, посчитать длины отрезков
        if (d >= 0 && (yo < 0 || xo < 0 || yo > d - xo) ||
                (d <= 0 && (yo > 0 || xo > 0 || yo < d - xo))) {

            int xa = 0, ya = 0;
            int xb = d, yb = 0;
            int xc = 0, yc = d;

            double lenA = getSegmentLength(xa, ya, xo, yo);
            double lenB = getSegmentLength(xb, yb, xo, yo);
            double lenC = getSegmentLength(xc, yc, xo, yo);

            if (lenA <= lenB && lenA <= lenC) return 1;
            else if (lenB <= lenC) return 2;
            return 3;
        }
        return 0;
    }

    private static double getSegmentLength(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
