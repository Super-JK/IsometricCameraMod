package net.mokona.isometriccam.utils;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.mokona.isometriccam.IsometricCamMod;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.fml.common.EventBusSubscriber;
import org.lwjgl.glfw.GLFW;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = IsometricCamMod.MOD_ID, value = Dist.CLIENT)
public class KeyBinding {
    @SubscribeEvent
    public static void registerBindings(RegisterKeyMappingsEvent event) {
        event.register(KeyBinding.ENABLE_ISO_KEY.get());
        event.register(KeyBinding.ZOOM_IN_KEY.get());
        event.register(KeyBinding.ZOOM_OUT_KEY.get());
        event.register(KeyBinding.VERTICAL_ROTATION_UP_KEY.get());
        event.register(KeyBinding.VERTICAL_ROTATION_DOWN_KEY.get());
        event.register(KeyBinding.HORIZONTAL_ROTATION_LEFT_KEY.get());
        event.register(KeyBinding.HORIZONTAL_ROTATION_RIGHT_KEY.get());
    }

    public static final String KEY_CATEGORY_ISOMETRIC = "key.category.isometriccam";

    public static final String KEY_ENABLE_ISO = "key.isometriccam.enable_iso";
    public static final Lazy<KeyMapping> ENABLE_ISO_KEY = Lazy.of(() -> new KeyMapping(
            KEY_ENABLE_ISO,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_F10,
            KEY_CATEGORY_ISOMETRIC));

    public static final String KEY_ZOOM_IN = "key.isometriccam.zoom_in";
    public static final Lazy<KeyMapping> ZOOM_IN_KEY = Lazy.of(() -> new KeyMapping(
            KEY_ZOOM_IN,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_KP_9,
            KEY_CATEGORY_ISOMETRIC));

    public static final String KEY_ZOOM_OUT = "key.isometriccam.zoom_out";
    public static final Lazy<KeyMapping> ZOOM_OUT_KEY = Lazy.of(() -> new KeyMapping(
            KEY_ZOOM_OUT,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_KP_7,
            KEY_CATEGORY_ISOMETRIC));

    public static final String KEY_VERTICAL_ROTATION_UP = "key.isometriccam.vertical_rotation_up";
    public static final Lazy<KeyMapping> VERTICAL_ROTATION_UP_KEY = Lazy.of(() -> new KeyMapping(
            KEY_VERTICAL_ROTATION_UP,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_KP_8,
            KEY_CATEGORY_ISOMETRIC));

    public static final String KEY_VERTICAL_ROTATION_DOWN = "key.isometriccam.vertical_rotation_down";
    public static final Lazy<KeyMapping> VERTICAL_ROTATION_DOWN_KEY = Lazy.of(() -> new KeyMapping(
            KEY_VERTICAL_ROTATION_DOWN,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_KP_2,
            KEY_CATEGORY_ISOMETRIC));

    public static final String KEY_HORIZONTAL_ROTATION_LEFT = "key.isometriccam.horizontal_rotation_left";
    public static final Lazy<KeyMapping> HORIZONTAL_ROTATION_LEFT_KEY = Lazy.of(() -> new KeyMapping(
            KEY_HORIZONTAL_ROTATION_LEFT,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_KP_4,
            KEY_CATEGORY_ISOMETRIC));

    public static final String KEY_HORIZONTAL_ROTATION_RIGHT = "key.isometriccam.horizontal_rotation_right";
    public static final Lazy<KeyMapping> HORIZONTAL_ROTATION_RIGHT_KEY = Lazy.of(() -> new KeyMapping(
            KEY_HORIZONTAL_ROTATION_RIGHT,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_KP_6,
            KEY_CATEGORY_ISOMETRIC));
}
