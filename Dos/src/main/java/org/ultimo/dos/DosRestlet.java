package org.ultimo.dos;

import aQute.bnd.annotation.component.Component;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.MediaType;
import org.restlet.representation.AppendableRepresentation;
import org.ultimo.uno.IResourceProvider;
import org.ultimo.uno.IRestletProvider;

import java.io.IOException;

/** @author Frédéric Cabestre */
@Component(provide = IRestletProvider.class)
public class DosRestlet implements IResourceProvider {

    private final Restlet restlet;

    public DosRestlet() {
        this.restlet = new Restlet() {
            public void handle(Request request, Response response) {
                final AppendableRepresentation representation = new AppendableRepresentation("", MediaType.TEXT_HTML);
                try {
                    representation.append("<html>");
                    representation.append("<head>");
                    representation.append("</head>");
                    representation.append("<body>");
                    representation.append("<a href=\"/uno\">Uno Restlet</a>");
                    representation.append("</body>");
                    representation.append("</html>");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                response.setEntity(representation);
            }
        };
    }

    @Override
    public String getPathTemplate() {
        return "/dos";
    }

    @Override
    public Restlet getResource() {
        return this.restlet;
    }
}

