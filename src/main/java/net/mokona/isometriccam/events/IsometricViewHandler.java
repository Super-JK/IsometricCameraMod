package net.mokona.isometriccam.events;

import net.minecraft.client.Minecraft;
import net.mokona.isometriccam.utils.IsometricProjection;
import net.mokona.isometriccam.utils.KeyBinding;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

public class IsometricViewHandler {
    public static final Minecraft MC = Minecraft.getInstance();
    private static final Logger LOGGER = LogUtils.getLogger();

    private float zoomTarget = IsometricProjection.isometricViewLength;
    private float xRotTarget = IsometricProjection.xRot;
    private float yRotTarget = IsometricProjection.yRot;

    @SubscribeEvent
    public void onKeyInput(InputEvent.Key event) {
        if (KeyBinding.ENABLE_ISO_KEY.get().consumeClick()) {
            IsometricProjection.isometric = !IsometricProjection.isometric;
            LOGGER.info("Iso cam set to {}", IsometricProjection.isometric);

            MC.smartCull = !IsometricProjection.isometric;
        }
        if (IsometricProjection.isometric) {
            if (KeyBinding.VERTICAL_ROTATION_UP_KEY.get().consumeClick()) {
                xRotTarget += 5;
            } else if (KeyBinding.VERTICAL_ROTATION_DOWN_KEY.get().consumeClick()) {
                xRotTarget -= 5;
            } else if (KeyBinding.ZOOM_OUT_KEY.get().consumeClick()) {
                zoom(5);
            } else if (KeyBinding.ZOOM_IN_KEY.get().consumeClick()) {
                zoom(-5);
            } else if (KeyBinding.HORIZONTAL_ROTATION_LEFT_KEY.get().consumeClick()) {
                yRotTarget += 45;
            } else if (KeyBinding.HORIZONTAL_ROTATION_RIGHT_KEY.get().consumeClick()) {
                yRotTarget -= 45;
            }
        }
    }

    @SubscribeEvent
    public void onMouseScrollInput(InputEvent.MouseScrollingEvent event) {
        if (IsometricProjection.isometric) {
            zoom(-event.getScrollDeltaY());
        }
    }

    @SubscribeEvent
    public void onRenderLevelStageEvent(RenderLevelStageEvent event) {
        if (IsometricProjection.isometric) {
            if (Math.abs(IsometricProjection.isometricViewLength - zoomTarget) >= 0.01) {
                IsometricProjection.isometricViewLength = lerp(IsometricProjection.isometricViewLength, zoomTarget,
                        0.015f);
                event.getLevelRenderer().needsUpdate();
            }
            if (Math.abs(IsometricProjection.xRot - xRotTarget) >= 0.01) {
                IsometricProjection.xRot = lerp(IsometricProjection.xRot, xRotTarget, 0.015f);
            }
            if (Math.abs(IsometricProjection.yRot - yRotTarget) >= 0.01) {
                IsometricProjection.yRot = lerp(IsometricProjection.yRot, yRotTarget, 0.015f);
            }

        }
    }

    public static float lerp(float position, float target, float amount) {
        float d = (target - position) * amount;
        return position + d;
    }

    private void zoom(double amount) {
        double v = amount * (Math.pow(zoomTarget, 1.05) / 22);
        if (zoomTarget + v > 0) {
            zoomTarget += v;
        }
    }
}
