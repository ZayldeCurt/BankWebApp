package filters;

import domain.User;
import lombok.extern.slf4j.Slf4j;
import mailMethod.SendMail;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter",urlPatterns = "/account.jsp"
,dispatcherTypes = DispatcherType.FORWARD)
@Slf4j
public class AuthenticationFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) req).getSession(false);
        User user = null;

        if(session!=null && session.getAttribute("user")!=null){
            user=(User) session.getAttribute("user");
            log.info("Uzytkownik "+user.getFirstName()+" posiada sesję");
            if(user.isActivated()){
                chain.doFilter(req, resp);
                session.setAttribute("notActivated",false);
            }else{
                SendMail.sendNewMail(user);
                session.setAttribute("notActivated",true);
                ((HttpServletResponse)resp).sendRedirect("/login.jsp");
            }

        }else{
//            System.err.println("Nie ma użytkownika lub sesji");
            log.info("Nie ma użytkownika lub sesji");
            ((HttpServletResponse)resp).sendRedirect("/login.jsp");
        }



    }

    public void init(FilterConfig config) throws ServletException {

    }

}
