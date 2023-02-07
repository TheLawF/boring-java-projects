package com.github.thelawf.railLTD;

import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;
import org.lwjgl.system.MemoryUtil;

import java.awt.*;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL.createCapabilities;
import static org.lwjgl.opengl.GL11.*;

public class RailLTDWindow {
    private int width;
    private int height;
    private String title;
    private long glfwWindow;
    private static RailLTDWindow window;

    private RailLTDWindow(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    private RailLTDWindow() {
        this.width = 1920;
        this.height = 1080;
        this.title = "Rail LTD";
    }

    public static RailLTDWindow getInstance() {
        if (RailLTDWindow.window == null) {
            RailLTDWindow.window = new RailLTDWindow();
        }
        return RailLTDWindow.window;
    }

    public static RailLTDWindow getInstance(int width, int height, String title) {
        if (RailLTDWindow.window == null) {
            RailLTDWindow.window = new RailLTDWindow(width, height, title);
        }
        return RailLTDWindow.window;
    }

    public void run() {
        init();
        update();
    }

    public void init() {
        GLFWErrorCallback.createPrint(System.err).set();
        if (!GLFW.glfwInit()) {
            throw new IllegalStateException("Unable to init GLFW");
        }

        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        glfwWindowHint(GLFW_MAXIMIZED, GLFW_TRUE);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 2);
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
        glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL_TRUE);

        glfwWindow = GLFW.glfwCreateWindow(this.width, this.height, this.title, MemoryUtil.NULL, MemoryUtil.NULL);
        if (glfwWindow == MemoryUtil.NULL) {
            throw new IllegalStateException("Fail to create Window");
        }

        glfwMakeContextCurrent(glfwWindow);
        glfwSwapInterval(1);
        glfwShowWindow(glfwWindow);
        createCapabilities();

    }

    public void update() {
        while (!GLFW.glfwWindowShouldClose(glfwWindow)) {
            glfwPollEvents();
            glClearColor(0.9f, 0.9f, 0.9f,1.0f);
            glClear(GL11.GL_COLOR_BUFFER_BIT);
            // glDrawElements(GL_QUADS);
            glfwSwapBuffers(glfwWindow);
        }
    }

    public void render() {
    }
}
