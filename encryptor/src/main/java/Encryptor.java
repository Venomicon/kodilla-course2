
import java.util.Scanner;

public class Encryptor {
    private Key key;

    public Encryptor() {
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Key getKey() {
        return key;
    }

    public String sendEncryptedMessage() {
        System.out.println("Type in the message to encrypt: \n");
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        String encrypted = encrypt(message);
        return encrypted;
    }

    public String encrypt(String message) throws NullPointerException {
        String encrypted = "";
        try {
            for (char character : message.toCharArray()) {
                character = key.getKeyMap().get(character);
                encrypted = encrypted + character;
            }
        } catch (NullPointerException e) {
            System.out.println("Symbols and/or diacritical signs detected");
            System.out.println("Unable to send encrypted message");
        }
        System.out.println("\nEncrypted using " + key.getName() + "\n" + encrypted + "\n");
        return encrypted;
    }

}
