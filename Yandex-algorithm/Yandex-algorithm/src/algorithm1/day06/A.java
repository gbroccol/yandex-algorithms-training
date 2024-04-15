package algorithm1.day06;

// Яндекс. Тренировки по алгоритмам июнь 2021

// A. Двоичный поиск

// Реализуйте двоичный поиск в массиве

// Формат ввода
// В первой строке входных данных содержатся натуральные числа N и K ().
// Во второй строке задаются N элементов первого массива, а в третьей строке – K элементов второго массива.
// Элементы обоих массивов - целые числа, каждое из которых по модулю не превосходит 109

// Формат вывода
// Требуется для каждого из K чисел вывести в отдельную строку "YES",
// если это число встречается в первом массиве, и "NO" в противном случае.

import java.io.*;
import java.util.Arrays;

public class A {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        alg(reader, writer);
        reader.close();
        writer.close();
    }

    public static void alg(BufferedReader reader, BufferedWriter writer) throws IOException {

        String str = reader.readLine();

        int[] arr1 = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int[] arr2 = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int j : arr2) {
            if (hasNumber(arr1, j)) {
                writer.write("YES\n");
            } else {
                writer.write("NO\n");
            }
        }

        writer.flush();
    }

    public static boolean hasNumber(int[] arr, int target) {

        int from = 0;
        int to = arr.length - 1;
        int mid = to / 2;
        int res = guess(arr, mid, target);

        while (res != 0 && from <= to) {
            mid = from + ((to - from) / 2);
            res = guess(arr, mid, target);

            if (res == -1) {
                to = mid - 1;
            } else {
                from = mid + 1;
            }
        }
        return res == 0;
    }

    public static int guess(int[] arr, int mid, int target) {
        if (arr[mid] == target) return 0;
        else if (arr[mid] > target) return -1; // too big
        return 1; // too small
    }
}