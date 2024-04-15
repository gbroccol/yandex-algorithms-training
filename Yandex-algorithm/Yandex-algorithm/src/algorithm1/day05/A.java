package algorithm1.day05;

// Яндекс. Тренировки по алгоритмам июнь 2021

// A. Стильная одежда

// Глеб обожает шоппинг. Как-то раз он загорелся идеей подобрать себе майку и штаны так, чтобы выглядеть в них максимально стильно.
// В понимании Глеба стильность одежды тем больше, чем меньше разница в цвете элементов его одежды.

// В наличии имеется N (1 ≤ N ≤ 100.000) маек и M (1 ≤ M ≤ 100.000) штанов, про каждый элемент известен его цвет
// (целое число от 1 до 10.000.000). Помогите Глебу выбрать одну майку и одни штаны так,
// чтобы разница в их цвете была как можно меньше.

// Формат ввода
// Сначала вводится информация о майках: в первой строке целое число N (1 ≤ N ≤ 100.000)
// и во второй N целых чисел от 1 до 10.000.000 — цвета имеющихся в наличии маек.
// Гарантируется, что номера цветов идут в возрастающем порядке (в частности, цвета никаких двух маек не совпадают).

// Далее в том же формате идёт описание штанов: их количество M (1 ≤ M ≤ 100.000)
// и в следующей строке M целых чисел от 1 до 10.000.000 в возрастающем порядке — цвета штанов.

// Формат вывода
// Выведите пару неотрицательных чисел — цвет майки и цвет штанов, которые следует выбрать Глебу. Если вариантов выбора несколько, выведите любой из них.

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

        int val = Integer.parseInt(reader.readLine());
        int[] clothes1 = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int val2 = Integer.parseInt(reader.readLine());
        int[] clothes2 = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int i = 0;
        int j = 0;

        int c1 = clothes1[i];
        int c2 = clothes2[j];

        while (i < clothes1.length && j < clothes2.length) {

            if (Math.abs(c1 - c2) > Math.abs(clothes1[i] - clothes2[j])) {
                c1 = clothes1[i];
                c2 = clothes2[j];
            }

            if (clothes1[i] < clothes2[j]) {
                i++;
            } else {
                j++;
            }
        }

        writer.write(c1+ " " + c2 + "\n");
        writer.flush();
    }
}