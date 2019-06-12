package controller;

import model.Authenticator;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CommentsController extends HttpServlet {
    public CommentsController() {
        super();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String topic = request.getParameter("topic");
        String username = request.getParameter("user");
        Authenticator authenticator = new Authenticator();
        String tot = authenticator.getComments(topic,username);
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<title>Comment Section</title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println(tot);
        printWriter.println("</body>");
        printWriter.println("</html>");
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        String topic = request.getParameter("topic");
        String username = request.getParameter("user");
        String comment = request.getParameter("comment");
        Authenticator authenticator = new Authenticator();
        String password = authenticator.getPasswordFroUser(username);
        authenticator.addComment(topic,username,comment);
        RequestDispatcher rd = request.getRequestDispatcher("/application.jsp");
        User user = new User(username,password);
        request.setAttribute("user",user);
        rd.forward(request,response);


    }
}