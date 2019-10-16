package mjg

import org.junit.Test

import static org.junit.Assert.assertTrue


class PalindromeCheckerTest {
	PalindromeChecker checker = new PalindromeChecker()

	@Test(expected=IllegalArgumentException)
	void testThrowsException() {
		throw new IllegalArgumentException()
	}
	
	@Test
	public void testIsPalindrome() {
		assert checker.isPalindrome("Flee to me, remote elf!")
		assertTrue(checker.isPalindrome("Flee to me, remote elf!"))
	}

}
