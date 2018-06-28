package mjg.rest

import groovy.sql.Sql
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.containsInAnyOrder

class PersonDAOSpec extends Specification {
    PersonDAO dao = SqlPersonDAO.instance
    @Shared Sql sql = Sql.newInstance(url:'jdbc:h2:./build/hr', driver:'org.h2.Driver')
    
    def 'findAll returns all people'() {
        when:
        List<Person> people = dao.findAll()

        List<String> lastNames = people*.last

        then:
        5 == people.size()
        ['Archer', 'Picard', 'Kirk', 'Sisko', 'Janeway'].every {
            people*.last.contains(it)
        }
//		['Archer','Sisko'].each {
//			assert people.last.contains(it)
//		}

        assertThat(lastNames,
                containsInAnyOrder('Kirk', 'Picard', 'Sisko', 'Janeway', 'Archer'))
    }

    @Unroll
    def 'findById returns #first #last with id #id'(Integer id, String first, String last) {
        when:
        Person p = dao.findById(id)

        then:
        p.first == first
        p.last == last

        where:
        [id, first, last] << sql.rows('select id, first, last from people')
    }

    def 'insert and delete a new person'() {
        given:
        Person taggart = new Person(first:'Peter Quincy', last:'Taggart')
 
        when:
        dao.create(taggart)

        then:
        dao.findAll().size() == old(dao.findAll().size()) + 1
        taggart.id

        when:
        dao.delete(taggart.id)

        then:
        dao.findAll().size() == old(dao.findAll().size()) - 1
    }

    def 'findByName returns correct person'() {
        expect:
        dao.findByLastName('a').size() == 3
    }
}
