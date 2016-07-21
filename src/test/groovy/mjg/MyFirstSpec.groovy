package mjg

import spock.lang.Specification

class MyFirstSpec extends Specification {
    def "max of two numbers"() {
        expect:
        Math.max(1, 2) == 2
    }

    // Add a similar test for Math.min

    // Add a test for Math.abs

}
