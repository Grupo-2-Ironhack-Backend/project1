package characters;

public class Wizard extends Character implements Attacker {
    private int mana;
    private int intelligence;

    public Wizard(int id, String name, int hp, boolean isAlive, int mana, int intelligence) {
        super(id, name, hp, isAlive);
        this.mana = mana;
        this.intelligence = intelligence;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public String toString() {
        //@Álex, modifica esta línea para que devuelva lo que necesites.
        return "Wizard{" +
                "mana=" + mana +
                ", intelligence=" + intelligence +
                '}';
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
}

