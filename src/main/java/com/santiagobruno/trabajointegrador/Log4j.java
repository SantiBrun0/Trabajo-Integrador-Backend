package com.santiagobruno.trabajointegrador;

import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Log4j {

    private final static String log4jConfigFile = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "log4j2.xml";

    public static void startLogger() throws IOException {
        var source = new ConfigurationSource(new FileInputStream(log4jConfigFile));
        Configurator.initialize(null, source);
    }

}
