package algorithm1.day02;

// Яндекс. Тренировки по алгоритмам июнь 2021, занятие 1

// D. Больше своих соседей

// Дан список чисел. Определите, сколько в этом списке элементов, которые больше двух своих соседей и выведите количество таких элементов.
//
// Формат ввода
// Вводится список чисел. Все числа списка находятся на одной строке.
//
// Формат вывода
// Выведите ответ на задачу.

import java.util.Scanner;

public class D {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String [] strArr = sc.nextLine().split(" ");
        sc.close();

        int[] intArr = new int[strArr.length];
        int i = 0;
        for (String s : strArr) {
            intArr[i] = Integer.parseInt(s);
            i++;
        }

        System.out.println(func(intArr));
    }

    public static int func(int[] intArr) {

        int res = 0;

        for (int i = 1; i < intArr.length - 1; i++) {
            if (intArr[i - 1] < intArr[i] && intArr[i] > intArr[i + 1]) {
                res++;
            }
        }

        return res;
    }
}