package com.billyoyo.cardcrawl.multiplayer.dto;

import com.billyoyo.cardcrawl.multiplayer.helpers.PowerLibrary;
import com.megacrit.cardcrawl.powers.*;

/**
 * Created by william on 27/01/2018.
 */
public class AbstractPowerDTO implements DTO<AbstractPower> {

    public static boolean matches(AbstractPower power1, AbstractPower power2) {
        return new AbstractPowerDTO(power1).equals(new AbstractPowerDTO(power2));
    }

    private final String id;
    private final int amount;
    private final int hpLoss;
    private final AbstractCardDTO card;

    public AbstractPowerDTO(String id, int amount, int hpLoss, AbstractCardDTO card) {
        this.id = id;
        this.amount = amount;
        this.hpLoss = hpLoss;
        this.card = null;
    }

    public AbstractPowerDTO(String id, int amount, int hpLoss) {
        this(id, amount, hpLoss, null);
    }

    public AbstractPowerDTO(String id, int amount, AbstractPowerDTO card) {
        this(id, amount, 0, null);
    }

    public AbstractPowerDTO(String id, int amount) {
        this(id, amount, 0, null);
    }

    public AbstractPowerDTO(String id) {
        this(id, 0, 0, null);
    }

    public AbstractPowerDTO(AbstractPower power) {
        int hpLoss = 0;
        if (power instanceof CombustPower) {
            hpLoss = ((CombustPower) power).getHpLoss();
        }
        if (power instanceof RegenerationPower) {
            hpLoss = ((RegenerationPower) power).getHealAmount();
        }

        AbstractCardDTO card = null;
        if (power instanceof NightmarePower) {
            card = new AbstractCardDTO(((NightmarePower) power).getCard());
        }
        if (power instanceof StasisPower) {
            card = new AbstractCardDTO(((StasisPower) power).getCard());
        }

        int amount = power.amount;
        if (power instanceof PanachePower) {
            amount = ((PanachePower) power).getDamage();
        }

        this.id = power.ID;
        this.amount = amount;
        this.hpLoss = hpLoss;
        this.card = card;
    }

    public String getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public int getHpLoss() {
        return hpLoss;
    }

    public AbstractCardDTO getCard() {
        return card;
    }

    @Override
    public boolean matches(AbstractPower obj) {
        return new AbstractPowerDTO(obj).equals(this);
    }

    @Override
    public AbstractPower create(CreateData data) {
        return PowerLibrary.create(this, data);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof AbstractPowerDTO && equals((AbstractPowerDTO) obj);
    }

    private boolean equals(AbstractPowerDTO dto) {
        return dto.getId().equals(getId())
                && dto.getAmount() == getAmount()
                && dto.getHpLoss() == getHpLoss()
                && ((dto.getCard() == null && getCard() == null) || dto.getCard().equals(getCard()));
    }

    @Override
    public String toString() {
        String card = getCard() == null ? "null" : getCard().toString();

        return "AbstractPowerDTO[id=" + getId() + ", amount=" + getAmount()
                + ", hploss=" + getHpLoss() + ", card=" + card + "]";
    }
}
