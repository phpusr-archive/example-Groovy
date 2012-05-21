/**
 * 
 * @author Sergey Doronin
 * Date: 21.05.12
 * Time: 11:29
 */

/**
 * Closure - это замыкание и представляет из себя некую анонимную функцию со свойствами обьекта.
 * Синтаксис замыкания : { [closureArguments->] statements }
 */

def closureFunction = {a, b ->
    println a
    println b

    def closureA = { it }
    assert closureA()  == null
    assert closureA(1) == 1
}

closureFunction(1, 2)


/* More Closure Examples */

//Вызов замыкания:
def c = { it, arg-> println "${it} ${arg}" }
c.call("A", "B") // первый тип вызова
c("C", "D") // второй тип вызова

//Определение замыкания в классе и его вызов:
public class A {
    private int member = 20;

    private String method() {
        return "hello";
    }

    def publicMethod (String name_) {
        def localVar = member + 5;
        def localVar2 = "Parameter: ${name_}";
        return {
            println "${member} ${name_} ${localVar} ${localVar2} ${method()}"
        }
    }

    def mew() {
        return {
            println "Mew"
            5
        }
    }
}

A sample = new A();
def closureVar = sample.publicMethod("Xavier");
closureVar();

def mew = sample.mew();
println mew();


