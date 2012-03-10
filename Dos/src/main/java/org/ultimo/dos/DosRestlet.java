package org.ultimo.dos;

import aQute.bnd.annotation.component.Component;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.Uniform;
import org.restlet.data.MediaType;
import org.restlet.representation.AppendableRepresentation;
import org.ultimo.uno.MyRestlet;

import java.io.IOException;

/** @author Frédéric Cabestre */
@Component(provide = Uniform.class)
public class DosRestlet extends Restlet implements MyRestlet {

    @Override
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

    @Override
    public String getPathTemplate() {
        return "/dos";
    }
}

