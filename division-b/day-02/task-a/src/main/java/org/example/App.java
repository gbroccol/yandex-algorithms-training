package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// не проходит тест №5

public class App 
{
    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        List<Integer> numbers = new ArrayList<>();
        while (true) {
            String str = br.readLine();
            if (str.equals("") || Integer.parseInt(str) == 0) break;
            numbers.add(Integer.parseInt(str));
        }
        System.out.println(App.getResult(numbers));
    }

    public static int getResult(List<Integer> numbers) {

        if (numbers == null || numbers.size() == 0 || numbers.get(0) == 0)
            return 0;

        int count = 1;
        int max = numbers.get(0);

        for (int i = 1; i < numbers.size() - 1; i++) {

            if (max < numbers.get(i)) {
                max = numbers.get(i);
                count = 1;
            } else if (max == numbers.get(i)) {
                count++;
            }
            if (numbers.get(i) == 0) break;
        }
        return count;
    }
}
