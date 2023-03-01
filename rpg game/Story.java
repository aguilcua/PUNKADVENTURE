

//class that does nothing but storing methods to print out every part of the story
public class Story {
    public static void printIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("STORY");
        GameLogic.printSeparator(30);
        System.out.println("One day you were playing your \"RPG\" games, when suddenly you are teleported into a different world");
        System.out.println("You are tasked with defeating the lord of cinder, but first you must defeat the henchmen");
        System.out.println("Gather your might and prepare to FUCK... I mean FIGHT!");
        GameLogic.anythingToContinue();
    }
    public static void printFirstActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT 1 - INTRO");
        GameLogic.printSeparator(30);
        System.out.println("As you begin your journey you are brought to a swamp.");
        System.out.println("ALl enemies are disguised as other creatures but in reality, you're killing whatever the script says...");
        System.out.println("The swamp is infested by a small group of goblins from the hit anime \"Goblin Slayer.\"");
        System.out.println("You think it should be an easy task to defeat and dispose of them.");
        GameLogic.anythingToContinue();
    }
    public static void printFirstActOutro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT 1 - OUTRO");
        GameLogic.printSeparator(30);
        System.out.println("You defeated the goblins! But now you are filled with remorse");
        System.out.println("You've never killed a living creature begging for their life before, but you try and persevere.");
        System.out.println(" You have developed PTSD and go onto the next area to clear your head.");
        GameLogic.anythingToContinue();
    }
    public static void printSecondActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT 2 - INTRO");
        GameLogic.printSeparator(30);
        System.out.println("You arrive at a village thinking its a normal village where you can replenish your wares.");
        System.out.println("However, this village is actually filled with *ReDaCtED* who look exactly like you");
        System.out.println("You must fight with these creatures that mimic your looks.");
        System.out.println("Can you really kill another human being?");
        GameLogic.anythingToContinue();
    }
    public static void printSecondActOutro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT 2 - OUTRO");
        GameLogic.printSeparator(30);
        System.out.println("Finally after a tough battle you managed to win somehow.");
        System.out.println("Congrats! you managed to kill multiple creatures who just wanted to be like you!");
        System.out.println("You're such a good person! You should become a politician! Onward! to the next creatures to slay!");
        GameLogic.anythingToContinue();
    }
    public static void printThirdActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT 3 - INTRO");
        GameLogic.printSeparator(30);
        System.out.println("You keep walking, because... Why not?");
        System.out.println("You happen to find another village hoping to find another normal person to talk to");
        System.out.println("however you are met with a single human-like being who informs you they slaughted all of the villagers");
        GameLogic.anythingToContinue();
    }
    public static void printThirdActOutro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT 3 - OUTRO");
        GameLogic.printSeparator(30);
        System.out.println("After doing this creature the favor of taking his life, you move onward");
        System.out.println("You can't help but wonder \"who made you judge and jury?\"");
        System.out.println("Nevertheless You think you did something right and thats all that matters! Onward!");
        GameLogic.anythingToContinue();
    }
    public static void printFourthActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT 4 - INTRO");
        GameLogic.printSeparator(30);
        System.out.println("This is it! The final battle before the final battle! :D");
        System.out.println("This time its an adorable cat, however its not just any adorable cat... It HAS A KITTEN");
        System.out.println("It's only attacking because it wants to protect its twin orphan kitten.");
        GameLogic.anythingToContinue();
    }
    public static void printFourthActOutro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT 1 - INTRO");
        GameLogic.printSeparator(30);
        System.out.println("Good Job, You killed an innocent cat!");
        System.out.println("I know you were only following orders but guess what...");
        System.out.println("That's what the nazi's were doing as well!");
        System.out.println("GO ONWARD TO THE FINAL BATTLEEEEEEEEE! RAAAAAAAAAH");
        GameLogic.anythingToContinue();
    }
    public static void printEnd(Player player){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("Congratulations, " + player.name + "! You defeated the CINDER BLOCK LORD and gained nothing from it!");
        GameLogic.printSeparator(30);
        System.out.println("This game sucked as it should!");
        System.out.println("You are a real piece of work for willingly completing the game... thanks ig?");
    }

}
