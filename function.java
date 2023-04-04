package JavaHW6;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class function {
    public static void toChoice(Set<Notebook> set, Map<String, String> map) {
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("1. Вывести результат поиска" +
                "\n2. Ввести параметры ОЗУ" +
                "\n3. Выбрать тип жесткого диска" +
                "\n4. Выбрать версию ОС: " + "\n");
        choice = sc.nextInt();

        if (choice == 1) {
            System.out.println(getFilter(map, set));
            toChoice(set, map);
        } else if (choice == 2) {
            getInputRam(map);
            toChoice(set, map);
        } else if (choice == 3) {
            getInputHard(map);
            toChoice(set, map);
        } else if (choice == 4) {
            getInputOs(map);
            toChoice(set, map);
        }
    }


    public static void getInputRam(Map<String, String> mapRam) {
        Scanner sc2 = new Scanner(System.in);
        String inputRam;
        System.out.println("Введите мимнимальное количество ГБ ОЗУ");
        inputRam = sc2.next();

        try {
            int i = Integer.parseInt(inputRam);
            if (mapRam.containsKey("RAM")) {
                mapRam.put("RAM", inputRam);
            }
            mapRam.putIfAbsent("RAM", inputRam);

        } catch (Exception e) {
            System.out.println("Ошибка ввода. Введите число");
            getInputRam(mapRam);
        }
    }

    public static void getInputHard(Map<String, String> mapHard) {
        Scanner sc3 = new Scanner(System.in);
        System.out.println("Выберите тип жесткого диска:" +
                "\n1: HHD" +
                "\n2: SSD ");
        int inputHard = sc3.nextInt();

        if (inputHard == 1) {
            mapHard.put("HARD", "HHD");
        }
        if (inputHard == 2) {
            mapHard.put("HARD", "SSD");
        }
    }

    public static void getInputOs(Map<String, String> mapOs) {
        Scanner sc4 = new Scanner(System.in);
        int inputOs;
        System.out.println("Выберите версию ОС:" +
                "\n1: Windows" +
                "\n2: Linux" +
                "\n3: MacOS ");
        inputOs = sc4.nextInt();

        if (inputOs == 1) {
            mapOs.put("OS", "Windows");
        }
        if (inputOs == 2) {
            mapOs.put("OS", "Linux");
        }
        if (inputOs == 3) {
            mapOs.put("OS", "MacOS");
        }
    }

    public static Set<Notebook> getFilter(Map<String, String> mapFilter, Set<Notebook> set) {
        Set<Notebook> resultHset = new HashSet<>();
        for (Notebook item : set) {
            if (checkRam(mapFilter, item) && checkHard(mapFilter, item) && checkOs(mapFilter, item)) {
                resultHset.add(item);
            }
        }
        return resultHset;
    }

    public static Boolean checkRam(Map<String, String> ramFilter, Notebook item) {
        if (ramFilter.containsKey("RAM")) {
            return Integer.parseInt(ramFilter.get("RAM")) <= Integer.parseInt(item.getRAMSize());
        }
        return true;
    }

    public static Boolean checkHard(Map<String, String> hardFilter, Notebook item) {
        if (hardFilter.containsKey("HARD")) {
            return hardFilter.get("HARD").equals(item.getHardDvc());
        }
        return true;
    }

    public static Boolean checkOs(Map<String, String> osFilter, Notebook item) {
        if (osFilter.containsKey("OS")) {
            return osFilter.get("OS").equals(item.getOsVersion());
        }
        return true;
    }
}

