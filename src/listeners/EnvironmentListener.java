package listeners;

import io.github.cdimascio.dotenv.Dotenv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

public class EnvironmentListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // FIXME: Investigate why it does not load the .env
        Dotenv dotenv = Dotenv
                .configure()
                .ignoreIfMissing()
                .ignoreIfMalformed()
                .load();

        sce.getServletContext().setAttribute("DOTENV", dotenv);
    }
}
