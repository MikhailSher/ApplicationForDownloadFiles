package ru.downloadfiles.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 12.12.2020
 * ChangeAccessFilter
 *
 * @author Sherstobitov Mikhail
 * @version v1.0
 */
@WebFilter("/change")
public class ChangeAccessFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        // check if there is a session for this request
        HttpSession session = request.getSession(false);
        // check the required attributes
        if (session == null ||session.getAttribute("user")==null||!session.getAttribute("user").equals("admin")) {
            servletRequest.getServletContext().getRequestDispatcher("/addUser").forward(request, response);
        }
        else {
            servletRequest.getServletContext().getRequestDispatcher("/changeAccess").forward(request, response);
        }
        chain.doFilter(servletRequest, servletResponse);
    }
    @Override
    public void destroy() {

    }
}
