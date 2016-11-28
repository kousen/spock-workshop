import spock.lang.Specification

class DequeSpec extends Specification {
    Deque deque = [1, 2, 3] as ArrayDeque

    def 'size of deque ought to be 3'() {
        expect:
        deque.size() == 3
    }

    def 'removeFirst removes elements in added order'() {
        expect:
        deque.removeFirst() == 1
        deque.removeFirst() == 2
        deque.removeFirst() == 3
    }

    def 'removeLast removes elements in reverse order'() {
        expect:
        deque.removeLast() == 3
        deque.removeLast() == 2
        deque.removeLast() == 1
    }

    def 'addFirst and removeLast pair'() {
        given:
        deque = new ArrayDeque()

        when:
        deque.addFirst('a')
        deque.addFirst('b')
        deque.addFirst('c')

        then:
        deque.removeLast() == 'a'
        deque.removeLast() == 'b'
        deque.removeLast() == 'c'
    }

    def 'removeFirst on empty deque throws exception'() {
        given:
        deque = new ArrayDeque()

        when:
        deque.removeFirst()

        then:
        thrown(NoSuchElementException)
    }

    def 'offerLast and pollFirst pair'() {
        given:
        deque = new ArrayDeque()

        when:
        deque.offerLast(1)
        deque.offerLast(2)
        deque.offerLast(3)

        then:
        deque.pollFirst() == 1
        deque.pollFirst() == 2
        deque.pollFirst() == 3
    }

    def 'pollFirst on empty deque does not throw exception'() {
        given:
        deque = new ArrayDeque()

        when:
        deque.pollFirst()

        then:
        noExceptionThrown()
    }

    def 'removeLast on empty deque throws exception'() {
        given:
        deque = new ArrayDeque()

        when:
        deque.removeLast()

        then:
        thrown(NoSuchElementException)
    }

    def 'pollLast on empty deque does not throw exception'() {
        given:
        deque = new ArrayDeque()

        when:
        deque.pollLast()

        then:
        noExceptionThrown()
    }

    def 'can not add a null to an ArrayDeque'() {
        when:
        deque.addLast(null)

        then:
        thrown(NullPointerException)
    }

    def 'can add a null to a LinkedList'() {
        given:
        deque = new LinkedList()

        when:
        deque.addLast(null)

        then:
        noExceptionThrown()
    }

    def 'examine elements'() {
        expect:
        deque.peekFirst() == 1
        deque.peekFirst() == 1
    }
}
