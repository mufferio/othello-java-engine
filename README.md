# Othello Java Engine

A Java implementation of the classic **Othello (Reversi)** game, built as a course assignment to model game rules, validate move logic, and compare player strategies.

## Project Purpose

This repository demonstrates how to:

- implement a turn-based board game engine in an object-oriented design,
- separate game state, player behavior, and game orchestration,
- validate correctness with unit tests,
- experiment with AI-style strategies (random and greedy) through simulation.

In short, this project was coded to combine **software design**, **algorithmic reasoning**, and **basic empirical strategy analysis** in one practical Java codebase.

## What It Does

The engine supports:

- Full 8x8 Othello gameplay rules (legal moves, token flipping, win detection).
- Human vs Human play in the console.
- Human vs Random strategy play.
- Human vs Greedy strategy play.
- Random vs Random and Random vs Greedy automated simulations over many games.

Core capabilities include:

- board initialization with the standard Othello starting position,
- move validation in all 8 directions,
- token flipping mechanics,
- turn management (including pass/skip behavior when only one player has a move),
- game-over and winner computation.

## Why It Was Coded

This project appears to be an academic assignment from the University of Toronto (`ca.utoronto.utm.assignment1.othello` package structure), designed to teach:

- clean decomposition of game logic into classes,
- test-driven validation of game behavior,
- strategy implementation and comparison,
- simple statistical thinking through repeated simulation experiments.

The included `randomVsRandomReport.txt` also reflects the assignment’s analysis component.

## Architecture Overview

### Core Model

- **`Othello`**: game-level model (turn tracking, move execution, winner/game-over checks).
- **`OthelloBoard`**: board state + low-level rule logic (valid coordinates, alternation, flipping, counts).
- **`Move`**: value object representing `(row, col)`.

### Player Strategies

- **`PlayerHuman`**: reads row/column input from console.
- **`PlayerRandom`**: chooses randomly from valid moves.
- **`PlayerGreedy`**: chooses move with maximum immediate flips.

### Controllers / Entry Points

- **`OthelloControllerHumanVSHuman`**
- **`OthelloControllerHumanVSRandom`**
- **`OthelloControllerHumanVSGreedy`**
- **`OthelloControllerRandomVSRandom`**
- **`OthelloControllerRandomVSGreedy`**

Each controller wires the model and player types, then runs a complete match loop.

## Tech Stack

- **Language:** Java
- **Build Tool:** Maven (`pom.xml`)
- **Testing:** JUnit 5

## Getting Started

### Prerequisites

- JDK matching the Maven target in `pom.xml` (currently Java 22).
- Maven 3.8+.

### Build and Test

```bash
mvn test
```

### Run Game Modes

Run any controller `main` method from your IDE, or via Maven/Java CLI after compilation.  
Primary classes are under:

`src/main/java/ca/utoronto/utm/assignment1/othello/`

## Testing

Unit tests are located in:

- `src/test/java/ca/utoronto/utm/assignment1/othello/OthelloBoardTest.java`
- `src/test/java/ca/utoronto/utm/assignment1/othello/OthelloTest.java`
- `src/test/java/ca/utoronto/utm/assignment1/othello/MoveTest.java`

They cover core rule behavior, board state transitions, and basic model correctness.

## Repository Structure

```text
othello-java-engine/
├── pom.xml
└── src
    ├── main/java/ca/utoronto/utm/assignment1/othello
    │   ├── Othello.java
    │   ├── OthelloBoard.java
    │   ├── Move.java
    │   ├── PlayerHuman.java
    │   ├── PlayerRandom.java
    │   ├── PlayerGreedy.java
    │   └── OthelloController*.java
    └── test/java/ca/utoronto/utm/assignment1/othello
        ├── OthelloBoardTest.java
        ├── OthelloTest.java
        └── MoveTest.java
```

## Notes

- This is an educational codebase focused on clarity and assignment objectives.
- Strategy players currently use short-horizon logic (random/greedy), making the project a good base for future minimax or Monte Carlo extensions.
