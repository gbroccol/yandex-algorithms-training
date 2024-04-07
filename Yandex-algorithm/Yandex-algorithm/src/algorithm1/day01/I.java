package algorithm1.day01;

// Яндекс. Тренировки по алгоритмам июнь 2021, занятие 1

// I. Узник замка Иф

// За многие годы заточения узник замка Иф проделал в стене прямоугольное отверстие размером D × E.
// Замок Иф сложен из кирпичей, размером A × B × C.
// Определите, сможет ли узник выбрасывать кирпичи в море через это отверстие, если стороны кирпича должны быть параллельны сторонам отверстия.

//Формат ввода
//Программа получает на вход числа A, B, C, D, E.

//Формат вывода
//Программа должна вывести слово YES или NO.

import java.util.Scanner;

public class I {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = Integer.parseInt(sc.nextLine());
        int b = Integer.parseInt(sc.nextLine());
        int c = Integer.parseInt(sc.nextLine());
        int d = Integer.parseInt(sc.nextLine());
        int e = Integer.parseInt(sc.nextLine());

        System.out.println(func(a, b, c, d, e));

//        test
//        System.out.println(func(1, 1, 1, 1, 1));
//        System.out.println(func(2, 2, 2, 1, 1));
    }

    public static String func(int a, int b, int c, int d, int e) {

        if (a <= d && (b <= e || c <= e)) {
            return "YES";
        } else if (a <= e && (b <= d || c <= d)) {
            return "YES";
        } else if (b <= d && c <= e) {
            return "YES";
        } else if (b <= e && c <= d) {
            return "YES";
        }

        return "NO";
    }

    // вариант из разбора д/з
    public static String func2(int a, int b, int c, int d, int e) {

        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        if (b > c) {
            int tmp = b;
            b = c;
            c = tmp;
        }

        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        if (d > e) {
            int tmp = d;
            d = e;
            e = tmp;
        }

        if (a <= d && b <= e) return "YES";

        return "NO";
    }
}