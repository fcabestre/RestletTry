package org.ultimo.uno;

import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.ConfigurationPolicy;
import aQute.bnd.annotation.component.Reference;
import org.restlet.Restlet;
import org.restlet.Server;
import org.restlet.Uniform;
import org.restlet.data.Protocol;

/** @author Frédéric Cabestre */
@Component
public class UnoServer extends Server {

    public UnoServer() {
        super(Protocol.HTTP, 8554);
    }

    public UnoServer(Protocol protocol, int port) {
        super(protocol, port);
    }

    @Reference(service = Uniform.class, dynamic = true, multiple = true, optional = true)
    public void addRestlet(Uniform uniform) {
        final Restlet restlet = (Restlet) uniform;
        System.out.println("Restlet added: " + restlet.getName());
        this.setNext(restlet);
    }

    public void removeRestlet(Uniform uniform) {
        // ??
        final Restlet restlet = (Restlet) uniform;
        System.out.println("Restlet removed: " + restlet.getName());
    }

    @Reference(service = TestComponent.class, dynamic = true, multiple = false, optional = true)
    public void addTestComponent(TestComponent component) {
        System.out.println("Component <" + component.toString() + "> Installed");
    }

    public void removeTestComponent(TestComponent component) {
        System.out.println("Component <" + component.toString() + "> Removed");
    }

    public void activate() {
        try {
            this.start();
            System.out.println("Component <" + this.getClass().getName() + "> activated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deactivate() {
        try {
            this.stop();
            System.out.println("Component <" + this.getClass().getName() + "> deactivated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

