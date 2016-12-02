package demo

class EmcDemo {

    static void main(args) {
        Widget.metaClass.methodMissing = { String mn, a ->
            println "In methodMissing for $mn"

            def impl = {
                mn.toUpperCase()
            }
            Widget.metaClass."${mn}" = impl

            impl()
        }

        def w = new Widget()

        println w.foo()
        println w.foo()
        println w.bar()
        println w.foo()
        println w.bar()
        println w.baz()
    }
}

class Widget {}
