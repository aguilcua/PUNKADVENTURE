import java.util.*;
public class GameLogic {
    static Scanner scanner = new Scanner(System.in);
    static Player player;
    public static boolean isRunning;

    //random encounters
    public static String[] encounters = {"Battle","Battle","Battle", "Rest", "Rest"};
    //enemy names
    public static String [] enemies = {"Goblin", "Goblin", "Ogre", "marshmallow person", "Cookie Monster"};

    //story elements
    public static int place = 0, act = 1;
    public static String[] places = {"Infested Swamp", "Harmless Village", "Cat Room", "Cinder blox room"};

    //method to get user input from console
    public static int readInt(String prompt, int userChoices){
        int input;
        do{
            System.out.println(prompt);
            try{
                input = Integer.parseInt(scanner.next());
            } catch (Exception e){
                input = -1;
                System.out.println("Please enter an Integer!");
            }
        } while (input < 1 || input > userChoices);
        return input;
    }

    //method to "clear out" console
    public static void clearConsole(){
        for (int i = 0; i<100; i++){
            System.out.println();   //just prints a bunch of spaces to simulate a cleared console
        }
    }

    //method to print a separator with length n
    public static void printSeparator(int n){
        for(int i = 0; i < n; i++)
            System.out.print("-");
        System.out.println(); // line break
    }

    //method to print a heading
    public static void printHeading(String title){
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }

    //method to stop the game until user enters something in order for them to read it
    public static void anythingToContinue(){
        System.out.println("\nEnter anything to continue...");
        scanner.next();
    }
    //method to start the game
    public static void startGame(){
        boolean nameSet = false;
        String name;
        //print title screen
        clearConsole();
        printSeparator(40);
        printSeparator(30);
        System.out.println("PRACTICE ROLE PLAYING GAME");
        System.out.println("Made BY MEEEE");
        printSeparator(30);
        printSeparator(40);
        anythingToContinue();

        //getting the player's name
        do{
            GameLogic.clearConsole();
            GameLogic.printHeading("What is your name?");
            name = scanner.next();
            //ask if the player wants to correct their name
            clearConsole();
            printHeading("Your name is " + name + ".\nIs that correct?");
            System.out.println("(1) yes!");
            System.out.println("(2) NO, I want to change my name!");
            int input = readInt("->", 2);
            if(input ==1)
                nameSet = true;
        } while(!nameSet);
        //print story intro
        Story.printIntro();
        //create new player object with that name
        player = new Player(name);
        //print first story act intro
        Story.printFirstActIntro();
        //set isRunning to true, so game can continue
        isRunning = true;
        gameLoop();
    }
    //method that changes game values based on player xp
    public static void checkAct() {
        //change acts based on xp
        if (player.xp >= 10 && act == 1) {
            //increment act and place
            act = 2;
            place = 1;
            //story
            Story.printFirstActOutro();
            // let player choose trait
            player.chooseTrait();
            //more story
            Story.printSecondActIntro();
            //assign new values to enemies
            enemies[0] = "GObbo";
            enemies[1] = "Bobbo";
            enemies[2] = "Gando";
            enemies[3] = "Bando";
            enemies[4] = "Grando";
            //assign new values to encounters
            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Battle";
            encounters[3] = "Rest";
            encounters[4] = "Shop";

        } else if (player.xp >= 50 && act == 2) {
            act = 3;
            place = 2;
            //story
            Story.printSecondActOutro();
            //trait
            player.chooseTrait();
            //story
            Story.printThirdActIntro();
            //assign new values to enemies
            enemies[0] = "GObbo";
            enemies[1] = "Bobbo";
            enemies[2] = "Gando";
            enemies[3] = "Bando";
            enemies[4] = "Grando";
            //assign new values to encounters
            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Battle";
            encounters[3] = "Rest";
            encounters[4] = "Shop";
            //fully restore player hp
            player.hp = player.maxHp;
        } else if (player.xp >= 100 && act == 3) {
            act = 4;
            place = 3;
            //story
            Story.printThirdActOutro();
            //trait
            player.chooseTrait();
            //story
            Story.printFourthActIntro();
            //fully restore player hp
            player.hp = player.maxHp;
            //calling final battle
            finalBattle();
        }
    }
    //method to calculate random encounter for player
    public static void randomEncounter(){
        //random number between 0 and length of encounters array
        int encounter = (int) (Math.random()* encounters.length);
        //calling methods
        if (encounters[encounter].equals("Battle")) {
            randomBattle();
        } else if(encounters[encounter].equals("Rest")) {
            takeRest();
        } else{
            shop();
        }

    }
    //method to continue journey
    public static void continueJourney(){
        //check if act must be increased
        checkAct();
        //check if game is not in last act
        if(act != 4){
            randomEncounter();
        }
    }

    //print important information about player character
    public static void characterInfo(){
        clearConsole();
        printHeading("CHARACTER INFO");
        System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxHp);
        printSeparator(20);
        //player xp and gold
        System.out.println("XP: " + player.xp + "\tGold: " + player.gold);
        printSeparator(20);
        //number of pots
        System.out.println("# of Potions: " + player.pots);
        printSeparator(20);

        //print chosen traits
        if(player.numAtkUpgrades > 0){
            System.out.println("Offensive trait: "+ player.atkUpgrades[player.numAtkUpgrades - 1]);
            printSeparator(20);
        }
        if(player.numDefUpgrades > 0){
            System.out.println("Defensive trait: " + player.defUpgrades[player.numDefUpgrades - 1]);
            printSeparator(20);
        }
        anythingToContinue();
    }
    //shopping / encountering a traveling trader
    public  static void shop(){
        clearConsole();
        printHeading("You encounter a mysterious stranger willing to sell you wares");
        int price = (int) (Math.random()* (10 + player.pots*3) + 10 + player.pots);
        System.out.println("- Magic Potion: " + price + " gold.");
        printSeparator(20);
        //ask if player wants to buy one
        System.out.println("Do you want to buy one?\n(1) I guess.. \n(2) No thanks.");
        int input = readInt("->", 2);
        //check if player wants to buy
        if (input ==1){
            clearConsole();
            //check if player has enough gold
            if(player.gold >= price){
                printHeading("You bought a Magical potion for" + price + "gold.");
                player.pots++;
                player.gold -= price;
            } else{
                printHeading("You don't have enough gold to buy this... dumbass");
                anythingToContinue();
            }
        }
    }
    //take a rest
    public static void  takeRest(){
        clearConsole();
        if(player.restsLeft >= 1){
            printHeading("Do you want to take a rest? " + player.restsLeft + " rest left.");
            System.out.println("(1) take a rest\n(2) nahhhhh");
            int input = readInt("->", 2);
            //check if player wants to rest
            if(input ==1) {
                clearConsole();
                printHeading("You take a rest");
                if (player.hp < player.maxHp){
                    int hpRestored = (int) (Math.random() * (player.xp / 4 + 1) + 10);
                player.hp += hpRestored;
                if(player.hp > player.maxHp)
                    player.hp = player.maxHp;
                System.out.println("You took a rest and restored up to " + hpRestored + " health.");
                System.out.println("You're now at " + player.hp +"/" + player.maxHp +" health.");
                player.restsLeft--;
            }
            } else{
                System.out.println("you decide not to rest");
            }
            anythingToContinue();
        }
    }

    //create random battle
    public static void randomBattle(){
        clearConsole();
        printHeading("You encountered an evil minded creature. You'll have to fight it!");
        anythingToContinue();
        //create a new enemy with random name
        battle(new Enemy(enemies[(int) (Math.random()* enemies.length)], player.xp));
    }
    //main BATTLE method
    public static void  battle(Enemy enemy){
        //main battle loop
        while (true){
            clearConsole();
            printHeading(enemy.name + "\nHP: " + enemy.hp + "/" + enemy.maxHp);
            printHeading(player.name + "\nHP: " +  player.hp + "/" + player.maxHp);
            System.out.println("Choose an action: ");
            printSeparator(20);
            System.out.println("(1) Fight\n(2) Use Potion\n(3) Run Away");
            int input = readInt("->", 3);
            //react accordingly to player input
            if(input == 1){
            //fight , calculate damage  and damage taken
                int dmg = player.attack() - enemy.defend();
                int dmgTaken = enemy.attack() - player.defend();
                //check that damage isn't negative
                if(dmgTaken < 0){
                    dmg -= dmgTaken/2;
                    dmgTaken = 0;
                }
                if(dmg < 0)
                   dmg = 0;
                //deal damage to both parties
                enemy.hp -= dmg;
                player.hp -= dmgTaken;
                    //print the info of the battle round
                clearConsole();
                printHeading("BATTLE");
                System.out.println("You dealt " +dmg +" damage to the " + enemy.name + ".");
                printSeparator(15);
                System.out.println("the " + enemy.name +" dealt " + dmgTaken + " damage to you.");
                anythingToContinue();
                //check if player is alive or dead
                if(player.hp <= 0){
                    playerDied(); //method to end the game
                    break;
                } else if ( enemy.hp <= 0){
                    clearConsole();
                    printHeading("You defeated the " + enemy.name + "!");
                    //increase player xp
                    player.xp += enemy.xp;
                    System.out.println("You gained " + enemy.xp + " XP!");
                    //random drops
                    boolean addRest = (Math.random()*5 + 1 <= 2.25);
                    int goldEarned = (int) (Math.random() *enemy.xp);
                    if(addRest){
                        player.restsLeft++;
                        System.out.println("You earned the change to get an additional rest!");
                    }
                    if (goldEarned > 0){
                        player.gold += goldEarned;
                        System.out.println("You collected " + goldEarned + " gold from the " + enemy.name + "'s corpse!");
                    }
                    anythingToContinue();
                    break;
                }
            } else if (input == 2){
                //use potion
                clearConsole();
                if (player.pots > 0 && player.hp < player.maxHp){
                    //player can take a potion
                    //make sure player wants to take potion
                    System.out.println("Are you sure you want to take a potion? " + player.pots + " left");
                    System.out.println("(1) drink potion \n(2) Don't drink potion");
                    input = readInt("->", 2);
                    if (input == 1){
                        //player takes potion
                        player.hp = player.maxHp;
                        clearConsole();
                        printHeading("You drank a magic potion. it restored your health to " + player.maxHp + "/" + player.maxHp);
                        anythingToContinue();
                    }
                }else {
                    //player cannot take a potion
                    printHeading("You don't have any potions or you're at full health dummy.");
                    anythingToContinue();
                }

            } else{
            //RUN AWAY
                clearConsole();
                if(act != 4){
                    if (Math.random()*10 + 1 <= 3.5){
                        printHeading("You ran away from the " + enemy.name + "!");
                        anythingToContinue();
                        break;
                    } else {
                        printHeading("You didn't manage to escape");
                        int dmgTaken = enemy.attack();
                        System.out.println("In your hurry you took " + dmgTaken + " damage!");
                        anythingToContinue();
                        //check if player alive
                        if (player.hp <= 0)
                            playerDied();
                    }
                } else{
                    printHeading("YOU CANNOT ESCAPE THE CINDER GUY!!!");
                    anythingToContinue();
                }
            }
    }




}
    // printing the menu
    public static void printMenu(){
        clearConsole();
        printHeading(places[place]);
        System.out.println("CHoose an action:");
        printSeparator(20);
        System.out.println("(1) Continue on your journey");
        System.out.println("(2) Character Info");
        System.out.println("(3) Exit Game");
    }
    //start main game loop
    public static void gameLoop(){
        while(isRunning){
            printMenu();
            int input = readInt("->", 3);
            if (input == 1)
                continueJourney();
            else if (input == 2)
                characterInfo();
            else
                isRunning = false;
        }
    }

    public static void playerDied() {
        clearConsole();
        printHeading("YOU DIED...");
        printHeading("You earned" + player.xp + "XP on your journey. Try to gain more next time loser! ");
        printHeading("Thanks for wasting your time!");
        isRunning = false;
    }
    //the final battle of the entire game
    public static void finalBattle(){
        //create the cinder man and let the player fight against him
        battle(new Enemy("CINDER MAN",300));
        //printing story and proper ending
        Story.printEnd(player);
        isRunning = false;

    }
}


