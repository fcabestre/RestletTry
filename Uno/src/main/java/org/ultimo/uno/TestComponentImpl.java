package org.ultimo.uno;


import aQute.bnd.annotation.component.Component;

/** @author Frédéric Cabestre */
@Component(provide = TestComponent.class)
public class TestComponentImpl implements TestComponent {

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}

