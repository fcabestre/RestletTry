package org.ultimo.uno;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.Server;
import org.restlet.data.MediaType;
import org.restlet.data.Protocol;

/** @author Frédéric Cabestre */
public class UnoActivator implements BundleActivator {

    private Server server;

    public void start(BundleContext context) throws Exception {
        server = new Server(Protocol.HTTP, 8554, new Restlet() {
            @Override
            public void handle(Request request, Response response) {
                response.setEntity("Hello world!", MediaType.TEXT_PLAIN);
            }
        });

        server.start();
    }

    public void stop(BundleContext context) throws Exception {
        server.stop();
    }
}

