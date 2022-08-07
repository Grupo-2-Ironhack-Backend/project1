package characters;


public class Wizard extends Character implements Attacker {

    public Wizard(int id, String name, String charClass, int hp, boolean isAlive, int mana, int intelligence) {
        super(id, name, charClass, hp, isAlive, mana, intelligence);
    }

    public int attack() {
        if(mana >= 5) {
            return mainAttack();
        }
        return secondAttack();
    }

    @Override
    public int mainAttack() {
        int damage = intelligence;
        mana = mana - 5;
        return damage;
    }

    @Override
    public int secondAttack() {
        int damage = 2;
        mana = mana + 1;
        return damage;
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

