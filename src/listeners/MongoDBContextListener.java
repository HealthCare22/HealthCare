package listeners;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import io.github.cdimascio.dotenv.Dotenv;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

public class MongoDBContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();

        Dotenv dotenv = (Dotenv) ctx.getAttribute("DOTENV");

        try {
            // FIXME: Remove the default value!!!
            String connectionURI = dotenv.get("MONGODB_CONNECTION_STRING", "mongodb+srv://root:root@healthcare.i5mrfxx.mongodb.net/test");
            MongoClient mongo = MongoClients.create(connectionURI);

            ctx.setAttribute("MONGO_CLIENT", mongo);
        } catch (MongoException e) {
            throw new RuntimeException("MongoClient init failed");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        MongoClient mongo = (MongoClient) sce.getServletContext().getAttribute("MONGO_CLIENT");
        mongo.close();
        System.out.println("MongoClient closed successfully");
    }
}
