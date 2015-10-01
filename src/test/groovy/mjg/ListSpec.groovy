package mjg

import spock.lang.Ignore;
import spock.lang.Specification;

class ListSpec extends Specification {
    List strings = 'this is a list of strings'.split()
    
    def "there are six strings"() {
        expect: strings.size() == 6
    }

    def 'left-shift changes the list'() {
        when:
        strings << 'and'
        strings << 'more'

        then:
        strings.size() == 8
    }

    def "left-shift check with old method"() {
        when:
        strings << "plus"
        strings << "two"
        
        then:
        strings.size() == old(strings.size()) + 2
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
        when:
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
}
