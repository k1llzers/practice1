import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

public class SecureRandomHasher {
    private final SecureRandom sha1PRNG;
    private final SecureRandom windowsPRNG;
    private final SecureRandom DRBG;

    public SecureRandomHasher() throws NoSuchAlgorithmException, NoSuchProviderException {
        this.sha1PRNG = SecureRandom.getInstance("SHA1PRNG");
        this.windowsPRNG = SecureRandom.getInstance("Windows-PRNG");
        this.DRBG = SecureRandom.getInstance("DRBG");
    }

    public Long hashSha1PRNG(String toHash) {
        byte[] message = toHash.getBytes(StandardCharsets.UTF_8);
        sha1PRNG.nextBytes(message);
        return sha1PRNG.nextLong();
    }

    public Long hashWindowsPRNG(String toHash) {
        byte[] message = toHash.getBytes(StandardCharsets.UTF_8);
        windowsPRNG.nextBytes(message);
        return windowsPRNG.nextLong();
    }

    public Long hashDRBG(String toHash) {
        byte[] message = toHash.getBytes(StandardCharsets.UTF_8);
        DRBG.nextBytes(message);
        return DRBG.nextLong();
    }
}
