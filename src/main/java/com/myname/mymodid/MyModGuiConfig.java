package com.myname.mymodid;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;

// The in-game config screen. Every option in Config.configuration shows up here automatically:
// options in the "general" category are listed directly, any other top-level category gets its own sub-screen.
public class MyModGuiConfig extends GuiConfig {

    public MyModGuiConfig(GuiScreen parentScreen) {
        super(
            parentScreen,
            getConfigElements(),
            MyMod.MODID,
            false,
            false,
            GuiConfig.getAbridgedConfigPath(Config.configuration.toString()));
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static List<IConfigElement> getConfigElements() {
        List<IConfigElement> elements = new ArrayList<>();
        Configuration configuration = Config.configuration;

        for (String name : configuration.getCategoryNames()) {
            ConfigCategory category = configuration.getCategory(name);
            if (category.isChild()) {
                continue;
            }
            if (Configuration.CATEGORY_GENERAL.equals(name)) {
                elements.addAll(new ConfigElement(category).getChildElements());
            } else {
                elements.add(new ConfigElement(category));
            }
        }
        return elements;
    }
}
