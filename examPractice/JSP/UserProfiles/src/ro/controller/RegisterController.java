package ro.controller;

import ro.model.Authenticator;
import ro.model.PartialUser;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterController extends HttpServlet {
    public RegisterController() {
        super();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));
        String town = request.getParameter("town");
        String photo = request.getParameter("photo");
        RequestDispatcher rd = null;
        Authenticator authenticator = new Authenticator();
        authenticator.register(username,password,email,age,town,photo);
        rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }

}
