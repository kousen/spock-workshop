package mjg.rest

import groovy.json.JsonBuilder
import groovy.transform.Canonical
import groovy.transform.EqualsAndHashCode
import groovy.xml.MarkupBuilder

import javax.xml.bind.annotation.XmlRootElement

@Canonical
class Person {
    Long id
    String first
    String last

    String toString() {
        "$id: $first $last"
    }
}
