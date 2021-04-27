package servlet;

import entity.User;
import exception.user.UserException;
import service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/signin", name = "SignInServlet")
public class SignInServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/signin.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try {
            User userInSession = userService.getUser(username,password);
            req.getSession().setAttribute("user", userInSession);
            resp.sendRedirect("/home");
        } catch (UserException e) {
            req.setAttribute("smessage",e.getMessage());
            getServletContext().getRequestDispatcher("/WEB-INF/signin.jsp").forward(req,resp);
        }
    }
}
