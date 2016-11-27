package mjg

import spock.lang.Specification
import spock.lang.Unroll;


class PersonSpec extends Specification {
    def 'name uses first and last'() {
        given:
        // instantiate a person using tuple constructor
        Person p = new Person(first: 'Jean-Luc', last: 'Picard')

        expect:
        // check that the person's name equals first + last
        p.name == 'Jean-Luc Picard'
    }

    def 'check equals and hashCode using a Set'() {
        given:
        // create two persons with the same attributes
        Person p1 = new Person(first: 'Jean-Luc', last: 'Picard')
        Person p2 = new Person(first: 'Jean-Luc', last: 'Picard')

        when:
        // add them to a Set
        Set people = [p1, p2]

        then:
        // check that the persons are equal
        p1 == p2

        // check that the size of the Set is only one
        people.size() == 1
    }

    @Unroll
    def '#name from #first and #last'() {
        when:
        // instantiate a person using first and last
        Person p = new Person(first: first, last: last)

        then:
        // test that the person's name is equal to first + last
        p.name == name

        where:
        // use a data table to create a person from first and last
        first      | last      || name
        'James'    | 'Kirk'    || 'James Kirk'
        'Benjamin' | 'Sisko'   || 'Benjamin Sisko'
        'Kathryn'  | 'Janeway' || 'Kathryn Janeway'
    }
}
