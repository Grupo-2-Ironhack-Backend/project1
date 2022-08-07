package characters;

public class Warrior extends Character {

    public Warrior(int id, String name, String charClass, int hp, boolean isAlive, int stamina, int strength) {
        super(id, name, charClass, hp, isAlive, stamina, strength);
    }

    public String getCharInfo() {
        return  getName() + " =======================" +
                "\nClass: " + getCharClass() + "     " +
                "\nHealth: " + getHp() + "     " +
                "\nStamina: " + getCharacterMainAttribute() + "     " +
                "\nStrength: " + getClassMainAttribute() + "     " +
                "\n";
    }
}


