package JavaHW5;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class Ex1 {
    public static Map<String, String> dictionary(Map<String, String> map) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a name: ");
        String name = sc.nextLine();
        System.out.println("Enter a number: ");
        String number = sc.nextLine();
        if (map.containsKey(name)) {
            map.put(name, map.get(name) + ';' + number);
            }
        map.putIfAbsent(name, number);
        return map;
    }

    public static void printDict(Map<String, String> dict) {
        for (Map.Entry<String, String> entry : dict.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();
        while (true) {
            System.out.println("1. Print the dictionary" +
                            "\n2. Add a name and a number" + "\n3. Exit");
            int choice = sc.nextInt();
            if (choice == 1){
                printDict(map);
            }
            else if (choice == 2) {
                dictionary(map);
            }
            else if (choice == 3){
                System.exit(0);
            }
        }
    }
}
