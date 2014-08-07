package mjg

import spock.lang.Specification
import spock.lang.Unroll;


class PersonSpec extends Specification {
    def 'name uses first and last'() {
        when:
        Person p = new Person(99, "Buffy", "Summers");
        
        then:
        p.name == 'Buffy Summers'
    }

    def 'check equals and hashCode using a Set'() {
        given:
        Person p1 = new Person(99, "Buffy", "Summers")
        Person p2 = new Person(99, "Buffy", "Summers")

        when:
        Set people = [p1, p2]

        then:
        p1 == p2
        people.size() == 1
    }
    
    @Unroll
    def '#person.name from #first and #last'() {
        expect:
        person.name == "$first $last"
        
        where:
                    person                    |  first   | last
        new Person(99, 'Buffy', 'Summers')    | 'Buffy'  | 'Summers'
        new Person(98, 'Willow', 'Rosenberg') | 'Willow' | 'Rosenberg'
        new Person(97, 'Xander', 'Harris')    | 'Xander' | 'Harris'
    }
}
