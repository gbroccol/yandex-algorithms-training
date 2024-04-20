package algorithm1.day04;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class B {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        alg(reader, writer);
        reader.close();
        writer.close();
    }

    public static void alg(BufferedReader reader, BufferedWriter writer) throws IOException {

        Map<String, Integer> map = new HashMap<>();

        String[] words = reader.lines()
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .filter(word -> !word.isEmpty())
                .toArray(String[]::new);

        for (String word : words) {
            int count = map.getOrDefault(word, 0);
            writer.write(count + " ");
            map.put(word, count + 1);
        }
        writer.flush();
    }
}
