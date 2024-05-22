import java.util.Objects;
import java.util.Random;

public class University {
    private String name;
    private Integer countOfStudent;

    public University(String name, Integer countOfStudent) {
        this.name = name;
        this.countOfStudent = countOfStudent;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return System.lineSeparator() + "University{" +
                "name='" + name + '\'' +
                ", countOfStudent=" + countOfStudent +
                '}';
    }
}
