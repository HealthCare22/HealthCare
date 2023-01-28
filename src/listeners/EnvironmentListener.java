package listeners;

import io.github.cdimascio.dotenv.Dotenv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

public class EnvironmentListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Dotenv dotenv = Dotenv
                .configure()
                .ignoreIfMalformed()
                .ignoreIfMissing()
                .load();

        System.out.println(dotenv.entries());

        sce.getServletContext().setAttribute("DOTENV", dotenv);
    }
}
