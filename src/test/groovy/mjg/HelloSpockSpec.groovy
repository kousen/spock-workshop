package mjg

import spock.lang.Specification
import spock.lang.Unroll;

//@Unroll
class HelloSpockSpec extends Specification {
    @Unroll
    def "#name should have #length"(String name, int length) {
        expect:
        name.size() == length

        where:
        name     || length
        "Spock"  || 5
        "Kirk"   || 4
        "Scotty" || 6
    }

    def "check lengths using arrays"() {
        expect:
        name.size() == length

        where:
        name   << ["Spock", "Kirk", "Scotty"]
        length << [5, 4, 6]
    }

    @Unroll
    def "check #length using #name pairs"() {
        expect:
        name.size() == length

        where:
        [name, length] << [["Spock", 5], ["Kirk", 4], ["Scotty", 6]]
    }
}
