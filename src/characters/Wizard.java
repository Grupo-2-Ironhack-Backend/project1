package characters;

public class Wizard extends Character {

    public Wizard(int id, String name, String charClass, int hp, boolean isAlive, int mana, int intelligence) {
        super(id, name, charClass, hp, isAlive, mana, intelligence);
    }

    public String getCharInfo() {
        return  getName() + " =======================" +
                "\nClass: " + getCharClass() + "     " +
                "\nHealth: " + getHp() + "     " +
                "\nMana: " + getCharacterMainAttribute() + "     " +
                "\nIntelligence: " + getClassMainAttribute() + "     " +
                "\n";
    }
}

