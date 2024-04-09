package algorithm1.day03;

// Яндекс. Тренировки по алгоритмам июнь 2021

// C. Кубики

// Аня и Боря любят играть в разноцветные кубики, причем у каждого из них свой набор и в каждом наборе все кубики различны по цвету.
// Однажды дети заинтересовались, сколько существуют цветов таких, что кубики каждого цвета присутствуют в обоих наборах.
// Для этого они занумеровали все цвета случайными числами. На этом их энтузиазм иссяк, поэтому вам предлагается помочь им в оставшейся части.
// Номер любого цвета — это целое число в пределах от 0 до 109.

// Формат ввода
// В первой строке входного файла записаны числа N и M — количество кубиков у Ани и Бори соответственно.
// В следующих N строках заданы номера цветов кубиков Ани. В последних M строках номера цветов кубиков Бори.

// Формат вывода
// Выведите сначала количество, а затем отсортированные по возрастанию номера цветов таких,
// что кубики каждого цвета есть в обоих наборах, затем количество и отсортированные по возрастанию номера остальных цветов у Ани,
// потом количество и отсортированные по возрастанию номера остальных цветов у Бори.

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class C {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        alg(reader, writer);
        reader.close();
        writer.close();
    }

    public static Set<Integer> readNumberFromEachLine(BufferedReader reader, int lines) throws IOException {
        Set<Integer> nmbs = new HashSet<>();
        for (int i = 0; i < lines; i++) {
            nmbs.add(Integer.valueOf(reader.readLine()));
        }
        return nmbs;
    }

    private static void appendSet(StringBuilder sb, Set<Integer> s) {
        sb.append(s.size());
        sb.append('\n');
        sb.append(s.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
        sb.append('\n');
    }

    public static void alg(BufferedReader reader, BufferedWriter writer) throws IOException {

        int[] buf = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        Set<Integer> a = readNumberFromEachLine(reader, buf[0]);
        Set<Integer> b = readNumberFromEachLine(reader, buf[1]);

        Set<Integer> intersection = a.stream().filter(b::contains).collect(Collectors.toSet());
        a.removeAll(intersection);
        b.removeAll(intersection);

        StringBuilder sb = new StringBuilder();
        appendSet(sb, intersection);
        appendSet(sb, a);
        appendSet(sb, b);

        writer.write(sb.toString());
        writer.flush();
    }
}
