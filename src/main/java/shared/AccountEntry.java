package shared;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AccountEntry implements Serializable {
    private double amount;
    private Date date;
    private String description;
    private String fromAccountNumber;
    private String fromPersonName;

}
