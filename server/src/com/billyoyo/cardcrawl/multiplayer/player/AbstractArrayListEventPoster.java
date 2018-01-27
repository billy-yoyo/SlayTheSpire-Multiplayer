package com.billyoyo.cardcrawl.multiplayer.player;

import com.megacrit.cardcrawl.relics.AbstractRelic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * Created by william on 27/01/2018.
 */
public abstract class AbstractArrayListEventPoster<T> extends ArrayList<T> {

    public abstract void onAdd(T obj);
    public void onAddAll(Iterable<?> objs) {
        for (Object obj : objs) {
            try {
                onAdd((T) obj);
            } catch (Exception e) {
                // throw away invalid objects
            }
        }
    }

    public abstract void onRemove(T obj);
    public void onRemoveAll(Iterable<?> objs) {
        for (Object obj : objs) {
            try {
                onAdd((T) obj);
            } catch (Exception e) {
                // throw away invalid objects
            }
        }
    }

    public abstract void onClear();
    public abstract void onUpdate();

    @Override
    public boolean add(T obj) {
        boolean result = super.add(obj);

        if (result) {
            onAdd(obj);
        }

        return result;
    }

    @Override
    public void add(int index, T obj) {
        super.add(index, obj);

        // the ordering of the objects is not really important, at least not for now
        onAdd(obj);
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        // original implementation makes no calls to add, so we can be sure
        // of no duplication of events
        boolean result = super.addAll(collection);

        onAddAll(collection);

        return result;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> collection) {
        // original implementation makes no calls to add, so we can be sure
        // of no duplication of events
        boolean result = super.addAll(index, collection);

        // the ordering of the objects is not really important, at least not for now
        onAddAll(collection);

        return result;
    }

    @Override
    public void clear() {
        super.clear();

        onClear();
    }

    @Override
    public T remove(int index) {
        T obj = super.remove(index);

        if (obj != null) {
            onRemove(obj);
        }

        return obj;
    }

    @Override
    public boolean remove(Object object) {
        boolean result = super.remove(object);

        if (result && object instanceof AbstractRelic) {
            onRemove((T) object);
        }

        return result;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean result = super.removeAll(collection);

        if (result) {
            onRemoveAll(collection);
        }

        return result;
    }

    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        Objects.requireNonNull(filter);

        List<T> removed = new ArrayList<>();

        for (T obj : this) {
            if (filter.test(obj)) {
                removed.add(obj);
            }
        }

        boolean result = super.removeIf(filter);

        if (result) {
            onRemoveAll(removed);
        }

        return result;
    }

    @Override
    public void removeRange(int fromIndex, int toIndex) {
        List<T> removed = new ArrayList<>();

        for (int i = fromIndex; i < toIndex; i++) {
            removed.add(get(i));
        }

        super.removeRange(fromIndex, toIndex);

        onRemoveAll(removed);
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {
        super.replaceAll(operator);

        onUpdate();
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        Objects.requireNonNull(collection);

        List<T> removed = new ArrayList<>();

        for (T obj : this) {
            if (!collection.contains(obj)) {
                removed.add(obj);
            }
        }

        boolean result = super.retainAll(collection);

        onRemoveAll(removed);

        return result;
    }

    @Override
    public T set(int index, T newObj) {
        T oldObj = super.set(index, newObj);

        onRemove(oldObj);
        onAdd(newObj);

        return oldObj;
    }

}
