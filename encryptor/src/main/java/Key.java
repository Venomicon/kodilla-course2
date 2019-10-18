import java.util.*;

public class Key {
    String name;
    HashMap<Character, Character> keyMap = new HashMap<>();
    Random generator = new Random();

    public Key(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public HashMap<Character, Character> getKeyMap() {
        return keyMap;
    }

    public char generateRandomLetter() {
        return "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()/-+=.,';:<>[]{}".charAt(generator.nextInt(87));
    }


    public HashMap<Character, Character> generateKey() {
        List<Character> takenValues = new ArrayList<>();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()/-+=.,';:<>[]{}".toCharArray();
        char value = generateRandomLetter();
            for (char character : alphabet) {
                while (takenValues.size() < 87) {
                    if (!takenValues.contains(value) && value != character) {
                        takenValues.add(value);
                        keyMap.put(character, value);
                        value = generateRandomLetter();
                        break;
                    } else {
                        value = generateRandomLetter();
                    }
                }
            }
        keyMap.put(' ', ' ');
        return keyMap;
    }
}
