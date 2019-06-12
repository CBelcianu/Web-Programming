package ro.controller;

import ro.model.Authenticator;
import ro.model.PartialUser;
import ro.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProfileController extends HttpServlet {
    public ProfileController() {
        super();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PartialUser partialUser = new PartialUser(username,password);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/profile.jsp");
        Authenticator authenticator = new Authenticator();
        User user = authenticator.getFromPartialUser(partialUser);
        request.setAttribute("user1",user);
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String town = request.getParameter("town");
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/application.jsp");
        Authenticator authenticator = new Authenticator();
        authenticator.updateInfo(username,password,email,town);
        PartialUser user = new PartialUser(username, password);
        request.setAttribute("user", user);
        rd.forward(request, response);
    }
}
