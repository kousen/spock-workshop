package mjg

import spock.lang.Ignore;
import spock.lang.Specification;

class ListSpec extends Specification {
    List strings
    
    def setup() {
        // initialize the strings var to hold six strings
        strings = 'this is a list of strings'.split()
    }

    def "there are six strings"() {
        // check that there are six strings
        expect: strings.size() == 6
    }
    
    def "append a string"() {
        when:
        // use the left shift operator to append a new element
        strings << 'extra'

        then:
        // check that the new size is the old size + 1
        strings.size() == old(strings.size()) + 1
    }
    
    def "NPE if I don't instantiate the list"() {
        given:
        List empty

        when:
        // append a new element to 'empty'
        empty << 'abc'

        then:
        // check that a NullPointerException is thrown
        thrown(NullPointerException)
    }
    
    def 'no exception even beyond the end of the list'() {
        when:
        // access each element of the list
        // use an index beyond the end of the list
        strings[99]

        then:
        // verify that NO exceptions are thrown
        // notThrown(ArrayIndexOutOfBoundsException)
        noExceptionThrown()
    }
}
