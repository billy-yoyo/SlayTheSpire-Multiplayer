package com.billyoyo.cardcrawl.multiplayer.util;

import java.io.IOException;

/**
 * Created by william on 01/02/2018.
 */
public class InputFinishedException extends IOException {

    public InputFinishedException() {
        super();
    }

    public InputFinishedException(String msg) {
        super(msg);
    }
}
