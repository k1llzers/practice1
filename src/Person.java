import java.time.LocalDate;
import java.util.Objects;

public class Person {
    private Integer age;
    private String name;
    private String surname;
    private LocalDate birthday;

    @Override
    public String toString() {
        return System.lineSeparator() + "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public Person(Integer age, String name, String surname, LocalDate birthday) {
        this.age = age;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(age, person.age) && Objects.equals(name, person.name)
                && Objects.equals(surname, person.surname) && Objects.equals(birthday, person.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, surname, birthday);
    }
}
