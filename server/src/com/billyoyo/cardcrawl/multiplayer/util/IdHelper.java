package com.billyoyo.cardcrawl.multiplayer.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by william on 30/01/2018.
 */
public class IdHelper {

    private static final String ALPHANUMERIC = "abcdefghijklmnopqrstuvwxyABCDEFGHIJKLMNOPQRSTUVWXY0123456789";
    private static final int UNIQUE_ID_LENGTH = 32;
    private static final List<String> uniqueIds = new ArrayList<>();

    private static String generateId() {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < UNIQUE_ID_LENGTH; i++) {
            builder.append(ALPHANUMERIC.charAt(random.nextInt(ALPHANUMERIC.length())));
        }

        return builder.toString();
    }

    public static String generateUniqueId() {
        synchronized (uniqueIds) {
            String id = generateId();
            int retries = 0;

            while (uniqueIds.contains(id) && retries < 100) {
                id = generateId();
            }

            if (retries >= 100) {
                throw new RuntimeException("failed to generate unique id");
            }

            return id;
        }
    }

}
