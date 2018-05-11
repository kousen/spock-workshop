package mjg

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification
import spock.lang.Unroll

@ContextConfiguration("classpath:applicationContext.xml")
@Transactional
class SpringJdbcPersonDAOSpec extends Specification {

    @Autowired
    PersonDAO dao

    def 'DAO is injected properly'() {
        expect: dao
    }

    def 'there are five persons in the sample database'() {
        expect:
        dao.findAll().size() == 5
    }

    @Unroll
    def "findById with #id works"(Long id) {
        when:
        Person p = dao.findById(id)

        then:
        p.id == id

        where:
        id << (1..5)
    }

    def 'can insert a person'() {
        given:
        Person p = new Person(99, 'Peter Quincy', 'Taggert')

        when:
        dao.insertPerson(p)

        then:
        dao.findAll().size() == old(dao.findAll().size()) + 1
        dao.findById(p.getId()) == p
    }

    def 'delete everybody (but not really)'() {
        when:
        dao.findAll().each { Person p -> dao.deletePerson(p.getId()) }

        then:
        dao.findAll().size() == 0
    }
}
