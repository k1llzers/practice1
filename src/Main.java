import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.time.LocalDate;
import java.util.HashMap;

public class Main {
    private static MessageDigestHasher messageDigestHasher;
    private static SecureRandomHasher secureRandomHasher;

    static {
        try {
            messageDigestHasher = new MessageDigestHasher();
            secureRandomHasher = new SecureRandomHasher();
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(messageDigestHasher.hashSha256("java21"));
        System.out.println(messageDigestHasher.hashSha1("java21"));
        System.out.println(messageDigestHasher.hashMd5("java21"));
        System.out.println(secureRandomHasher.hashWindowsPRNG("java21"));
        System.out.println(secureRandomHasher.hashSha1PRNG("java21"));
        System.out.println(secureRandomHasher.hashDRBG("java21"));

        Person firstPerson = new Person(10, "Oleksandr", "Semytskti", LocalDate.now().minusYears(10));
        Person secondPerson = new Person(20, "Zakhar", "Litvinchuk", LocalDate.now().minusYears(20));
        Person thirdPerson = new Person(15, "Oleksandr", "Syniak", LocalDate.now().minusYears(15));
        Person fourthPerson = new Person(15, "Oleksandr", "Syniak", LocalDate.now().minusYears(15));

        System.out.println(firstPerson.hashCode());
        System.out.println(secondPerson.hashCode());
        System.out.println(thirdPerson.hashCode());
        System.out.println(fourthPerson.hashCode());

        System.out.println(firstPerson.equals(thirdPerson));
        System.out.println(thirdPerson.equals(fourthPerson));

        HashMap<Person, Integer> personMap = new HashMap<>();
        personMap.put(firstPerson, 1);
        personMap.put(secondPerson, 2);
        personMap.put(thirdPerson, 3);
        personMap.put(fourthPerson, 4);

        System.out.println(personMap);

        University firstNaukma = new University("NaUKMA", 5000);
        University KPI = new University("KPI", 50000);
        University secondNaukma = new University("NaUKMA", 5000);

        System.out.println(firstNaukma.hashCode());
        System.out.println(KPI.hashCode());
        System.out.println(secondNaukma.hashCode());

        System.out.println(firstNaukma.equals(KPI));
        System.out.println(KPI.equals(secondNaukma));
        System.out.println(firstNaukma.equals(secondNaukma));

        HashMap<University, Integer> universityMap = new HashMap<>();
        universityMap.put(firstNaukma, 1);
        universityMap.put(KPI, 2);
        universityMap.put(secondNaukma, 3);

        System.out.println(universityMap);
    }
}
