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
import java.io.PrintWriter;

public class ProfilesController extends HttpServlet {
    public ProfilesController() {
        super();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        RequestDispatcher rd;

        Authenticator authenticator = new Authenticator();
        String tot = authenticator.getProfiles(username);
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<title>All Users</title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println(tot);
        printWriter.println("</body>");
        printWriter.println("</html>");
    }

}
