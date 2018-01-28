package com.billyoyo.cardcrawl.multiplayer.dto;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.helpers.RelicLibrary;
import com.megacrit.cardcrawl.relics.AbstractRelic;

/**
 * Created by william on 27/01/2018.
 */
public class AbstractRelicDTO implements DTO<AbstractRelic> {

    private final String id;
    private final int counter;

    public AbstractRelicDTO(String id, int counter) {
        this.id = id;
        this.counter = counter;
    }

    public AbstractRelicDTO(AbstractRelic relic) {
        this(relic.relicId, relic.counter);
    }

    public String getId() {
        return id;
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public boolean matches(AbstractRelic relic) {
        return relic.relicId.equals(id);
    }

    @Override
    public AbstractRelic create(CreateData data) {
        AbstractRelic relic = RelicLibrary.getRelic(id);
        if (relic != null) {
            relic = relic.makeCopy();
            relic.counter = counter;
        }
        return relic;
    }
}
