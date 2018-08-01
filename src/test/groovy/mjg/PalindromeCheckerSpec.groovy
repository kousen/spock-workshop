package mjg

import org.junit.Before
import spock.lang.Specification

class PalindromeCheckerSpec extends Specification {
    PalindromeChecker checker = new PalindromeChecker()

    List<String> palindromes = [
            'racecar',
            'A Santa pets rats, as Pat taps a star step at NASA.',
            'Do geese see God?',
            'Flee to me, remote elf!']

    @Before
    void start() {
        println 'using @Before...'
    }

    void setup() {
        println 'using setup method...'
    }

    def "all the listed strings are palindromes"() {
        expect:
        palindromes.every { str -> checker.isPalindrome(str) }
    }

    def "using each returns true even if it shouldn't"() {
        expect:
        palindromes.each { str ->
            checker.isPalindrome(str) // assert required!
        }
    }

    def 'all listed strings are palindromes (alternative way)'() {
        expect:
        palindromes.each { str ->
            assert checker.isPalindrome(str) // assert required!
        }
    }

    def 'all the strings are palindromes (Java version)'() {
        expect:
        palindromes.stream()
            .allMatch { checker.isPalindrome(it) }
    }

    def "this is not a palindrome"() {
        expect:
        !checker.isPalindrome('this is NOT a palindrome')
    }
}
