package domain;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String firstName;
    String lastName;
    String email;
    Currency currency;
    String accountNumber;
    boolean activated;

    String password;

    @OneToOne(mappedBy = "user")
    BankAccount bankAccount;


}
