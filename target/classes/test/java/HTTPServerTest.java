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
import org.junit.After;
import org.junit.Before;

/**
 *
 * @author tarrsalah
 */
public class HTTPServerTest {

    private static final int PORT = 3001;
    private static final String BASE_URL = "http://localhost";
    private final HttpServer server;

    public HTTPServerTest() {
        this.server = GrizzlyHttpServerFactory
                .createHttpServer(UriBuilder.fromUri(BASE_URL).port(PORT).build());
    }

    @Before
    public void setUp() throws IOException {
        this.server.getServerConfiguration().addHttpHandler(               
                new StaticHttpHandler("src/main/resources"
                ), "/");
        this.server.start();
    }

    @After
    public void tearDown() {
        this.server.shutdown();
    }
}
