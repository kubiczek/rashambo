package com.kubiczek.rashambo.player;

import java.util.Random;

/**
 * Created by mkubiczek on 10/8/2016.
 */
public class RandomPlayer extends AbstractPlayer {
    private static final Random random = new Random();

    public RandomPlayer(String name) {
        super(name);
    }

    @Override
    public Handsing play() {
        Handsing[] handsigns = Handsing.values();
        return handsigns[random.nextInt(handsigns.length)];
    }
}
