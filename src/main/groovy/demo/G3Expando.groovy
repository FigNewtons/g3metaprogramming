package demo

class G3Expando {

    protected dynamicProps = [:]

    void setProperty(String propName, value) {
        dynamicProps[propName] = value
    }

    def getProperty(String propName) {
        dynamicProps[propName]
    }

    def methodMissing(String methodName, args) {
        def prop = dynamicProps[methodName]
        if(prop != null) {
            if (prop instanceof Closure) {
                return prop(*args)
            }

            return 42
        }
        throw new MissingMethodException(methodName, G3Expando, args)
    }
}
