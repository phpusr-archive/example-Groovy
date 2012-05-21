package tests

/**
 * 
 * @author Sergey Doronin
 * Date: 10.05.12
 * Time: 17:36
 */


class Person {
    String firstName;
    String lastName;

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

Person person = new Person();
person.firstName = "John";
println person;