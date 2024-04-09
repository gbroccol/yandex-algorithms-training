package algorithm1.day03;

// Яндекс. Тренировки по алгоритмам июнь 2021

// G. Черепахи

//Широко известна следующая задача для младших школьников. Три черепахи ползут по дороге.
// Одна черепаха говорит: “Впереди меня две черепахи”.
// Другая черепаха говорит: “Позади меня две черепахи”.
// Третья черепаха говорит: “Впереди меня две черепахи и позади меня две черепахи”.
// Как такое может быть? Ответ: третья черепаха врет!
// По дороге одна за другой движутся N черепах. Каждая черепаха говорит фразу вида: “Впереди меня ai черепах, а позади меня bi черепах”.
// Ваша задача определить, сколько самое большее количество черепах могут говорить правду.

//Формат ввода
//В первой строке вводится целое число N (1 ≤ N ≤ 10000) строк, содержащих целые числа ai и bi, по модулю не превосходящие 10000, описывающие высказывание i-ой черепахи.

//Формат вывода
//Выведите целое число M – максимальное количество черепах, которые могут говорить правду.

import java.io.*;
import java.util.*;

public class G {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        alg(reader, writer);
        reader.close();
        writer.close();
    }

    public static void alg(BufferedReader reader, BufferedWriter writer) throws IOException {

        int amount = Integer.parseInt(reader.readLine());
        Set<Integer> trueStatements = new HashSet<>();

        for (int i = 0; i < amount; i++) {
            int[] buf = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();

            if (buf[0] >= 0
                    && buf[1] >= 0
                    && buf[0] + buf[1] == amount - 1) {
                trueStatements.add(buf[0]);
            }
        }

        writer.write(String.valueOf(trueStatements.size()));
        writer.flush();
    }
}
