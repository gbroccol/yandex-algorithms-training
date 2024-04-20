package algorithm1.day05;

import java.io.*;
import java.util.Arrays;

public class B {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        alg(reader, writer);
        reader.close();
        writer.close();
    }

    public static void alg(BufferedReader reader, BufferedWriter writer) throws IOException {

        int[] firstLine = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int N = firstLine[0]; // car amount
        int K = firstLine[1]; // lucky number

        int[] cars = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int count = 0;
        int sum = 0;
        int left = 0;

        for (int right = 0; right < N; right++) {
            sum += cars[right];

            while (sum > K && left < right) {
                sum -= cars[left];
                left++;
            }

            if (sum == K) {
                count++;
            }
        }

        writer.write(String.valueOf(count));
        writer.flush();
    }
}