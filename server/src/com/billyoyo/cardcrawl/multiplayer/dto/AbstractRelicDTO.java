package com.billyoyo.cardcrawl.multiplayer.dto;

import com.megacrit.cardcrawl.helpers.RelicLibrary;
import com.megacrit.cardcrawl.relics.AbstractRelic;

/**
 * Created by william on 27/01/2018.
 */
public class AbstractRelicDTO implements DTO<AbstractRelic> {

    public static boolean matches(AbstractRelic relic1, AbstractRelic relic2) {
        return new AbstractRelicDTO(relic1).equals(new AbstractRelicDTO(relic2));
    }

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
        return new AbstractRelicDTO(relic).equals(this);
    }

    @Override
    public AbstractRelic create(CreateData data) {
        AbstractRelic relic = RelicLibrary.getRelic(id);
        if (relic != null) {
            relic = relic.makeCopy();
            relic.counter = counter;
        } else {
            System.out.println("!!! failed to get relic with id " + id);
        }
        return relic;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof AbstractRelicDTO && equals((AbstractRelicDTO) obj);
    }

    private boolean equals(AbstractRelicDTO dto) {
        return dto.getId().equals(getId())
                && dto.getCounter() == getCounter();
    }

    @Override
    public String toString() {
        return "AbstractRelicDTO[id=" + getId() + ", counter=" + getCounter() + "]";
    }

}
