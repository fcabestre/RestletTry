package org.ultimo.uno;

import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.ConfigurationPolicy;
import aQute.bnd.annotation.component.Reference;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.Uniform;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

/** @author Frédéric Cabestre */
@Component(provide = Uniform.class/*, configurationPolicy = ConfigurationPolicy.optional*/)
public class UnoApplication extends Application {

    private Router router = new Router();

    public UnoApplication() {
    }

    @Override
    public Restlet createInboundRoot() {
        this.router.setContext(this.getContext());
        return this.router;
    }

    @Reference(service = Uniform.class, dynamic = true, multiple = true, optional = true)
    public void addRestlet(Uniform uniform) {
        if (uniform instanceof MyRestlet) {
            final Restlet restlet = (Restlet) uniform;
            System.out.println("Restlet added: " + restlet.getName());
            final MyRestlet myRestlet = (MyRestlet) uniform;
            this.router.attach(myRestlet.getPathTemplate(), restlet);
        }
    }

    public void removeRestlet(Uniform uniform) {
        if (uniform instanceof MyRestlet) {
            final Restlet restlet = (Restlet) uniform;
            System.out.println("Restlet removed: " + restlet.getName());
            this.router.detach(restlet);
        }
    }
}

