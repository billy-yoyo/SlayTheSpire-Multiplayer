package com.billyoyo.cardcrawl.multiplayer.dto;

import com.megacrit.cardcrawl.core.AbstractCreature;

/**
 * Created by william on 27/01/2018.
 */
public interface DTO<T> {

    public boolean matches(T obj);

    public T create(CreateData data);
}
