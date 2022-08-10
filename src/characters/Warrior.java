package characters;

import utils.Logger;
import utils.TypeOfMessages;

public class Warrior extends Character implements Attacker {

    public Warrior(int id, String name, String charClass, int hp, boolean isAlive, int stamina, int strength) {
        super(id, name, charClass, hp, isAlive, stamina, strength);
    }

    public int setRandomHp() {
        int random = (int) (Math.random() * 100 + 100);
        this.setHp(random);
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
        int damage = getClassMainAttribute() / 2;
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
                "\nStamina: " + getCharacterMainAttribute() + "     " +
                "\nStrength: " + getClassMainAttribute() + "     " +
                "\n";
    }
}


