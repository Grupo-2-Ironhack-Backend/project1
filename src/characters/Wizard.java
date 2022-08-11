package characters;

import utils.Logger;
import utils.TypeOfMessages;

public class Wizard extends Character implements Attacker {

    public Wizard(int id, String name, String charClass, int hp, boolean isAlive, int mana, int intelligence) {
        super(id, name, charClass, hp, isAlive, mana, intelligence);
    }

    public int setRandomHp() {
        int random = (int) (Math.random() * 50 + 50);
        this.setHp(random);
        return random;
    }

    public int setRandomMana() {
        int random = (int) (Math.random() * 40 + 10);
        this.setCharacterMainAttribute(random);
        return random;
    }

    public int setRandomIntelligence() {
        int random = (int) (Math.random() * 50 + 0);
        this.setClassMainAttribute(random);
        return random;
    }

    public int attack() {
        if(getCharacterMainAttribute() >= 5) {
            return mainAttack();
        }
        return secondAttack();
    }

    @Override
    public int mainAttack() {
        int damage = getClassMainAttribute();
        setCharacterMainAttribute(getCharacterMainAttribute() - 5);
        Logger.logToScreen("Damage dealt: " + damage, TypeOfMessages.DAMAGE_DEALT);

        return damage;
    }

    @Override
    public int secondAttack() {
        int damage = 2;
        setCharacterMainAttribute(getCharacterMainAttribute() + 1);
        Logger.logToScreen("Damage dealt: " + damage +
                ", Stamina status: " +
                getCharacterMainAttribute(), TypeOfMessages.DAMAGE_DEALT);

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

