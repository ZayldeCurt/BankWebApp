package servlet;

import domain.BankAccount;
import domain.User;
import repository.BankAccountRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "accountServlet",urlPatterns = "/account")
public class accountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) request).getSession(false);
        User user = null;

        if(session!=null && session.getAttribute("user")!=null){
            user=(User) session.getAttribute("user");
            request.setAttribute("user",user);
            request.getRequestDispatcher("/account.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) request).getSession(false);
        User user = null;

        if(session!=null && session.getAttribute("user")!=null){
            user=(User) session.getAttribute("user");
            request.setAttribute("user",user);
            request.getRequestDispatcher("/account.jsp").forward(request,response);
        }
    }
}