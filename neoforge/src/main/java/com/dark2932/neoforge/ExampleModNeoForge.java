package com.dark2932.neoforge;

import net.neoforged.fml.common.Mod;

import com.dark2932.ExampleMod;

@Mod(ExampleMod.MOD_ID)
public final class ExampleModNeoForge {
    public ExampleModNeoForge() {
        // Run our common setup.
        ExampleMod.init();
    }
}
