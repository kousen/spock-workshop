package mjg

import spock.lang.Ignore;
import spock.lang.Specification;

class ListSpec extends Specification {
    List strings
    
    def setup() {
        // initialize the strings var to hold six strings
    }

    def "there are six strings"() {
        // check that there are six strings
    }
    
    def "append a string"() {
        when:
        // use the left shift operator to append a new element
        true

        then:
        // check that the new size is the old size + 1
        true // remove this line when you add your test
    }
    
    def "NPE if I don't instantiate the list"() {
        given:
        List empty

        when:
        // append a new element to 'empty'
        true

        then:
        // check that a NullPointerException is thrown
        true // remove this line when you add your test
    }
    
    def 'no exception if I stay inside list'() {
        when:
        // access each element of the list
        // use an index beyond the end of the list
        true

        then:
        // verify that NO exceptions are thrown
        true // remove this line when you add your test
    }
}
