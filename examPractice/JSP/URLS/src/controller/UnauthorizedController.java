package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import model.Authenticator;

public class UnauthorizedController extends HttpServlet {
    public UnauthorizedController() {
        super();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        Authenticator authenticator = new Authenticator();
        String tot = authenticator.getTop10();
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<title>TOP 10 URLs</title>");
        printWriter.println("<script src=\"script.js\"></script>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<h1>TOP 10 URLs</h1><br>");
        printWriter.println(tot);
        printWriter.println("</body>");
        printWriter.println("</html>");
    }
}
