package mjg

import spock.lang.Specification
import spock.lang.Unroll;

class GroovyUtilityMethodsSpec extends Specification {
    UtilityMethods um = new GroovyUtilityMethods()
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
        um.getPositives(-3..3 as int[]).every { it > 0 }
        um.getPositives(3, 1, -4, -1, -5, -9, 2).every { it > 0 }
    }

    /**
     * Use "expect" and "where"
     *   - In where, use a collection of primes
     *   - expect should verify that each is prime
     *
     * Use the "where" variable in the test definition using #
     * Add an @Unroll annotation
     */
    @Unroll
    def '#x is prime'() {
        expect:
        um.isPrime(x)

        where:
        x << [2, 3, 5, 7, 11, 13, 17]
    }

    /**
     * Fill in "given" with a collection of primes
     * Use "every" from Groovy to verify all are prime
     */
    def '2, 3, 5, 7, 11, 13 are prime'() {
        given: 'a set of prime numbers'
        def primes = [2, 3, 5, 7, 11, 13]

        expect: 'all of them are prime'
        primes.every { um.isPrime(it) }
    }

    /**
     * In "when", invoke isPrime with a negative number
     * In "then", verify that an IllegalArgumentException is thrown
     *   optionally, verify the exception message
     */
    def 'negative arg to isPrime throws IAE'() {
        when:
        um.isPrime(-3)

        then:
        IllegalArgumentException e = thrown()
        e.message == 'argument must be > 0'
    }

    /**
     * In "expect", use "every" to verify all the palindromes
     */
    def 'these are palindromes'() {
        expect:
        palindromes.every { um.isPalindrome(it) }
    }

    /**
     * In "expect", check a string that isn't a palindrome
     */
    def 'this is NOT a palindrome'() {
        expect:
        !um.isPalindrome('This is NOT a palindrome')
    }

    /**
     * Call getMinimum with all positives and verify result
     */
    def 'min with all positives works'() {
        expect:
        um.getMinimum(3, 1, 4, 1, 5, 9) == 1
    }

    /**
     * Call getMinimum with both pos and neg and verify result
     */
    def 'min with mixed positives and negatives works'() {
        expect:
        um.getMinimum(3, -1, 4, 1, -5, 9) == -5
    }

    /**
     * Call getMinimum with all negatives and verify result
     */
    def 'min with all negatives works'() {
        expect:
        um.getMinimum(-3, -1, -4, -5, -9) == -9
    }
}