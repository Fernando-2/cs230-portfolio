# CS 230 Project One Game App

This is the completed Java prototype for The Gaming Room's **Draw It or Lose It** game application.

## Included

- `Entity.java` base class with shared `id` and `name` fields
- `Game.java`, `Team.java`, and `Player.java` classes that inherit shared entity behavior
- `GameService.java` singleton service that manages games, teams, players, and unique IDs
- Iterator-based search logic to prevent duplicate names
- `ProgramDriver.java` test driver
- `SingletonTester.java` singleton behavior test

## Run

Import this folder into Eclipse as an existing Java project, then run:

`com.gamingroom.ProgramDriver`
