package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App 
{

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        System.out.println(App.getResult(a, b, c));
    }

    public static int getResult(int taskCode, int iteratorCode, int checkerCode) {

        if (iteratorCode == 0) {
            if (taskCode != 0)
                return 3;
            return checkerCode;
        } else if (iteratorCode == 1) {
            return checkerCode;
        } else if (iteratorCode == 4) {
            if (taskCode != 0)
                return 3;
            return 4;
        } else if (iteratorCode == 6) {
            return 0;
        } else if (iteratorCode == 7) {
            return 1;
        }
        return iteratorCode;
    }
}
