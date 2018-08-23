package mjg

import org.junit.After
import org.junit.Before
import org.junit.jupiter.api.BeforeEach
import spock.lang.Specification
import spock.lang.Unroll

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

    @BeforeEach // JUnit 5 compiles but is not lifecycle method
    void begin() {
        println 'using @BeforeEach...'
    }

    void setup() {
        println 'using setup method...'
    }

    void cleanup() {
        println 'using cleanup method...'
    }

    @After
    void finish() {
        println 'using @After...'
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

    @Unroll
    def "#string is a palindrome"() {
        expect:
        checker.isPalindrome(string)

        where:
        string << ['racecar',
                   'A Santa pets rats, as Pat taps a star step at NASA.',
                   'Do geese see God?',
                   'Flee to me, remote elf!']
    }
}
