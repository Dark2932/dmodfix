package com.dark2932.dmodfix.fabric;

import com.dark2932.dmodfix.dmodfix;
import net.fabricmc.api.ModInitializer;

public final class dmodfixFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        dmodfix.init();
    }
}
