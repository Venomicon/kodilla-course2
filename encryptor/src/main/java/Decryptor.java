import java.util.Map;

public class Decryptor {
    private Encryptor encryptor;

    public Decryptor() {
    }

    public void setEncryptor(Encryptor encryptor) {
        this.encryptor = encryptor;
    }

    public Encryptor getEncryptor() {
        return encryptor;
    }

    public String decrypt(String message, String keyName) {
        String result = "";
        if (keyName.equals(encryptor.getKey().getName())) {
            for (int i=0; i<message.length(); i++) {
                Character character = message.charAt(i);
                for (Map.Entry entry : encryptor.getKey().getKeyMap().entrySet()) {
                    if (entry.getValue().equals(character)) {
                        character = (Character)entry.getKey();
                        result = result + character;
                        break;
                    }
                }
            }
            System.out.println("Decrypted using " + keyName + "\n" + result+"\n");
            return result;
        } else {
            System.out.println("Incorrect key\n");
            return message;
        }
    }
}
