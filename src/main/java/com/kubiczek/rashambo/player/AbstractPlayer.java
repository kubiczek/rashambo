package com.kubiczek.rashambo.player;

/**
 * Created by mkubiczek on 10/8/2016.
 */
public abstract class AbstractPlayer implements Player {
    private final String name;

    protected AbstractPlayer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractPlayer that = (AbstractPlayer) o;

        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
