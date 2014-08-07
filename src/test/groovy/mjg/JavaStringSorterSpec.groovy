package mjg

import spock.lang.Specification

class JavaStringSorterSpec extends Specification {
    def strings = 'this is a list of strings'.split() as List
    JavaStringSorter sorter = new JavaStringSorter()

    def 'sort strings by length'() {
        expect:
        sorter.sortStringsByLength(strings)*.size() == [1, 2, 2, 4, 4, 7]
    }
}
