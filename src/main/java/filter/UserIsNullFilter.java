package filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = {"CalcHistoryServlet", "CalcServlet", "ChangePasswordServlet", "HomeServlet", "LogOutServlet", "UsersServlet"})
public class UserIsNullFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getSession().getAttribute("user") == null){
            res.sendRedirect("/reg");
        }else {
            chain.doFilter(req,res);
        }
    }
}
