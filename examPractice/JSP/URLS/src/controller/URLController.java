package controller;

import model.Authenticator;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class URLController extends HttpServlet {
    public URLController() {
        super();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        Authenticator authenticator = new Authenticator();
        String url = request.getParameter("url");
        String username = request.getParameter("user");
        authenticator.upVote(url);
        User user = new User(username, "abc");
        RequestDispatcher rd = request.getRequestDispatcher("/application.jsp");
        request.setAttribute("user", user);
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        Authenticator authenticator = new Authenticator();
        String url = request.getParameter("url");
        String username = request.getParameter("user");
        authenticator.delUrl(url);
        User user = new User(username, "abc");
        RequestDispatcher rd = request.getRequestDispatcher("/application.jsp");
        request.setAttribute("user", user);
        rd.forward(request, response);

    }
}