package org.ultimo.uno;

import aQute.bnd.annotation.component.ConfigurationPolicy;
import aQute.bnd.annotation.component.Reference;
import org.restlet.*;
import org.restlet.data.Protocol;

/** @author Frédéric Cabestre */
@aQute.bnd.annotation.component.Component(configurationPolicy = ConfigurationPolicy.optional)
public class UnoComponent extends Component {

    public UnoComponent() {
        System.out.println("Adding protocols");
        this.getServers().add(Protocol.HTTP, 8558);
//        this.getClients().add(Protocol.FILE);
        this.getClients().add(Protocol.CLAP);
    }

    @Reference(service = Uniform.class, dynamic = true, multiple = true, optional = false)
    public void addApplication(Uniform uniform) {
        if (uniform instanceof Application) {
            final Application application = (Application) uniform;
            System.out.println("Application added: " + application.getName());
            application.setContext(this.getContext().createChildContext());
            this.getDefaultHost().attach(application);
        }
    }

    public void removeApplication(Uniform uniform) {
        if (uniform instanceof Application) {
            final Application application = (Application) uniform;
            System.out.println("Application removed: " + application.getName());
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

