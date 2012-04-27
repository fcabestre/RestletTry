package org.ultimo.uno;

import org.restlet.Restlet;

/** @author Frédéric Cabestre */
public interface IRestletProvider {

    String getPathTemplate();

    Restlet getResource();
}

