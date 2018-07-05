package servlet;

import domain.BankAccount;
import domain.User;
import repository.BankAccountRepository;
import repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;

@WebServlet(name = "loginServlet",urlPatterns = "/login")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        String email = request.getParameter("email");
        String userPassword = request.getParameter("userPassword");
        boolean remeberMe = request.getParameter("remeberMe")!=null;

        Optional<User> optionalUser = UserRepository.findByEmail(email, userPassword);
        User user=null;
        BankAccount bankAccount = null;
        Optional<BankAccount> optionalBankAccount = null;

        if(optionalUser.isPresent()){
            user=optionalUser.get();
//            if(user.isActivated()){
                session.setAttribute("user",user);
                optionalBankAccount = BankAccountRepository.findBankAccount(user.getBankAccount().getAccountNumber());

                if(optionalBankAccount.isPresent()) {
                    bankAccount = optionalBankAccount.get();
                }
                if(remeberMe){
                    session.setMaxInactiveInterval(60*30);
                }
                else{
                    session.setMaxInactiveInterval(60*5);
                }

                Cookie cookieMoje =new Cookie("bankAccountNumber",bankAccount.getAccountNumber());
                cookieMoje.setMaxAge(6000);
                response.addCookie(cookieMoje);

                long myCreationTime = session.getCreationTime();
                long actualTime = System.currentTimeMillis();

                Date myCreationDate = new Date(myCreationTime);
                Date actualDate = new Date(actualTime);

                request.setAttribute("bankAccount",bankAccount);
                request.setAttribute("actualDate",actualDate);
                request.setAttribute("myCreationDate",myCreationDate);
                request.setAttribute("user",user);



                request.getRequestDispatcher("/account.jsp").forward(request,response);


//            }
//            else{
//                request.setAttribute("activated",false);
//                request.getRequestDispatcher("/login.jsp").forward(request,response);
//            }

        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String something = "nothing";
    }
}
