package com.billyoyo.cardcrawl.multiplayer.dto;

/**
 * Created by william on 27/01/2018.
 */
public interface DTO<T> {

    public boolean matches(T obj);

    public T create();
}
