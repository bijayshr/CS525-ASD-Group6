package shared;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class Customer {
    private int customerId;
    private String name;
    private String street;
    private String city;
    private String state;
    private int zip;
    private String email;
    private Set<Account> accountList;

    public Customer(int customerId, String name,
                    String street, String city,
                    String state, int zip,
                    String email) {
        this.customerId = customerId;
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.accountList = new HashSet<>();
    }
}
