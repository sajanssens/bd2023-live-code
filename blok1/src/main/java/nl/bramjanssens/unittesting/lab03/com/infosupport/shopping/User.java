package nl.bramjanssens.unittesting.lab03.com.infosupport.shopping;


import nl.bramjanssens.unittesting.lab03.com.infosupport.shopping.utility.AgeCalculator;

import java.time.LocalDate;

public record User(String name, LocalDate dateOfBirth, String accountNumber) {
    public int getAge() {
        return AgeCalculator.calculate(dateOfBirth, LocalDate.now());
    }
}
