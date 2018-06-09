	The ocean map is represented by a 10 by 10 grid of different characters. The grid is managed by a two-dimensional array. This 2D array is used to save where the user and 
computer decide to place their ships, as well as when someone tries to attack a location and misses. At the start of the game the array will be empty and as the game is played you 
will change what is stored at each index of the array accordingly.

**** Welcome to the Battle Ships game ****
****** Right now the seas are empty ******
   0123456789   
0 |          | 0
1 |          | 1
2 |          | 2
3 |          | 3
4 |          | 4
5 |          | 5
6 |          | 6
7 |          | 7
8 |          | 8
9 |          | 9
   0123456789   
 
	The player should deploy 5 ships. A ship will be stored in a single index of the array as a special character.
You can NOT place two or more ships on the same location.
You can’t place ships outside the 10 by 10 grid.
If the player is trying to put the ship somewhere it can't be, program will re-prompt them until they choose legal coordinates for the ship.
Once the user is finished placing a ship map will be print out.

All ships have now been placed. Here is your updated map:
   0123456789   
0 |          | 0
1 |  @ @     | 1
2 |          | 2
3 |    @     | 3
4 |          | 4
5 |      @   | 5
6 |          | 6
7 |        @ | 7
8 |          | 8
9 |          | 9
   0123456789   
 
	The computer will deploy 5 ships by randomly picking X and Y coordinates. This code is responsible for generating these locations, checking if they are valid,
and if so placing the ships accordingly.
-Ship cannot be placed on a location that is already taken by another ship (player’s or computer’s).
-Ship can’t be placed outside the 10 by 10 grid.
If the computer tries to place the ship somewhere it can't be, program will regenerate random coordinates until all ships are placed appropriately.
Computer's ships are invisible on the ocean map.

	During the battle, the player and computer will take turns guessing X and Y coordinates of the opponent’s ships. Every coordinate guessed is marked 
so they players know not to guess there again.
When the player enters X and Y coordinates game check if those coordinates are valid within the Ocean Map and haven't been guessed by the user yet.
 
There are three possible results of a valid guess:
-Player correctly guessed coordinates of computer’s ship (computer loses ship).
-Player entered coordinates of his/her own ship (player loses ship).
-Player missed. No ship on the entered coordinates.

	After the player guesses a coordinate it's the computer's turn to guess. The computer's attack should be two randomly generated coordinates. 
When the computer produces a valid guess there are three possible outcomes:
-Computer guessed coordinates of the player’s ship (player loses ship).
-Computer guessed coordinates of its own ship (computer loses ship).
-Computer missed. No ship on guessed coordinates.

This is how the screen will look after couple turns
- - miss
@ - your ship
! - your destroyed ship
X - computer`s destroyed ship

   0123456789   
0 |       -  | 0
1 |  @ ! -   | 1
2 |   -  -   | 2
3 |--  @     | 3
4 |     -x-  | 4
5 |-    -@   | 5
6 |   ---   -| 6
7 |   -    @ | 7
8 |  --    - | 8
9 |     -   -| 9
   0123456789   

Your ships: 4 | Computer ships 4
 
The battle will continue to run until one of the players is out of ships.

When the user and computer are done guessing, will be displayed the current state of the ocean map and score.
 
The game is over when one player or computer has no ship left.
 
