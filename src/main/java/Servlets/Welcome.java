package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/welcome")
public class Welcome extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String username = null;
        
        if (session != null) {
            username = (String) session.getAttribute("username");
        }

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Welcome</title>");
        out.println("<style>");
        out.println("body {");
        out.println("    background-color: #000000;");
        out.println("    color: #ffffff;");
        out.println("    display: flex;");
        out.println("    justify-content: center;");
        out.println("    align-items: center;");
        out.println("    height: 100vh;");
        out.println("    margin: 0;");
        out.println("    font-family: Arial, sans-serif;");
        out.println("}");
        out.println(".container {");
        out.println("    background-color: #ffffff;");
        out.println("    color: #000000;");
        out.println("    padding: 20px;");
        out.println("    border-radius: 10px;");
        out.println("    text-align: center;");
        out.println("}");
        out.println("button {");
        out.println("    background-color: #000000;");
        out.println("    color: #ffffff;");
        out.println("    border: none;");
        out.println("    padding: 10px 20px;");
        out.println("    border-radius: 5px;");
        out.println("    cursor: pointer;");
        out.println("    font-size: 16px;");
        out.println("}");
        out.println("button:hover {");
        out.println("    background-color: #333333;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        if (username != null) {
            out.println("<h2>Welcome, " + username + "!</h2>");
        } else {
            out.println("<h2>Welcome, Guest!</h2>");
        }
        out.println("<form action='logout' method='post'>");
        out.println("<button type='submit'>Logout</button>");
        out.println("</form>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
