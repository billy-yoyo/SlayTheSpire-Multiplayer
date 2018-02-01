package com.billyoyo.cardcrawl.multiplayer.server;

import com.megacrit.cardcrawl.desktop.DesktopLauncher;

/**
 * Created by william on 29/01/2018.
 */
public class EntryPoint {

    private static final boolean IS_SERVER = false;

    public static void main(String[] args) {

        if (IS_SERVER) {
            StaticGameHandler.launchServer();
        } else {
            try {
                DesktopLauncher.main(args);
            } catch (Exception e) {
                System.out.println("failed to launch desktop app");
            }
        }
    }

}
