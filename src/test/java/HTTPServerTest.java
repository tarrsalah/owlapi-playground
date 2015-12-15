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

/**
 *
 * @author tarrsalah
 */
public class HTTPServerTest {

    private static final int PORT = 3001;
    private static final String BASE_URL = "http://localhost";
    private static HttpServer server;

    @BeforeClass
    public static void setUp() throws IOException {
        HTTPServerTest.server = GrizzlyHttpServerFactory
                .createHttpServer(UriBuilder.fromUri(BASE_URL).port(PORT).build());

        HTTPServerTest.server.getServerConfiguration().addHttpHandler(
                new StaticHttpHandler("src/main/resources"
                ), "/");
        HTTPServerTest.server.start();
    }

    @AfterClass
    public static void tearDown() {
        HTTPServerTest.server.shutdown();
    }
}
