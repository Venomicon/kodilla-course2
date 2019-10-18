public class Main {
    public static void main (String[] args) {
        Key key = new Key("key1");
        key.generateKey();

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
