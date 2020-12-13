package ru.downloadfiles.servlets;

import ru.downloadfiles.models.User;
import org.hibernate.Session;

import org.hibernate.query.Query;
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
 * ServletForShowUsers
 *
 * @author Sherstobitov Mikhail
 * @version v1.0
 */
@WebServlet("/changeAccess")
public class ServletForShowUsers extends HttpServlet {


    Session session;

    @Override
    public void init() throws ServletException {
        ServletContext ctx = getServletContext();
        this.session = (Session) ctx.getAttribute("Session");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List <User> user = session.createQuery("from User user", User.class).getResultList();

        req.setAttribute("usersFromServer", user);
        req.getServletContext().getRequestDispatcher("/jsp/changeAccess.jsp").forward(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("name");
        int access;

        if(req.getParameter("access").equals("allowed")){
            access=1;
        }
        else access=0;
        session.beginTransaction();
        Query q=session.createQuery("from User where firstName = :first_name ");
        q.setParameter("first_name",firstName);
        User t= (User)q.getSingleResult();
        t.setAccess(access);
        session.getTransaction().commit();
        doGet(req, resp);
    }
}

