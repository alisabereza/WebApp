package com.berezovska;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final String username = req.getParameter("username");
        final String email = req.getParameter("email");
        final String password = req.getParameter("password");

        resp.getWriter().write(String.format("User was created: %s, %s, %s ",username, email,password));

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String page = "";
        try (final BufferedReader reader = new BufferedReader(new FileReader(req.getServletContext().getRealPath("/html/register.html")))) {
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

