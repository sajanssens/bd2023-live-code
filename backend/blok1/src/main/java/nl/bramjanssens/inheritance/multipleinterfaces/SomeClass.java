package nl.bramjanssens.inheritance.multipleinterfaces;

public class SomeClass implements I1, I2 {
    @Override
    public void method1() {
        // when calling the default methods, since you inherit
        // two with the same
        I1.super.someDefaultMethod();
        I2.super.someDefaultMethod();
    }

    @Override
    public void someDefaultMethod() {
        I2.super.someDefaultMethod();
    }
}
