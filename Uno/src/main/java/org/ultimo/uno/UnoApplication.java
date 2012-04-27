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

    @Reference(service = IRestletProvider.class, dynamic = true, multiple = true, optional = true)
    public void addRestlet(IRestletProvider provider) {
        if (provider instanceof IDirectoryProvider) {
            ((IDirectoryProvider) provider).initDirectory(this.getContext());
        }
        final String pathTemplate = provider.getPathTemplate();
        final Restlet resource = provider.getResource();
        System.out.println("Restlet added: " + resource);
        this.router.attach(pathTemplate, resource);
    }

    public void removeRestlet(IRestletProvider provider) {
        final Restlet restlet = provider.getResource();
        System.out.println("Restlet removed: " + restlet.getName());
        this.router.detach(restlet);
    }
}

