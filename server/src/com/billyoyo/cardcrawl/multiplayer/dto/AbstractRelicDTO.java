package com.billyoyo.cardcrawl.multiplayer.dto;

import com.megacrit.cardcrawl.helpers.RelicLibrary;
import com.megacrit.cardcrawl.relics.AbstractRelic;

/**
 * Created by william on 27/01/2018.
 */
public class AbstractRelicDTO implements DTO<AbstractRelic> {

    private String id;

    public AbstractRelicDTO(String id) {
        this.id = id;
    }

    public AbstractRelicDTO(AbstractRelic relic) {
        this(relic.relicId);
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean matches(AbstractRelic relic) {
        return relic.relicId.equals(id);
    }

    @Override
    public AbstractRelic create() {
        AbstractRelic relic = RelicLibrary.getRelic(id);
        if (relic != null) {
            relic = relic.makeCopy();
        }
        return relic;
    }
}
