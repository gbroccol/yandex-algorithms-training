package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App 
{
    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        int childrenCount = Integer.parseInt(br.readLine());
        String[] strings = br.readLine().split(" ");
        int[] studentsHomeCoordArr = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            studentsHomeCoordArr[i] = Integer.parseInt(strings[i]);
        }
        System.out.println(App.getResult(childrenCount, studentsHomeCoordArr));
    }

    public static int getResult(int studentsCount, int[] studentsHomeCoordArr) {

        double lowMiddle = Math.floor((studentsCount - 1) / 2);
        double highMiddle = Math.ceil((studentsCount - 1) / 2);
        double median = (studentsHomeCoordArr[(int)lowMiddle] + studentsHomeCoordArr[(int)highMiddle]) / 2;

        return (int) Math.round(median);
    }
}