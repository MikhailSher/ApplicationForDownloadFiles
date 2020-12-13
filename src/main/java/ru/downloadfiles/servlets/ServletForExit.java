package ru.downloadfiles.servlets;

import org.hibernate.Session;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 12.12.2020
 * ServletForStart
 *
 * @author Sherstobitov Mikhail
 * @version v1.0
 */

@WebServlet("/exit")
public class ServletForExit extends HttpServlet {

    @Override
    public void init() throws ServletException {
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("user");
        session.removeAttribute("access");
        req.getServletContext().getRequestDispatcher("/start").forward(req, resp);
    }
}
