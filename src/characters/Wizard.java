package characters;

import utils.Logger;
import utils.TypeOfMessages;

public class Wizard extends Character implements Attacker {

    public Wizard(int id, String name, String charClass, int hp, boolean isAlive, int mana, int intelligence) {
        super(id, name, charClass, hp, isAlive, mana, intelligence);
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
        Logger.LogToScreen("Damage dealt: " + damage, TypeOfMessages.DAMAGE_DEALT);

        return damage;
    }

    @Override
    public int secondAttack() {
        int damage = 2;
        setCharacterMainAttribute(getCharacterMainAttribute() + 1);
        Logger.LogToScreen("Damage dealt: " + damage +
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

