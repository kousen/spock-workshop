package mjg

import spock.lang.Specification

class JavaStringSorterSpec extends Specification {
    List strings = 'this is a list of strings'.split()
    JavaStringSorter sorter = new JavaStringSorter()

    def 'sort strings by length'() {
        given:
        println strings

        when:
        List sorted = sorter.sortStringsByLength(strings)

        then:
        println sorted
        sorted*.size() == [1, 2, 2, 4, 4, 7]
    }
}
