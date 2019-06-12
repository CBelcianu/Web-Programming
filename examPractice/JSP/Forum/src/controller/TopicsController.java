package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import model.Authenticator;
import model.User;

public class TopicsController extends HttpServlet {
    public TopicsController() {
        super();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("user");
        Authenticator authenticator = new Authenticator();
        String tot = authenticator.getTopics(username);
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<title>All Users</title>");
        printWriter.println("<script src=\"script.js\"></script>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println(tot);
        printWriter.println("</body>");
        printWriter.println("</html>");
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        String topic = request.getParameter("topic");
        String description = request.getParameter("description");
        String username = request.getParameter("user");
        Authenticator authenticator = new Authenticator();
        authenticator.addTopic(topic,description,username);

        String password = authenticator.getPasswordFroUser(username);
        RequestDispatcher rd = request.getRequestDispatcher("/application.jsp");
        User user = new User(username,password);
        request.setAttribute("user",user);
        rd.forward(request,response);

    }
}