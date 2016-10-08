package com.kubiczek.rashambo.player;

/**
 * Created by mkubiczek on 10/8/2016.
 */
public enum Handsing {
    ROCK, PAPER, SCISSORS;

    public boolean beat(Handsing other) {
        return (this == ROCK && other == SCISSORS) ||
                (this == PAPER && other == ROCK) ||
                (this == SCISSORS && other == PAPER);
    }
}
