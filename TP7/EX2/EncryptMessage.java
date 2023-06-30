import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.KeySpec;

public class EncryptMessage {
    String message, key;

    public EncryptMessage(String message, String key) {
        this.message = message;
        this.key = key;
    }

    public Key convertAllToKey() {
        try {
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[10];
            // random.nextBytes(salt);
            KeySpec spec = new PBEKeySpec(key.toCharArray(), salt, 65536, 256); // AES-256
            SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] skey = f.generateSecret(spec).getEncoded();
            Key aesKey = new SecretKeySpec(skey, "AES");
            return aesKey;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String encryptMessage() {
        try {
            Key f = convertAllToKey();
            // System.out.println(convertAllToKey());
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, f);
            byte[] encrypted = cipher.doFinal(message.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : encrypted) {
                sb.append((char) b);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
