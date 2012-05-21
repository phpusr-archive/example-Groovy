package tests

/**
 * 
 * @author Sergey Doronin
 * Date: 21.05.12
 * Time: 12:18
 */


class MyPrivateClass {private int field}
MyPrivateClass myPrCl = new MyPrivateClass()
myPrCl.setField(34);
//myPrCl.field = 200
println myPrCl.field

