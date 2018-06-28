package mjg

class PalindromeChecker {
    boolean isPalindrome(String s) {
        String ts = s.replaceAll(/[\W_]/, '').toLowerCase()
        ts == ts.reverse()
    }
}
