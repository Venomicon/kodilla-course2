import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KeyGenerator {
    private Random generator = new Random();


    public char generateRandomLetter() {
        return "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()/-+=.,';:<>[]{} ".charAt(generator.nextInt(88));
    }


    public Key generateKey(String keyName) {
        Key key = new Key(keyName);
        List<Character> takenValues = new ArrayList<>();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()/-+=.,';:<>[]{} ".toCharArray();
        char value = generateRandomLetter();
        for (char character : alphabet) {
            while (takenValues.size() < 88) {
                if (!takenValues.contains(value) && value != character) {
                    takenValues.add(value);
                    key.getKeyMap().put(character, value);
                    value = generateRandomLetter();
                    break;
                } else {
                    value = generateRandomLetter();
                }
            }
        }
        return key;
    }
}
