package JavaHW5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*Пусть дан список сотрудников: Написать программу, которая найдет и выведет повторяющиеся
имена с количеством повторений.
Отсортировать по убыванию популярности Имени. */

public class Ex2 {
    public static String fileReader(String path) {
        StringBuilder sb = new StringBuilder();
        String inputStr;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((inputStr = br.readLine()) != null) {
                sb.append(inputStr).append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        return sb.toString().replaceAll("\n", ";");
    }

    public static String[] getArray(String input) {
        String[] array = input.split(";| ");
        return array;
    }

    public static String topName(String path) {
        String inputTxt = fileReader(path);
        String[] arr = getArray(inputTxt);
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int max = 1;
        for (int i = 0; i < arr.length; i += 2) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);

                if (map.get(arr[i]) > max) {
                    max = map.get(arr[i]);
                }
            }
            map.putIfAbsent(arr[i], 1);
        }
        max += 1;
        while (max > 0) {
            max--;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() > 1) {
                    if (entry.getValue() == max) {
                        sb.append("Имя: ").append(entry.getKey()).append(", ");
                        sb.append("Количество повторений: ").append(entry.getValue()).append("\n");

                    }

                }

            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        String path = "JavaHW5/list.txt";
        String result = topName(path);
        System.out.println(result);
    }
}

