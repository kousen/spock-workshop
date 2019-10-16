package mjg

import spock.lang.Specification
import spock.lang.Unroll;

class JavaUtilityMethodsSpec extends Specification {
    UtilityMethods um = new JavaUtilityMethods()
    List<String> palindromes = ['racecar',
                                "Madam, in Eden, I'm Adam",
                                'Flee to me, remote elf!',
                                "Go hang a salami; I'm a lasagna hog"]

    /**
     * Use an "expect" block to check:
     *   - range -3..3 as int[]
     *   - int args, both pos and neg, that include 1, 2, 3
     */
    def "getPositives should return 1, 2, 3"() {
        expect:
        true
    }

    /**
     * Use "expect" and "where"
     *   - In where, use a collection of primes
     *   - expect should verify that each is prime
     *
     * Use the "where" variable in the test definition using #
     * Add an @Unroll annotation
     */
    def '#x is prime'() {
        expect:
        true

        where:
        x << [2]
    }

    /**
     * Fill in "given" with a collection of primes
     * Use "every" from Groovy to verify all are prime
     */
    def '2, 3, 5, 7, 11, 13 are prime'() {
        given: 'a set of prime numbers'
        def primes = []

        expect: 'all of them are prime'
        true
    }

    /**
     * In "when", invoke isPrime with a negative number
     * In "then", verify that an IllegalArgumentException is thrown
     *   optionally, verify the exception message
     */
    def 'negative arg to isPrime throws IAE'() {
        when:
        3

        then:
        true
    }

    /**
     * In "expect", use "every" to verify all the palindromes
     */
    def 'these are palindromes'() {
        expect:
        true
    }

    /**
     * In "expect", check a string that isn't a palindrome
     */
    def 'this is NOT a palindrome'() {
        expect:
        !false
    }

    /**
     * Call getMinimum with all positives and verify result
     */
    def 'min with all positives works'() {
        expect:
        true
    }

    /**
     * Call getMinimum with both pos and neg and verify result
     */
    def 'min with mixed positives and negatives works'() {
        expect:
        true
    }

    /**
     * Call getMinimum with all negatives and verify result
     */
    def 'min with all negatives works'() {
        expect:
        true
    }
}
