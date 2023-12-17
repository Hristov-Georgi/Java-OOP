package SOLID.logger.factories;

import SOLID.logger.interfaces.Factory;
import SOLID.logger.interfaces.Layout;
import SOLID.logger.layouts.SimpleLayout;
import SOLID.logger.layouts.XmlLayout;

public class LayoutFactory implements Factory<Layout> {

    @Override
    public Layout produce(String inputData) {
        Layout layout = null;

        if (inputData.equals("SimpleLayout")) {
            layout = new SimpleLayout();
        } else if (inputData.equals("XmlLayout")) {
            layout = new XmlLayout();
        }

        return layout;
    }


}
