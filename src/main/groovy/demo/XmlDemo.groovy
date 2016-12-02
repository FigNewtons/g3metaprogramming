package demo

class XmlDemo {

    static void main(args) {
        def xml = new groovy.xml.MarkupBuilder()

        xml.music {
            progRock {
                band 'Yes'
                band 'King Crimson'
            }
        }
    }
}
