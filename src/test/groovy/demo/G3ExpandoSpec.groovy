package demo

import spock.lang.Specification

class G3ExpandoSpec extends Specification {

    void 'test property access'() {
        when:
        def ex = new G3Expando()
        ex.favoriteFramework = 'Grails'

        then:
        ex.favoriteFramework == 'Grails'
    }

    void 'test method invocation'() {
        when:
        def ex = new G3Expando()
        ex.addNumbers = { x, y, z ->
            x + y + z
        }

        then:
        100 == ex.addNumbers(30, 20, 50)
    }

    void 'test method invocation for non-closure'() {
        when:
        def ex = new G3Expando()
        ex.addNumbers = 'Yay!'

        then:
        42 == ex.addNumbers(30, 20, 50)
    }
    
    void 'test method invocation non existent property'() {
        when:
        def ex = new G3Expando()
        ex.foo(30, 20, 50)

        then:
        thrown(MissingMethodException)
    }
}
