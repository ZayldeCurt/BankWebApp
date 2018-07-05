package servlet;

import domain.User;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "logoutServlet",urlPatterns = "/logout")
@Slf4j
public class logoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) request).getSession(false);

        if(session!=null && session.getAttribute("user")!=null){
            session.setAttribute("user",null);
            log.info("Uzytkownik wylogowany");
            ((HttpServletResponse)response).sendRedirect("/login.jsp");
        }else{
            ((HttpServletResponse)response).sendRedirect("/login.jsp");
        }
    }
}
