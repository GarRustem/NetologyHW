import java.util.*;

public class Main {

    static String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
            "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
            "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
            "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    static Map<Character, Integer> symbolCount = new HashMap<>();
    static Map <Character, Integer> charMapMax = new HashMap<>();
    static Set<Character> charSetMin = new HashSet<>();

    static Integer maxNum = 1;
    static Character maxChar;
    static Integer minNum = 1;
    static Character minChar;

    public static void main(String[] args) {

        int counter;

        for (int i = 0; i < lorem.length(); i++) {
            if(symbolCount.containsKey(lorem.charAt(i))) {
                counter = symbolCount.get(lorem.charAt(i));
                counter++;
                symbolCount.replace(lorem.charAt(i), counter); // Почему в качестве второго аргумента я не могу передать "counter++"? Приходится использовать строку 26.
            } else {
                symbolCount.put(lorem.charAt(i), 1);
            }
        }

        for (Map.Entry<Character, Integer> keyValue : symbolCount.entrySet()) {
            System.out.println(keyValue.getKey() + " = " + keyValue.getValue());
        }

        System.out.println("Text contains " + lorem.length() + " symbol(s)");

        for (Map.Entry<Character, Integer> keyValue : symbolCount.entrySet()) {
            if (Character.isLetter(keyValue.getKey())) {
                if (keyValue.getValue() > maxNum) {
                    charMapMax.put(keyValue.getKey(), keyValue.getValue());
                    if(charMapMax.get(keyValue.getKey()) > maxNum) {
                        charMapMax.remove(maxChar);
                    }
                    maxNum = keyValue.getValue();
                    maxChar = keyValue.getKey();
                } else if (keyValue.getValue() <= minNum) {
                    minNum = keyValue.getValue();
                    minChar = keyValue.getKey();
                    charSetMin.add(minChar);
                }
            }
        }

        System.out.println("Minimum frequency for letters from this text is: " + charSetMin +
                " = " + minNum + "\n" + "Maximum frequency for letters from this text is: " +
                charMapMax.keySet() + " = " + maxNum);

        WordsChecker check = new WordsChecker(lorem);
        System.out.println(check.hasWord("amet"));
    }
}
