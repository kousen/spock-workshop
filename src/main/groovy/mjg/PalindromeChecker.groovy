package mjg

class PalindromeChecker {
    boolean isPalindrome(String s) {
        String ts = s.replaceAll(/\W/, '').toLowerCase()
        ts == ts.reverse()
    }
}
