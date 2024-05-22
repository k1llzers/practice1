import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestHasher {
    private final MessageDigest sha256;
    private final MessageDigest sha1;
    private final MessageDigest md5;

    public MessageDigestHasher() throws NoSuchAlgorithmException {
        sha256 = MessageDigest.getInstance("SHA-256");
        sha1 = MessageDigest.getInstance("SHA-1");
        md5 = MessageDigest.getInstance("Md5");
    }

    public String hashSha256(String toHash) {
        byte[] message = toHash.getBytes(StandardCharsets.UTF_8);
        return toHex(sha256.digest(message));
    }

    public String hashSha1(String toHash) {
        byte[] message = toHash.getBytes(StandardCharsets.UTF_8);
        return toHex(sha1.digest(message));
    }

    public String hashMd5(String toHash) {
        byte[] message = toHash.getBytes(StandardCharsets.UTF_8);
        return toHex(md5.digest(message));
    }

    private String toHex(byte[] input) {
        StringBuilder hexString = new StringBuilder(2 * input.length);
        for (byte b : input) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
