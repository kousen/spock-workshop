package mjg

import spock.lang.Specification
import spock.lang.Unroll;


class PersonSpec extends Specification {
    def 'name uses first and last'() {
        given:
        // instantiate a person using tuple constructor

        expect:
        // check that the person's name equals first + last
        true // remove this line when you add your test
    }

    def 'check equals and hashCode using a Set'() {
        given:
        // create two persons with the same attributes

        when:
        // add them to a Set
        true

        then:
        // check that the persons are equal
        // check that the size of the Set is only one
        true // remove this line when you add your test
    }
    
    @Unroll
    def '#person.name from #first and #last'() {
        expect:
        // test that the person's name is equal to first + last

        // where:
        // use a data table to create a person from first and last
        true // remove this line when you add your test
    }
}
