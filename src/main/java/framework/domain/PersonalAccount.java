package framework.domain;

import shared.Customer;

import java.io.Serializable;
import java.time.LocalDate;

public class PersonalAccount extends Customer implements Serializable {
    private LocalDate birthDate;

    public PersonalAccount(int customerId,
                           String name,
                           String street,
                           String city,
                           String state,
                           int zip,
                           String email,
                           LocalDate birthDate) {
        super(customerId, name, street, city, state, zip, email);
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
