package org.ultimo.uno;

import org.restlet.Context;
import org.restlet.resource.Directory;

/** @author Frédéric Cabestre */
public interface IDirectoryProvider extends IRestletProvider {

    void initDirectory(Context context);
}
