package servlet;

import entity.User;
import exception.calc.OperationsNotFoundException;
import service.CalcService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/calc", name = "CalcServlet")
public class CalcServlet extends HttpServlet {
    CalcService calcService = new CalcService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/calc.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double x = Double.parseDouble(req.getParameter("num1"));
        double y = Double.parseDouble(req.getParameter("num2"));
        String command = req.getParameter("command");
        User userInSession = (User) req.getSession().getAttribute("user");

        try {
            Double result = calcService.execute(command,x,y,userInSession.getUsername());
            req.setAttribute("result",result);
        } catch (OperationsNotFoundException e) {
            req.setAttribute("result",e.getMessage());
        }

        getServletContext().getRequestDispatcher("/WEB-INF/calc.jsp").forward(req,resp);
    }
}