# Battleship in the OOP way

## The story
Take old time pen&paper classic Battleships to your computer! 
With this version you both boards will be clearly presented 
and you will be able to focus on taking out this pesky 2-field
little bugger. 

## Specification
* Game for 2 players
* Each player can see his board with all information and opponent's board with unhit ships hidden
* Players place the ships themselves before the game
* There are 5 ships to be placed: 
    * Carrier (5 holes)
    * Battleship (4 holes)
    * Cruiser (3 holes)
    * Submarine (3 holes)
    * Destroyer (2 holes)
* Ships can be placed according to the rules:
    * Place each ship in any horizontal or vertical position but not diagonally,
    * Don't place a ship so that any part of it overlaps letters, numbers, the edge of the grid or another ship,
* Players take turns trying to hit opponents ships by guessing coordinates
* After hitting a ship player continues his turn
* Players receive messages about the results of their hits
* Ships that has been sunk are marked as such
* The player that sinks all opponent's ships is immidiately declared a winner
* There is a main menu from which you can start new game, view rules or exit the game
* Game has to handle wrong input in every place


__main__
Starts menu from MenuController class

__square__
Object representing one square of the map

__ship__
Object representing a single ship

__ocean__
Object representing one board (one for each player)

__util__
Class containing utility functions used by other classess

__view__
Class with methods for printing data on screen

__MenuController__
Controller for main menu

__SetupController__
Controller for the process of placing ships. Guides both players through it and returns a list of two oceans

__GameController__
Controller for the game itself, requires two Ocean objects to be created. Ends with presenting who is the winner of the game