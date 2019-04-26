

package controller.filter;

import controller.commands.mainCommand.util.Util;
import model.entity.User;
import model.entity.types.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AccessFilter implements Filter {

    private List<String> allowedUrls = new ArrayList<>();
    private List<String> clientUrls = new ArrayList<>();
    private List<String> adminUrls = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) {
        String initParameter = filterConfig.getInitParameter("allowed-urls");
        if (initParameter != null && !initParameter.isEmpty()) {
            allowedUrls = Arrays.stream(initParameter.split(","))
                    .map(String::trim)
                    .collect(Collectors.toList());
        }
        String clientParameter = filterConfig.getInitParameter("client-urls");
        if (clientParameter != null && !clientParameter.isEmpty()) {
            clientUrls = Arrays.stream(clientParameter.split(","))
                    .map(String::trim)
                    .collect(Collectors.toList());
        }
        String adminParameter = filterConfig.getInitParameter("admin-urls");
        if (adminParameter != null && !adminParameter.isEmpty()) {
            adminUrls = Arrays.stream(adminParameter.split(","))
                    .map(String::trim)
                    .collect(Collectors.toList());
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (allowedUrls.contains(request.getRequestURI())) {
            filterChain.doFilter(request, response);
            return;
        }

        final HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("User") != null) {
            User user = (User) session.getAttribute("User");
            if (Role.ADMIN.getRole() == user.getRole())  {
                if (adminUrls.contains(request.getRequestURI())) {
                    filterChain.doFilter(request, response);
                    return;
                }
            }
            if (Role.CLIENT.getRole() == user.getRole()) {
                //todo check for client grants
                if (clientUrls.contains(request.getRequestURI())) {
                    filterChain.doFilter(request, response);
                    return;
                }
            }
            if (Role.VIZITOR.getRole() == user.getRole()) {
                //todo check for visitor grants
                System.out.println("I'm visitor");
            }
        }

        request.getRequestDispatcher("/api/" + Util.ERROR_PAGE.getPath()).forward(request, response);
    }

    @Override
    public void destroy() {

    }
}