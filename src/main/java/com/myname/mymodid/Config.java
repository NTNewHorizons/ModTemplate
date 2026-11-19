package com.myname.mymodid;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

    // Kept around so the in-game config screen (see MyModGuiConfig) can edit and save it.
    public static Configuration configuration;

    public static String greeting = "Hello World";

    public static void init(File configFile) {
        configuration = new Configuration(configFile);
        synchronizeConfiguration();
    }

    // Reads every value from the config file into the static fields above. Called on startup and whenever the
    // values are changed through the in-game config screen.
    public static void synchronizeConfiguration() {
        greeting = configuration.getString("greeting", Configuration.CATEGORY_GENERAL, greeting, "How shall I greet?");

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
