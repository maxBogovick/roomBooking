package controller.filter;

import model.util.AttributesManager;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public class LocaleFilter implements Filter {
    private static final Logger logger = Logger.getLogger(LocaleFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        logger.info("localisation filter");
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        String path = request.getRequestURI();

        path = path.replaceAll("language/", "");

        if (path.equals("/views//")) {
            path = "/api/";
        }

        String language = request.getParameter("language");

        boolean isEnglish = language.equals("EN");
        boolean isUkrainian = language.equals("UA");


        if (isEnglish) {
            request.getSession().setAttribute("language", "en-EN");
        } else if (isUkrainian) {
            request.getSession().setAttribute("language", "uk-UA");
        }

        logger.info("session language " + request.getSession().getAttribute("language"));
        response.sendRedirect(path);
    }

    @Override
    public void destroy() {

    }
}
