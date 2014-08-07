package mjg

import spock.lang.Specification

class PalindromeSpec extends Specification {
    PalindromeChecker pc = new PalindromeChecker()
    
    List strings = ['racecar', "Madam, in Eden, I'm Adam",
        'Flee to me, remote elf!', 'Sex at noon taxes']
    
    def 'these are palindromes'() {
        expect:
        strings.every { pc.isPalindrome(it) }
    }
    
    def 'this is NOT a palindrome'() {
        expect:
        !pc.isPalindrome('this is NOT a palindrome')
    }
}
