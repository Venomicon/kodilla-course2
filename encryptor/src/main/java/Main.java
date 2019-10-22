import java.util.Map;

public class Main {
    public static void main (String[] args) {
        KeyGenerator keyGenerator = new KeyGenerator();
        Key key = keyGenerator.generateKey("key1");

        for (Map.Entry entry : key.getKeyMap().entrySet()) {
            System.out.println(entry);
        }

        Encryptor encryptor = new Encryptor();
        encryptor.setKey(key);
        Decryptor decryptor = new Decryptor();
        decryptor.setEncryptor(encryptor);

        for(int i= 0; i < 10; i++) {
            String message = encryptor.sendEncryptedMessage();
            decryptor.decrypt(message, "key1");
        }
    }
}
