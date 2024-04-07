package algorithm1.day02;

// Яндекс. Тренировки по алгоритмам июнь 2021, занятие 1

// G. Наибольшее произведение двух чисел

// Дан список, заполненный произвольными целыми числами.
// Найдите в этом списке два числа, произведение которых максимально.
// Выведите эти числа в порядке неубывания.

// Список содержит не менее двух элементов. Числа подобраны так, что ответ однозначен.

// Решение должно иметь сложность O(n), где n - размер списка.

import java.util.Scanner;

public class G {

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

        func(intArr);
    }

    public static void func(int[] nums) {

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int value : nums) {
            if (value <= min1 && value <= min2) {
                min2 = min1;
                min1 = value;
            } else if (value < min2) {
                min2 = value;
            }

            if (value >= max1 && value >= max2) {
                max1 = max2;
                max2 = value;
            } else if (value > max1) {
                max1 = value;
            }
        }

        if (max1 * max2 >= min1 * min2) {
            System.out.print(max1);
            System.out.print(" ");
            System.out.println(max2);
        } else {
            System.out.print(min1);
            System.out.print(" ");
            System.out.println(min2);
        }
    }
}