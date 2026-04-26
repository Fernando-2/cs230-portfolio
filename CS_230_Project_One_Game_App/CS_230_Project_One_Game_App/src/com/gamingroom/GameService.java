package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A singleton service for the game engine.
 */
public class GameService {

    /**
     * A list of the active games.
     */
    private static final List<Game> games = new ArrayList<Game>();

    /**
     * Holds the next identifiers.
     */
    private static long nextGameId = 1;
    private static long nextTeamId = 1;
    private static long nextPlayerId = 1;

    /**
     * The one and only instance of the GameService class.
     */
    private static final GameService instance = new GameService();

    /**
     * Private constructor required by the singleton pattern.
     */
    private GameService() {
    }

    /**
     * Returns the single instance of the game service.
     *
     * @return the shared GameService instance
     */
    public static GameService getInstance() {
        return instance;
    }

    /**
     * Constructs a new game instance if the name is unique.
     *
     * @param name the unique name of the game
     * @return the game instance, either new or existing
     */
    public Game addGame(String name) {
        Game game = getGame(name);

        if (game == null) {
            game = new Game(nextGameId++, name);
            games.add(game);
        }

        return game;
    }

    /**
     * Adds a team to a game if the team name is unique for that game.
     *
     * @param game game to add the team to
     * @param name unique team name
     * @return new or existing team
     */
    public Team addTeam(Game game, String name) {
        if (game == null) {
            throw new IllegalArgumentException("Game cannot be null.");
        }

        Team team = game.getTeam(name);

        if (team == null) {
            team = game.addTeam(nextTeamId++, name);
        }

        return team;
    }

    /**
     * Adds a player to a team if the player name is unique for that team.
     *
     * @param team team to add the player to
     * @param name unique player name
     * @return new or existing player
     */
    public Player addPlayer(Team team, String name) {
        if (team == null) {
            throw new IllegalArgumentException("Team cannot be null.");
        }

        Player player = team.getPlayer(name);

        if (player == null) {
            player = team.addPlayer(nextPlayerId++, name);
        }

        return player;
    }

    /**
     * Returns the game instance at the specified index.
     *
     * @param index index position in the list
     * @return requested game instance
     */
    Game getGame(int index) {
        return games.get(index);
    }

    /**
     * Returns the game instance with the specified id.
     *
     * @param id unique identifier of game to search for
     * @return requested game instance or null
     */
    public Game getGame(long id) {
        Game game = null;
        Iterator<Game> iterator = games.iterator();

        while (iterator.hasNext()) {
            Game nextGame = iterator.next();
            if (nextGame.getId() == id) {
                game = nextGame;
                break;
            }
        }

        return game;
    }

    /**
     * Returns the game instance with the specified name.
     *
     * @param name unique name of game to search for
     * @return requested game instance or null
     */
    public Game getGame(String name) {
        Game game = null;
        Iterator<Game> iterator = games.iterator();

        while (iterator.hasNext()) {
            Game nextGame = iterator.next();
            if (nextGame.getName().equalsIgnoreCase(name)) {
                game = nextGame;
                break;
            }
        }

        return game;
    }

    /**
     * @return the number of games currently active
     */
    public int getGameCount() {
        return games.size();
    }
}
