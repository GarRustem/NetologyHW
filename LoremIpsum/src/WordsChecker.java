import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordsChecker {

//    private Set<String> text = new HashSet<>(); // Почему вариант с применением строки 8 и строки 12 не работают в Main? - всегда возвращают false
    private Set<String> text;

    public WordsChecker (String input) {
//      text.add(Arrays.toString(input.split("\\P{IsAlphabetic}+")));
        text =  new HashSet<>(List.of(input.split("\\P{IsAlphabetic}+")));
    }

    public boolean hasWord (String singleWord) {
        return text.contains(singleWord);
    }
}
