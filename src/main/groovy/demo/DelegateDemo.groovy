package demo

class DelegateDemo {

    void append (String arg) {
        println "append was called with arg $arg"
    }

    void doit() {

        def c = {
            append 'Jeff '
            append 'Is In Florida'
        }

        def sb = new StringBuffer()
        c.delegate  = sb

        c.resolveStrategy = Closure.DELEGATE_FIRST
        c()

        println "Buffer: $sb"
    }

    static void main(args) {
        new DelegateDemo().doit()
    }
}
