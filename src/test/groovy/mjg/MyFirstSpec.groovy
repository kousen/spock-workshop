package mjg

import spock.lang.Specification

class MyFirstSpec extends Specification {
    def "max of two numbers"() {
        expect:
        Math.max(1, 2) == 2
    }

    // Add a similar test for Math.min
    void 'min of two numbers'() {
        expect: Math.min(1, 2) == 1
    }

    // Add a test for Math.abs
    def 'using abs'() {
        expect:
        Math.abs(-3) == 3
        (-3).abs() == 3
    }
}
