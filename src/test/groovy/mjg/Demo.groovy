package mjg

import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

class Demo extends Specification {
    @Unroll
    def "length of #name should be #length"() {
        expect:
        name.size() == length

        where:
        [name, length] << [["Spock", 5], ["Kirk", 4], ["Scotty", 6]]
    }

    @Unroll
    def "#name -> #length"() {
        expect:
        name.size() == length

        where:
        name << ['Spock', 'Kirk', 'Scotty']
        length << [5, 4, 6]
    }

    @Unroll @Ignore
    def "#name is #length using data table"(String name, int length) {
        expect:
        name.size() == length

        where:
        name     || length
        'Spock'  || 5
        'Kirk'   || 4
        'Scotty' || 6
    }
}
