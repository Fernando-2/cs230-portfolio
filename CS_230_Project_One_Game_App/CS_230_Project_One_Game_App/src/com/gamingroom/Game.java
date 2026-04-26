package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a game.
 */
public class Game extends Entity {
    private final List<Team> teams = new ArrayList<Team>();

    /**
     * Constructor with an identifier and name.
     *
     * @param id unique identifier
     * @param name game name
     */
    public Game(long id, String name) {
        super(id, name);
    }

    /**
     * Adds a team if a team with the same name does not already exist.
     *
     * @param id unique team identifier
     * @param name unique team name
     * @return new or existing team
     */
    public Team addTeam(long id, String name) {
        Team team = getTeam(name);

        if (team == null) {
            team = new Team(id, name);
            teams.add(team);
        }

        return team;
    }

    /**
     * Returns the team at the specified index.
     *
     * @param index index position in the list
     * @return requested team
     */
    Team getTeam(int index) {
        return teams.get(index);
    }

    /**
     * Returns the team with the specified id.
     *
     * @param id unique team identifier
     * @return requested team or null
     */
    public Team getTeam(long id) {
        Team team = null;
        Iterator<Team> iterator = teams.iterator();

        while (iterator.hasNext()) {
            Team nextTeam = iterator.next();
            if (nextTeam.getId() == id) {
                team = nextTeam;
                break;
            }
        }

        return team;
    }

    /**
     * Returns the team with the specified name.
     *
     * @param name unique team name
     * @return requested team or null
     */
    public Team getTeam(String name) {
        Team team = null;
        Iterator<Team> iterator = teams.iterator();

        while (iterator.hasNext()) {
            Team nextTeam = iterator.next();
            if (nextTeam.getName().equalsIgnoreCase(name)) {
                team = nextTeam;
                break;
            }
        }

        return team;
    }

    /**
     * @return number of teams assigned to the game
     */
    public int getTeamCount() {
        return teams.size();
    }

    @Override
    public String toString() {
        return "Game [id=" + getId() + ", name=" + getName() + ", teamCount=" + getTeamCount() + "]";
    }
}
