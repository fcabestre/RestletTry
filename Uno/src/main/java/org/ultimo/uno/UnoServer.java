package org.ultimo.uno;

import org.restlet.Server;
import org.restlet.data.Protocol;

/** @author Frédéric Cabestre */
public class UnoServer extends Server {

    public UnoServer(Protocol protocol, int port) {
        super(protocol, port);
    }
}

