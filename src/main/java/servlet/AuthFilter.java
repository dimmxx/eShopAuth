package servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {

    private FilterConfig config = null;
    private boolean isActive = false;

    @Override
    public void init(FilterConfig config) {
        this.config = config;
        String act = config.getInitParameter("active");
        if (act != null) {
            isActive = (act.equalsIgnoreCase("true"));
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(false);

        if (isActive) {
            if (session.getAttribute("role") != null) {
                servletRequest.setAttribute("filter", "filter passed");
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                servletRequest.setAttribute("filter", "declined");
                RequestDispatcher rd = req.getRequestDispatcher("loginForm.jsp");
                rd.forward(req, resp);
//              resp.sendRedirect("loginForm.jsp");
            }
        }
    }

    @Override
    public void destroy() {
        config = null;
    }
}
