package com.kubiczek.rashambo.player;

/**
 * Created by mkubiczek on 10/8/2016.
 */
public class RockPlayer extends AbstractPlayer {
    protected RockPlayer(String name) {
        super(name);
    }

    @Override
    public Handsing play() {
        return Handsing.ROCK;
    }
}
