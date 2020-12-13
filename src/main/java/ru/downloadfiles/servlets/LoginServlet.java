package ru.downloadfiles.servlets;

import org.hibernate.query.Query;
import ru.downloadfiles.models.User;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;

/**
 * 12.12.2020
 * LoginServlet
 *
 * @author Sherstobitov Mikhail
 * @version v1.0
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    Session session;

    @Override
    public void init() throws ServletException {
        ServletContext ctx = getServletContext();
        this.session = (Session) ctx.getAttribute("Session");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //check if there is a user in the system
        String name = req.getParameter("name");
        String password = req.getParameter("password_signUp");

        session.beginTransaction();
        Query q=session.createQuery("from User where firstName = :first_name and password = :password");
        q.setParameter("first_name",name);
        q.setParameter("password",password);
        List results = q.getResultList();

        //if there is a user in the system
        if (!results.isEmpty()) {
            User t= (User)q.getSingleResult();
            // create a session
            HttpSession session = req.getSession();
            //put the necessary attributes
            session.setAttribute("user", t.getFirstName());
            session.setAttribute("access", t.getAccess());
            //redirect
            System.out.println(session.getId());
            req.getServletContext().getRequestDispatcher("/jsp/download.jsp").forward(req, resp);
        } else {
            req.getServletContext().getRequestDispatcher("/jsp/registration.jsp").forward(req, resp);
        }
        session.getTransaction().rollback();
    }
}
