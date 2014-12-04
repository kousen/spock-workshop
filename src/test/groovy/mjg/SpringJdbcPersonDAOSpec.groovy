package mjg

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification
import spock.lang.Unroll

//@ContextConfiguration("classpath:applicationContext.xml")
//@Transactional
class SpringJdbcPersonDAOSpec extends Specification {

//    @Autowired
    PersonDAO dao

    def 'DAO is injected properly'() {
        // check dao is not null
    }

    def 'there are five accounts in the sample database'() {
        expect:
        dao.findAll().size() == 5
    }

    @Unroll
    def "findById with #id works"(/* add id of type Long */) {
        expect:
        // find a person by id and see that it's not null
        // check that the id of the retrieved person matches id arg

        where:
        id << (1..5)
    }

    def 'can insert a person'() {
        given:
        Person p = new Person(99, 'Peter Quincy', 'Taggert')

        when:
        // insert a person
        true

        then:
        // check new total is old total + 1
        true  // remove this line when you add a test
    }

    def 'delete everybody (but not really)'() {
        when:
        // delete all the person instances
        true

        then:
        // check the number of people is zero
        true // remove this line when you add your test
    }
}
