package ru.downloadfiles.servlets;

import org.hibernate.query.Query;
import ru.downloadfiles.models.User;
import org.hibernate.Session;
import javax.servlet.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 12.12.2020
 * ServletForAddUser
 *
 * @author Sherstobitov Mikhail
 * @version v1.0
 */
@WebServlet("/addUser")
public class ServletForAddUser extends HttpServlet {

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
        String firstName = req.getParameter("first-name");


        //check if there is a user in the system
        session.beginTransaction();
        Query q=session.createQuery("from User where firstName = :first_name");
        q.setParameter("first_name",firstName);
        List results = q.getResultList();

        //if there is a user in the system
        if (!results.isEmpty()) {
            req.getServletContext().getRequestDispatcher("/jsp/registration.jsp").forward(req, resp);
            session.getTransaction().rollback();
            doGet(req,resp);
            throw new ServletException("User already exist");
        }

        //if there is no user in the system
        String lastName = req.getParameter("last-name");
        String password = req.getParameter("password");
        int access=1;

        session.save(new User(firstName, lastName,access,password));
        session.getTransaction().commit();
        req.getServletContext().getRequestDispatcher("/jsp/registration.jsp").forward(req, resp);

    }
}
