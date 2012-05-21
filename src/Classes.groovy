/**
 * 
 * @author Sergey Doronin
 * Date: 21.05.12
 * Time: 12:00
 */

/**
 * Classes and Objects
 */

/* Описание и создание класса(по умолчанию класс имеет тип доступа public,
а переменные класса имеют тип доступа private,
но компилятор groovy сам сделает для этих полей геттеры и сеттеры с доступом public): */

class Human {
    String name
    int age

    void setName(String name) {
        this.name = name + "-suka"
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

def man = new Human();
man.name = "Adam"
man.age = 25;

def woman = new Human(name: "Eva", age: 22 )

println "$man, $woman"

//Для обновления поля или полей можно использовать такой подход:

man.with{
    name = "Other Name"
    age = 34
}

/* Примеры */
// Классы могут не иметь конструктора
class MyClass { }

class MyClassA {
    private name
    def getName() { name }
    def setName(name) { this.name = name }
}
// or
class MyClassAB {
    def name
}
// or
class MyClassAC{
    final age      // только getter
    def name       // getter и setter
    private color  // private
    def setColor() { this.color = color } // только setter
}

class MyClassB {
    def start = new Date()
    final String name = "John"
    MyClassB(date, name) {
        start = date
        this.name = name
    }
}
MyClassB b = new MyClassB(new Date(), "Adam")
println b.name

class MyClassC {

    static personCounter=10
    def age, username
    private alive = false

    def isAlive() {
        alive
    }

    static getCounter() {
        personCounter
    }
}

class DynamicClass { def name, age }
p = new DynamicClass()
p.name = "Adam"
p.age = 13
println p.name

class StaticClass { String name; int age; }
ps = new StaticClass(name:'Adam', age: 23)
println ps.name
