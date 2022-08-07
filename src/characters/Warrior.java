package characters;

public class Warrior extends Character implements Attacker {

    private int stamina;
    private int strength;
    public Warrior(int id, String name, int hp, boolean isAlive, int stamina, int strength) {
        super(id, name, hp, isAlive);
        this.stamina = stamina;
        this.strength = strength;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
     //@Álex, modifica esta línea para que devuelva lo que necesites.
        return "Warrior{" +
                "stamina=" + stamina +
                ", strength=" + strength +
                '}';
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


