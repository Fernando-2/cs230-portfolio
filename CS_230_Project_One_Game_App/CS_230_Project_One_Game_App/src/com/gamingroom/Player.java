package com.gamingroom;

/**
 * A simple class to hold information about a player.
 */
public class Player extends Entity {

    /**
     * Constructor with an identifier and name.
     *
     * @param id unique identifier
     * @param name player name
     */
    public Player(long id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Player [id=" + getId() + ", name=" + getName() + "]";
    }
}
