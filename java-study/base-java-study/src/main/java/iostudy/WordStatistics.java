package iostudy;

import java.io.*;
import java.util.*;

public class WordStatistics {

    public static void main(String[] args) {
        HashMap<String, Integer> mapOfWords = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("test.txt"))) {

            String value;
            String[] words = null;
            while ((value = reader.readLine()) != null) {
                words = value.split(" ");
                for (int i = 0; i < words.length; ++i) {
                    if (!words[i].matches("[a-zA-Z]+")) {
                        continue;
                    }
                    if (!mapOfWords.containsKey(words[i])) {
                        mapOfWords.put(words[i], 1);
                    } else {
                        mapOfWords.put(words[i], mapOfWords.get(words[i]) + 1);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Map.Entry<String,Integer>> list = new ArrayList<>(mapOfWords.entrySet());
        list.sort((o1, o2) ->
                o2.getValue().compareTo(o1.getValue()));

        /*Collections.sort(list, (Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) ->
                o2.getValue().compareTo(o1.getValue()));*/

        /*Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });*/

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("out.txt"))) {
            for (Map.Entry<String, Integer> entry : list) {
                System.out.println(entry.getKey() + "\t" + entry.getValue());
                writer.write(entry.getKey() + "\t" + entry.getValue() + "\n");
            }
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
