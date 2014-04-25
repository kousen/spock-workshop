package mjg;

import java.util.List;

public interface PersonDAO {
    Person findById(Long id);
    List<Person> findAll();
    long insertPerson(Person person);
    void deletePerson(Long id);
}
