package com.billyoyo.cardcrawl.multiplayer.client;

import com.megacrit.cardcrawl.relics.AbstractRelic;

import java.util.List;

/**
 * Created by william on 26/01/2018.
 */
public class ClientHub {

    // supplied by the server
    private List<String> randomRelics;

    public ClientHub() {
    }

    public List<String> getRandomRelics() {
        return randomRelics;
    }
}
