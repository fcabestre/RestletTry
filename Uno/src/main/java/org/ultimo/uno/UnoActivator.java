package org.ultimo.uno;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.restlet.Server;
import org.restlet.data.Protocol;

/** @author Frédéric Cabestre */
public class UnoActivator implements BundleActivator {

    private Server server;

    public void start(BundleContext context) throws Exception {
        this.server = new UnoServer(Protocol.HTTP, 8554);
        this.server.start();
    }

    public void stop(BundleContext context) throws Exception {
        server.stop();
    }
}

