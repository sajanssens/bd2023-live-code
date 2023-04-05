package nl.bramjanssens.inheritance;

public interface Calculatable {

    double calculateSalary();


    default int plus42(int i){
        return i + 42;
    }

}
