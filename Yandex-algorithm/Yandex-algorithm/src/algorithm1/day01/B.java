package algorithm1.day01;

// Яндекс. Тренировки по алгоритмам июнь 2021, занятие 1

// B. Треугольник

// Даны три натуральных числа.
// Возможно ли построить треугольник с такими сторонами.
// Если это возможно, выведите строку YES, иначе выведите строку NO.
// Треугольник — это три точки, не лежащие на одной прямой.

// Треугольник существует только тогда, когда сумма любых двух его сторон больше третьей

import java.io.FileNotFoundException;
import java.util.Scanner;

public class B {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        sc.nextLine();
        int b = sc.nextInt();
        sc.nextLine();
        int c = sc.nextInt();

        System.out.println(isCorrectTriangle(a, b, c));
    }

    public static String isCorrectTriangle(int a, int b, int c) {

        if (a + b <= c
                || a + c <= b
                || c + b <= a) {
            return "NO";
        }
        return "YES";
    }
}