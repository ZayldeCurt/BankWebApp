import domain.BankAccount;
import domain.Currency;
import domain.User;
import repository.BankAccountRepository;
import repository.UserRepository;

import java.math.BigDecimal;

public class app {

    public static void main(String[] args) {
        User user = User.builder()
                .lastName("Nowak")
                .firstName("Adam")
                .email("test@test.pl")
                .password("qwerty")
                .accountNumber("123456789")
                .currency(Currency.PLN)
                .build();
        UserRepository.saveOrUpdate(user);

        User user2 = User.builder()
                .lastName("Kowalski")
                .firstName("Marcin")
                .email("test2@test2.pl")
                .password("qwerty")
                .accountNumber("987654321")
                .currency(Currency.PLN)
                .build();
        UserRepository.saveOrUpdate(user2);

        BankAccount bankAccount = BankAccount.builder()
                .accountNumber("123456789")
                .balance(new BigDecimal(100))
                .freeFunds(new BigDecimal(80))
                .currency(Currency.PLN)
                .user(UserRepository.findUser(1L).get())
                .build();
        BankAccountRepository.saveOrUpdate(bankAccount);

        BankAccount bankAccount2 = BankAccount.builder()
                .accountNumber("987654321")
                .balance(new BigDecimal(1000))
                .freeFunds(new BigDecimal(950))
                .currency(Currency.PLN)
                .user(UserRepository.findUser(2L).get())
                .build();
        BankAccountRepository.saveOrUpdate(bankAccount2);
    }
}
