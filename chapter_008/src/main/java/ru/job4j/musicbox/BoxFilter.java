package ru.job4j.musicbox;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * This class represents class for autorisation.
 * @author Svyatoslav Sabirov.
 * @since 09.05.2018
 * @version 7.
 */
public class BoxFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (request.getRequestURI().contains("auto")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpSession session = request.getSession();
            synchronized (session) {
                if (session.getAttribute("login") == null) {
                    ((HttpServletResponse) servletResponse).sendRedirect(String.format("%s/auto", request.getContextPath()));
                    return;
                }
            }
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
