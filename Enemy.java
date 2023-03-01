public class Enemy extends Character{

    //Variable to store the players current xp
    int playerXp;
    public Enemy(String name, int playerXp) {
        super(name, (int)(Math.random()*playerXp + playerXp/2 + 10), (int)(Math.random()*(playerXp/2 + 2) +1));
        this.playerXp = playerXp;
    }


    //enemy Specific attack and defense calculations
    @Override
    public int attack() {
        return (int)(Math.random()*(playerXp/2 + 1) + xp/4 +3);
    }

    @Override
    public int defend() {
        return (int)(Math.random()*(playerXp/2 + 1) + xp/4 + 3);
    }
}
