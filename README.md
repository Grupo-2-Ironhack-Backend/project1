# RPG BATTLE SIMULATOR

![GitHub last commit](https://img.shields.io/github/last-commit/Grupo-2-Ironhack-Backend/project1)

## Introduction
A RGP battle simulator has been developed where you can create a party of warriors and wizards to fight other parties to determine the winner.

                                                         ____________________
               _______________________-------------------                    `\
             /:--__                                                            \
            || |                                       ________________________/
            | \\__/_________________-------------------                     |
            |                                                               |
             |                       MERCS                                   |
             |                                                               |
             |       "Beware fellow adventurer, as you are about to           |
              |        witness a clash of parties like never before,          |
              |      earth will tear apart, skies will fall,                  |
              |        there might be some pizza too.                         |
              |      Fight two random generated parties or import              |
               |       the one who made it through the end and gained a        |
               |       pace in your heart and in your filesystem."             |
              |                                                               |
              |                                              _________________|_
              |  ___________________-------------------------                   `\
              |/`--_                                                              |
              ||[ ]||                                            ________________/
               \\===/___________________--------------------------"

![alt text](example.jpg "example")

![alt text](example2.jpg "example2")

### How the battle simulator works

* The characters are grouped in parties and the battle will be between 2 parties. 
Before the battle starts, warriors and wizards join both parties.

* The battles are 1 vs 1.

* The battles are by rounds, in each round both combatants will attack at the same time

* When the battle is over the winner returns to the party and the loser is sent to the graveyard.

* When a party lose all their members a winner party is declared.

### Characters

> Int this RPG game there are Wizards and Warriors

* Warriors are strong well armored characters that focus on the strength.
* Every round a warrior will try to do a “Heavy attack”. 
* The damage of a heavy attack is equals to their strength and every hit will decrease their stamina by 5 points. 
* If he can’t make a heavy attack he will do a “Weak attack”. 
* The damage of a weak attack is the half of the strength.
* Every weak attack recovers his stamina by 1.

* Wizards are the masters of the arcane their main attribute is intelligence. 
* Every round a wizard will try to cast a “Fireball”. 
* The damage of a fireball is equals to his intelligence and every fireball decreases their mana by 5 points. 
* If he can’t cast a fireball he will do a “Staff hit”. 
* The damage of a staff hit is equals to 2. 
* Every staff hit recovers his mana by 1.

### How to play

> Just run the code and follow the given instructions. Enjooy!

                                                   ,--,  ,.-.
                    ,                   \,       '-,-`,'-.' | ._
                   /|           \    ,   |\         }  )/  / `-,',
                   [ ,          |\  /|   | |        /  \|  |/`  ,`
                   | |       ,.`  `,` `, | |  _,...(   (      .',
                   \  \  __ ,-` `  ,  , `/ |,'      Y     (   /_L\
                    \  \_\,``,   ` , ,  /  |         )         _,/
                     \  '  `  ,_ _`_,-,<._.<        /         /
                      ', `>.,`  `  `   ,., |_      |         /
                        \/`  `,   `   ,`  | /__,.-`    _,   `\
                    -,-..\  _  \  `  /  ,  / `._) _,-\`       \
                     \_,,.) |\    ` /  / ) (-,, ``    ,        |
                    ,` )  | \_\       '-`  |  `(               \
                   /  /```(   , --, ,' \   |`<`    ,            |
                  /  /_,--`\   <\  V /> ,` )<_/)  | \      _____)
            ,-, ,`   `   (_,\ \    |   /) / __/  /   `----`
           (-, \           ) \ ('_.-._)/ /,`    /
           | /  `          `/ \\ V   V, /`     /
        ,--\(        ,     <_/`\\     ||      /
       (   ,``-     \/|         \-A.A-`|     /
      ,>,_ )_,..(    )\          -,,_-`  _--`
     (_ \|`   _,/_  /  \_            ,--`
     \( `   <.,../`     `-.._____,-`
