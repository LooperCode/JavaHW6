package JavaHW6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static JavaHW6.function.toChoice;

public class Main {
    public static void main(String[] args) {
        Set <Notebook> keys = new HashSet<>();
        Map<String, String> map = new HashMap<>();
        Notebook nb1 = new Notebook("Lenovo 5436q", "8", "HHD", "Windows");
        Notebook nb2 = new Notebook("Asus m31", "12", "SSD", "Windows");
        Notebook nb3 = new Notebook("Dell", "4", "HHD", "Linux");
        Notebook nb4 = new Notebook("HP", "12", "HHD", "Windows");
        Notebook nb5 = new Notebook("Mac", "6", "SSD", "MacOS");
        keys.add(nb1); keys.add(nb2); keys.add(nb3); keys.add(nb4); keys.add(nb5);
        toChoice(keys, map);
    }
}
