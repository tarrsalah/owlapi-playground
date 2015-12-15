/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.StaticHttpHandler;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author tarrsalah
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({Tutorial2011Test.class})
public class AllTests {

    private static final int PORT = 3001;
    private static final String BASE_URL = "http://localhost";
    private static HttpServer server;

    @BeforeClass
    public static void setUp() throws IOException {
        AllTests.server = GrizzlyHttpServerFactory
                .createHttpServer(UriBuilder.fromUri(BASE_URL).port(PORT).build());

        AllTests.server.getServerConfiguration().addHttpHandler(
                new StaticHttpHandler("src/main/resources"
                ), "/");
        AllTests.server.start();
    }

    @AfterClass
    public static void tearDown() {
        AllTests.server.shutdown();
    }
}
