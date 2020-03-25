package com.berezovska;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@WebServlet (urlPatterns = "/hello-from-html")
public class HelloFromHTMLServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String page = "";
        try (final BufferedReader reader = new BufferedReader(new FileReader(req.getServletContext().getRealPath("/html/hello.html")))) {
            String line;
            StringBuffer sb = new StringBuffer();
            while ((line=reader.readLine())!=null) {
                sb.append(line);
            }
            page = sb.toString();
        }

        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        resp.getWriter().write(page);
    }
}
