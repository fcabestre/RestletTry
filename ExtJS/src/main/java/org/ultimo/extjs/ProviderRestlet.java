package org.ultimo.extjs;

import aQute.bnd.annotation.component.Component;
import org.restlet.Context;
import org.restlet.Uniform;
import org.restlet.resource.Directory;
import org.ultimo.uno.MyRestlet;

import java.net.URL;

/** @author Frédéric Cabestre */
@Component(provide = Uniform.class)
public class ProviderRestlet  extends Directory implements MyRestlet {

    private static final URL ROOT_URL = ProviderRestlet.class.getResource("extjs");

    public ProviderRestlet(Context context) {
        super(context, ROOT_URL.toString());
    }

    @Override
    public String getPathTemplate() {
        return "/extjs";
    }
}

