# Java Card Games

Welcome to Java card games, a paired programming project that utilizes shared classes and the four pillars of OOP to create two separate card games, High-Low and Snap.

## Table of Contents
- [How to Play](#how-to-play)
- [Structure](#structure)
- [Snap Features](#snap-features)
- [High Low Features](#high-low-features)
- [OOP Principles](#oop-principles)

## How to Play
1. Clone or download the repository.

2. Open the project in a Java Development environment such as IntelliJ.

3. Run the main class to start the game interface, from which you will be able to select your game of choice, either High-Low or Snap.

4. Depending on which game you choose, the relevant rules will be displayed on the screen for you to follow.

## Structure

This project implements some classes developed using paired programming and then separate classes to deliver the unique gameplay mechanics for the two games selected. Shared classes that were developed are present within the `org.card.game` package:

### `org.card.game` Package

This package contains the core classes for running the two games.

- **`Card`**: This class defines the 52 cards within a playing card deck. It includes a constructor with the suit, symbol, and value with a switch statement to assign the value based on the symbol.

- **`Deck`**: This class defines the basic functionality of card games with methods that include dealing cards, sorting the deck, shuffling the deck, and resetting the deck, among others.

- **`Game`**: An abstract class that provides a template for the games with methods to print the game title and rules, play the game, and check if the player wants to play again.

- **`UserInteractions`**: This class handles user interactions, displaying the initial menu and capturing user input to start the selected game.

### Snap Features

- A Snap Game Menu explains the rules and how it works.
- Players alternate turns drawing cards.
- If two consecutive cards match in value, players race to respond:
  - Player One presses 'q' to snap.
  - Player Two presses 'p' to snap.
- Points are awarded for correct snaps.
- The game can be stopped at any time by typing 'STOP'.
- At the end of the game, scores are displayed, and players are given the option to play again or return to the menu.

### High Low Features

- A High Low Game Menu explains the rules and how it works.
- To start or close the game, the user will type a certain word/number.
- The game can end at any point when the user types a certain word/number.
- The user has to guess whether the next card will be higher or lower than the card shown.
- There are difficulties ranging from easy to hard. Each difficulty is catered with certain settings, e.g., easy mode has 8 lives.
- Every time a card is guessed correctly, the score increases by 1.
- The scoreboard is updated every time the user gets a new high score and is stored within a text file.
- The scoreboard shows the high score and current score the user gets.

## OOP Principles

### Abstraction

Abstraction is achieved through the use of abstract classes and methods. For instance, the `Game` class provides a template for both Snap and High-Low games. This class has abstract methods like `play()` and `playAgain()` which are implemented by the specific game classes.

### Encapsulation

Encapsulation is used to protect the state of objects. For example, the `Card` and `Player` classes have private fields that can only be accessed or modified through public getter and setter methods. This ensures that the internal state of an object can only be changed in controlled ways.

### Inheritance

Inheritance allows for the reuse of common logic across different game types. The `SnapPlay` and `HighLowMenu` classes both extend from the `Game` class, inheriting common behaviors such as printing game titles and rules, and implementing specific game logic in their `play()` methods.

### Polymorphism

Polymorphism is demonstrated through the use of the abstract `Game` class and its method implementations. Both Snap and High-Low games provide their specific implementations of the `play()` method. This allows for the same interface to be used to start the game, while the specific behaviors are defined in the subclasses.
