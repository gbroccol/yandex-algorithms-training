package algorithm1.day02;

// Яндекс. Тренировки по алгоритмам июнь 2021, занятие 1

// C. Ближайшее число

// Напишите программу, которая находит в массиве элемент, самый близкий по величине к данному числу.

// Формат ввода
// В первой строке задается одно натуральное число N, не превосходящее 1000 – размер массива. Во второй строке содержатся N чисел – элементы массива (целые числа, не превосходящие по модулю 1000). В третьей строке вводится одно целое число x, не превосходящее по модулю 1000.

// Формат вывода
// Вывести значение элемента массива, ближайшее к x. Если таких чисел несколько, выведите любое из них.

import java.util.Scanner;

public class C {

//    5
//    1 2 3 4 5
//    6

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numberCnt = sc.nextInt();
        sc.nextLine();

        int[] nmbArray = new int[numberCnt];

        for (int i = 0; i < numberCnt; i++) {
            nmbArray[i] = sc.nextInt();
        }
        sc.nextLine();

        int numberToComp = sc.nextInt();

        System.out.println(findNumber2(nmbArray, numberToComp));
    }

    public static int findNumber(int[] nmbArray, int numberToComp) {

        int res = nmbArray[0];

        if (res == numberToComp) return numberToComp;

        for (int i = 1; i < nmbArray.length; i++) {

            if (numberToComp == nmbArray[i]) {
                return numberToComp;
            } else if (numberToComp > nmbArray[i] && numberToComp > res) {
                res = Integer.max(res, nmbArray[i]);
            } else if (numberToComp < nmbArray[i] && numberToComp < res) {
                res = Integer.min(res, nmbArray[i]);
            } else {

                int dif1 = numberToComp - res;
                int dif2 = numberToComp - nmbArray[i];

                dif1 = dif1 < 0 ? dif1 * (-1) : dif1;
                dif2 = dif2 < 0 ? dif2 * (-1) : dif2;

                if (dif2 < dif1) {
                    res = nmbArray[i];
                }

            }
        }
        return res;
    }
    public static int findNumber2(int[] nmbArray, int target) {

        int res = nmbArray[0];
        int minDiff = Math.abs(res - target);

        if (res == target) return target;

        for (int i = 1; i < nmbArray.length; i++) {

            int diff = Math.abs(nmbArray[i] - target);
            if (diff < minDiff) {
                minDiff = diff;
                res = nmbArray[i];
            }
        }
        return res;
    }
}