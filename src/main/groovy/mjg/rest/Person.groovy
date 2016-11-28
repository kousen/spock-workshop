package mjg.rest

import groovy.transform.Canonical

@Canonical
class Person {
    Long id
    String first
    String last

    String toString() {
        "$id: $first $last"
    }
}
