package mjg;

public class Person {
    private Long id;
    private String first;
    private String last;

    public Person() {
    }

    public Person(Long id, String first, String last) {
        super();
        this.id = id;
        this.first = first;
        this.last = last;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return (first != null && !first.equals("") ? first : "") + " " + last;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (first != null ? !first.equals(person.first) : person.first != null) return false;
        if (id != null ? !id.equals(person.id) : person.id != null) return false;
        if (last != null ? !last.equals(person.last) : person.last != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (first != null ? first.hashCode() : 0);
        result = 31 * result + (last != null ? last.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                '}';
    }
}
