
/**
 * 
 * @author Sergey Doronin
 * Date: 21.05.12
 * Time: 12:36
 */
class PersonA implements Comparable {
    def firstname, initial, surname
    PersonA(f,i,s) { firstname = f; initial = i; surname = s }
    int compareTo(other) { firstname <=> other.firstname }
}
a = new PersonA('James', 'T', 'Kirk')
b = new PersonA('Samuel', 'L', 'Jackson')
println a <=> b
// => -1

class PersonB extends PersonA {
    PersonB(f,i,s) { super(f,i,s) }
    int compareTo(other) { println ">>compareTo"; initial <=> other.initial; }
}

a = new PersonB('James', 'T', 'Kirk')
b = new PersonB('Samuel', 'L', 'Jackson')
println a <=> b
// => 1

class Parent {
    private name // my child's name
    def setChildName(value) { name = value }
    def getChildName() { name }
}
class GrandParent extends Parent {
    private name // my grandchild's name
    def setgrandChildName(value) { name = value }
    def getGrandChildName() { name }
}
g = new GrandParent()
g.childName = 'Jason'
g.grandChildName = 'Rachel'
println g.childName       // => Jason
println g.grandChildName  // => Rachel
