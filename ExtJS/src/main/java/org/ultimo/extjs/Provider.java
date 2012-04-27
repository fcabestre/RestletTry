package org.ultimo.extjs;

import aQute.bnd.annotation.component.Component;
import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.data.Reference;
import org.restlet.resource.Directory;
import org.ultimo.uno.IDirectoryProvider;
import org.ultimo.uno.IRestletProvider;

import java.net.URL;

/** @author Frédéric Cabestre */
@Component(provide = IRestletProvider.class)
public class Provider implements IDirectoryProvider {

    private Directory directory = null;
    private static final URL ROOT_URL = Provider.class.getResource("extjs");

    @Override
    public String getPathTemplate() {
        return "/extjs";
    }

    @Override
    public Restlet getResource() {
        // TODO throw error if initDirectory not called before
        return this.directory;
    }

    @Override
    public void initDirectory(Context context) {
        System.out.println(ROOT_URL);
        if (this.directory == null) {
            this.directory = new Directory(context, new Reference(ROOT_URL));
        }
    }
}

