package characters;

public class Warrior extends Character implements Attacker {

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

    public int attack() {
       if(stamina >= 5) {
          return mainAttack();
       }
       return secondAttack();
    }

    @Override
    public int mainAttack() {
        int damage = strength;
        stamina = stamina - 5;
        return damage;
    }

    @Override
    public int secondAttack() {
        int damage = strength / 2;
        stamina = stamina + 1;
        return damage;
    }
}


