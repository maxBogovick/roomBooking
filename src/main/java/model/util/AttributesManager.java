package model.util;

import java.util.ResourceBundle;

public class AttributesManager {

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("attributes");

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}