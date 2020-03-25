package com.berezovska;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/getUsers")
public class UsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user1 = new User("Barak Obama", "bo@mail.ru");
        User user2 = new User("Donald Trump", "dt@mail.ru");
        req.setAttribute("users", List.of(user1, user2));
        req.getRequestDispatcher("/html/users.jsp").forward(req, resp);

    }
}
