package demo

import spock.lang.Specification

class MySpec extends Specification{

    void 'test something'() {
        expect:
        'Jeff'.toUpperCase() == 'JEFF'
    }
}
