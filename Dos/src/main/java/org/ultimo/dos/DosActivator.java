package org.ultimo.dos;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/** @author Frédéric Cabestre */
public class DosActivator  implements BundleActivator {

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Bundle <" + this.getClass().getName() + "> started");
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Bundle <" + this.getClass().getName() + "> stopped");
    }
}

