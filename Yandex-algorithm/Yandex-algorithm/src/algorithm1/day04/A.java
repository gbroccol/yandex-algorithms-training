package algorithm1.day04;

// Яндекс. Тренировки по алгоритмам июнь 2021

// A. Словарь синонимов

//Вам дан словарь, состоящий из пар слов. Каждое слово является синонимом к парному ему слову.
// Все слова в словаре различны. Для одного данного слова определите его синоним.

//Формат ввода
//Программа получает на вход количество пар синонимов N. Далее следует N строк,
// каждая строка содержит ровно два слова-синонима. После этого следует одно слово.

//Формат вывода
//Программа должна вывести синоним к данному слову. Примечание

//Эту задачу можно решить и без словарей (сохранив все входные данные в списке),
// но решение со словарем будет более простым.

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class A {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        alg(reader, writer);
        reader.close();
        writer.close();
    }

    public static void alg( BufferedReader reader, BufferedWriter writer) throws IOException {

        int cnt = Integer.parseInt(reader.readLine());
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < cnt; i++) {
            String[] words = reader.readLine().split(" ");
            map.put(words[0], words[1]);
            map.put(words[1], words[0]);
        }
        String str = reader.readLine();
        writer.write(map.get(str));
        writer.flush();
    }
}