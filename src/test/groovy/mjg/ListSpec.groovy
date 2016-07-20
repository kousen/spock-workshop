package mjg

import spock.lang.Ignore;
import spock.lang.Specification;

class ListSpec extends Specification {
    List strings = 'this is a list of strings'.split()
    
    def setup() {
        // initialize the strings var to hold six strings
    }

    def "there are six strings"() {
        // check that there are six strings
    }

    def 'left-shift changes the list'() {
        when:
        strings << 'and'
        strings << 'more'

        then:
        strings.size() == 8
    }

    def "append a string"() {
        when:
        // use the left shift operator to append a new element
        true

        then:
        // check that the new size is the old size + 1
        true // remove this line when you add your test
    }

    def 'left-shift changes the list itself'() {
        when:
        strings << 'and'
        strings << 'more'

        then:
        strings.size() == old(strings.size()) + 2

        when:
        strings = strings - 'and' - 'more'

        then:
        strings.size() == old(strings.size()) - 2
    }

    def 'plus does not change the list itself'() {
        given:
        String s1 = 'and'
        String s2 = 'more'

        when:
        def added = strings + s1 + s2

        then:
        added.size() == strings.size() + 2
        strings.size() == old(strings.size())
    }

    def "NPE if I don't instantiate the list"() {
        given:
        List empty
        empty << 'data'
        
        then:
        def e = thrown(NullPointerException)
        // NullPointerException e = thrown()
        e.message == 'Cannot invoke method leftShift() on null object'
    }
    
    def 'no exception if I access outside the list'() {
        when:
        strings[99]

        then:
        notThrown()
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
