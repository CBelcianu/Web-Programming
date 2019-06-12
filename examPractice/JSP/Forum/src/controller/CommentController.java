package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Authenticator;
import model.User;

public class CommentController extends HttpServlet {
    public CommentController() {
        super();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("user");
        String comment = request.getParameter("comment");

        Authenticator authenticator = new Authenticator();
        authenticator.deleteComment(username,comment);
        String password = authenticator.getPasswordFroUser(username);
        User user = new User(username,password);
        RequestDispatcher rd = request.getRequestDispatcher("/application.jsp");
        request.setAttribute("user",user);
        rd.forward(request,response);

    }
}