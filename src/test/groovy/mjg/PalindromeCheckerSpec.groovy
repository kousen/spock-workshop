package mjg

import spock.lang.Specification;
import spock.lang.Unroll;

class PalindromeCheckerSpec extends Specification {
    PalindromeChecker checker = new PalindromeChecker()

    def palindromes = [
        'racecar',
        'A Santa pets rats, as Pat taps a star step at NASA.',
        'Do geese see God?',
        'Flee to me, remote elf!'
    ]

    def "all the listed strings are palindromes"() {
        expect:
        palindromes.every { str -> checker.isPalindrome(str) }
    }

    def 'all listed strings are palindromes (alternative way)'() {
//        given:
//        palindromes << 'this is NOT a palindrome'

        expect:
        palindromes.each { str ->
            assert checker.isPalindrome(str) // assert required!
        }
    }

    def "this is not a palindrome"() {
        expect:
        !checker.isPalindrome('this is NOT a palindrome')
    }

}
