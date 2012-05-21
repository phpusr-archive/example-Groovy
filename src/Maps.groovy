
/**
 * 
 * @author Sergey Doronin
 * Date: 21.05.12
 * Time: 11:05
 */

/**
 * Maps (Отображения)
 */

def someMap = ['a' : 1, 'b' : 2, 'c' : 3, "gg" : "hi"]

def emptyMap = [:] //Объявление пустой мапы

println(someMap['a']);
println(someMap.a);

println(someMap);
println(emptyMap);

for (e in someMap) {
    print "$e, ";
}
println()

def myMap = ["map1" : 2, "map 2" : "figa se"]
println myMap."map 2"
println myMap

