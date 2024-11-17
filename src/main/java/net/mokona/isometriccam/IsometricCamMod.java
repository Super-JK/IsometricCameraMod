package net.mokona.isometriccam;

import net.mokona.isometriccam.events.IsometricViewHandler;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;

@Mod(IsometricCamMod.MOD_ID)
public class IsometricCamMod
{
    public static final String MOD_ID = "isometriccam";

    public IsometricCamMod()
    {
        IsometricViewHandler isometricViewHandler = new IsometricViewHandler();
        NeoForge.EVENT_BUS.register(isometricViewHandler);
    }
}
