package org.ultimo.uno;

import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;
import org.restlet.Restlet;
import org.restlet.Server;
import org.restlet.Uniform;
import org.restlet.data.Protocol;

/** @author Frédéric Cabestre */
@Component
public class UnoServer extends Server {

    public UnoServer(Protocol protocol, int port) {
        super(protocol, port);
    }

    @Reference(service = Uniform.class)
    public void addRestlet(Restlet restlet) {
        System.out.println("Restlet added: " + restlet.getName());
        this.setNext(restlet);
    }

    public void removeRestlet(Restlet restlet) {
        // ??
        System.out.println("Restlet removed: " + restlet.getName());
    }
}

