package org.ultimo.uno;

import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.MediaType;

/** @author Frédéric Cabestre */
public class UnoRestlet extends Restlet {

    @Override
    public void handle(Request request, Response response) {
        response.setEntity("Hello world!", MediaType.TEXT_PLAIN);
    }
}

