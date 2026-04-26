package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a team.
 */
public class Team extends Entity {
    private final List<Player> players = new ArrayList<Player>();

    /**
     * Constructor with an identifier and name.
     *
     * @param id unique identifier
     * @param name team name
     */
    public Team(long id, String name) {
        super(id, name);
    }

    /**
     * Adds a player if a player with the same name does not already exist.
     *
     * @param id unique player identifier
     * @param name unique player name
     * @return new or existing player
     */
    public Player addPlayer(long id, String name) {
        Player player = getPlayer(name);

        if (player == null) {
            player = new Player(id, name);
            players.add(player);
        }

        return player;
    }

    /**
     * Returns the player at the specified index.
     *
     * @param index index position in the list
     * @return requested player
     */
    Player getPlayer(int index) {
        return players.get(index);
    }

    /**
     * Returns the player with the specified id.
     *
     * @param id unique player identifier
     * @return requested player or null
     */
    public Player getPlayer(long id) {
        Player player = null;
        Iterator<Player> iterator = players.iterator();

        while (iterator.hasNext()) {
            Player nextPlayer = iterator.next();
            if (nextPlayer.getId() == id) {
                player = nextPlayer;
                break;
            }
        }

        return player;
    }

    /**
     * Returns the player with the specified name.
     *
     * @param name unique player name
     * @return requested player or null
     */
    public Player getPlayer(String name) {
        Player player = null;
        Iterator<Player> iterator = players.iterator();

        while (iterator.hasNext()) {
            Player nextPlayer = iterator.next();
            if (nextPlayer.getName().equalsIgnoreCase(name)) {
                player = nextPlayer;
                break;
            }
        }

        return player;
    }

    /**
     * @return number of players assigned to the team
     */
    public int getPlayerCount() {
        return players.size();
    }

    @Override
    public String toString() {
        return "Team [id=" + getId() + ", name=" + getName() + ", playerCount=" + getPlayerCount() + "]";
    }
}
