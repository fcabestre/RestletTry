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
@Component(provide = Uniform.class, configurationPolicy = ConfigurationPolicy.optional)
public class UnoApplication extends Application {

    private Router router;

    public UnoApplication() {
    }

    @Override
    public Restlet createInboundRoot() {
        this.router = new Router(this.getContext());
        return this.router;
    }

    @Reference(service = Uniform.class, dynamic = false, multiple = true, optional = true)
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

    public void activate() {
        try {
            this.start();
            System.out.println("Component <" + this.getName() + "> activated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deactivate() {
        try {
            this.stop();
            System.out.println("Component <" + this.getName() + "> deactivated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

