import java.util.HashMap;

public class Key {
    String name;
    HashMap<Character, Character> keyMap = new HashMap<>();

    public Key(String name) { this.name = name; }

    public String getName() {
        return name;
    }

    public HashMap<Character, Character> getKeyMap() {
        return keyMap;
    }
}
