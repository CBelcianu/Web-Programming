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

public class AuthorizedController extends HttpServlet {
    public AuthorizedController() {
        super();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        Authenticator authenticator = new Authenticator();
        String username = request.getParameter("user");
        String N = request.getParameter("N");
        int n = Integer.parseInt(N);
        String tot = authenticator.getTopURLs(n, username);
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<title>TOP " + n + " URLs</title>");
        printWriter.println("<script src=\"script.js\"></script>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<h1>TOP " + n + " URLs</h1><br>");
        printWriter.println(tot);
        printWriter.println("</body>");
        printWriter.println("</html>");
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        Authenticator authenticator = new Authenticator();
        String url = request.getParameter("url");
        String username = request.getParameter("user");
        authenticator.addUrl(url,username);
        User user = new User(username, "abc");
        RequestDispatcher rd = request.getRequestDispatcher("/application.jsp");
        request.setAttribute("user", user);
        rd.forward(request, response);

    }
}