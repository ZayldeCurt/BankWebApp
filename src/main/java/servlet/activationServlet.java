package servlet;

import domain.User;
import repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "activationServlet",urlPatterns = "/activationServlet")
public class activationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String number = request.getParameter("number");
        Long id = Long.parseLong(userId);
        Optional<User> optionalUser = UserRepository.findUser(id);
        User user = null;
        if(optionalUser.isPresent()){
            user=optionalUser.get();
            String userNumber = user.getAccountNumber();
            if(userNumber.equals(number)){
                user.setActivated(true);
                UserRepository.saveOrUpdate(user);
                System.out.println("yupi ja ej mother fucker");
            }
        }
    }
}
