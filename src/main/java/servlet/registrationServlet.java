package servlet;

import domain.BankAccount;
import domain.Currency;
import domain.User;
import repository.BankAccountRepository;
import repository.UserRepository;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.Random;

@WebServlet(name = "registrationServlet",urlPatterns = "/registration")
public class registrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String email = request.getParameter("email");
        String userPassword = request.getParameter("userPassword");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");


        Optional<User> optionalUser = UserRepository.findByEmail(email, userPassword);
        User user = null;
        BankAccount bankAccount = null;
        if(!optionalUser.isPresent()){
            String accountNumber = ""+(new Random()).nextInt(10000);
            Optional<BankAccount> optionalBankAccount = BankAccountRepository.findBankAccount(accountNumber);
            if (!optionalBankAccount.isPresent()){
                user = User.builder()
                    .firstName(firstName)
                    .lastName(lastName)
                    .email(email)
                    .password(userPassword)
                    .currency(Currency.PLN)
                    .build();
                bankAccount = BankAccount.builder()
                        .user(user)
                        .currency(Currency.PLN)
                        .accountNumber(accountNumber)
                        .balance(new BigDecimal(0))
                        .freeFunds(new BigDecimal(0))
                        .build();
                UserRepository.saveOrUpdate(user);
                BankAccountRepository.saveOrUpdate(bankAccount);
            }
        }

        ((HttpServletResponse)response).sendRedirect("/login.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
