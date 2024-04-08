package algorithm1.day03;

// Яндекс. Тренировки по алгоритмам июнь 2021, занятие 1

// A. Количество различных чисел

// Дан список чисел, который может содержать до 100000 чисел. Определите, сколько в нем встречается различных чисел.

// Формат ввода
// Вводится список целых чисел. Все числа списка находятся на одной строке.

// Формат вывода
// Выведите ответ на задачу.

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class A {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split(" ");
        sc.close();

        int[] intArr = new int[strArr.length];
        int i = 0;
        for (String s : strArr) {
            intArr[i] = Integer.parseInt(s);
            i++;
        }

        System.out.println(func(intArr));
    }

    public static int func(int[] nmbArray) {

        Set<Integer> set = new HashSet<> ();

        for (int j : nmbArray) {
            set.add(j);
        }

        return set.size();
    }

}