package com.gamingroom;

/**
 * Application start-up program.
 */
public class ProgramDriver {

    /**
     * The one-and-only main() method.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        GameService service = GameService.getInstance();

        System.out.println("\nAbout to test initializing game data...");

        Game game1 = service.addGame("Game #1");
        Game game2 = service.addGame("Game #2");
        Game duplicateGame = service.addGame("Game #1");

        Team team1 = service.addTeam(game1, "Team Alpha");
        Team team2 = service.addTeam(game1, "Team Beta");
        Team duplicateTeam = service.addTeam(game1, "Team Alpha");

        Player player1 = service.addPlayer(team1, "Player One");
        Player player2 = service.addPlayer(team1, "Player Two");
        Player duplicatePlayer = service.addPlayer(team1, "Player One");

        System.out.println(game1);
        System.out.println(game2);
        System.out.println("Duplicate game returns same object: " + (game1 == duplicateGame));
        System.out.println(team1);
        System.out.println(team2);
        System.out.println("Duplicate team returns same object: " + (team1 == duplicateTeam));
        System.out.println(player1);
        System.out.println(player2);
        System.out.println("Duplicate player returns same object: " + (player1 == duplicatePlayer));

        SingletonTester tester = new SingletonTester();
        tester.testSingleton();
    }
}
