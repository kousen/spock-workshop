package mjg

class GroovyUtilityMethods implements UtilityMethods {
    @Override
    int[] getPositives(int... values) {
        values.findAll { it > 0 }
    }

    @Override
    boolean isPrime(int x) {
        if (x < 0) throw new IllegalArgumentException("argument must be > 0")
        int limit = Math.sqrt(x) + 1
        x == 2 || !(2..limit).find { n -> x % n == 0 }
    }

    @Override
    boolean isPalindrome(String s) {
        String test = s.replaceAll(/\W/, '').toLowerCase()
        test == test.reverse()
    }

    @Override
    int getMinimum(int... values) {
        (values as Collection).min()
    }
}
