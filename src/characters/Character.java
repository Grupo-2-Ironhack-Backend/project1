package characters;

import utils.Logger;
import utils.TypeOfMessages;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Character {

    private int id;
    private String name;
    private String charClass;
    private int hp;
    private boolean isAlive;
    private int characterMainAttribute;//Mana y stamina
    private int classMainAttribute;//Fuerza y inteligencia

    public Character(int id, String name, String charClass, int hp, boolean isAlive, int charAttribute, int classAttribute) {
        setId(id);
        setName(name);
        setCharClass(charClass);
        setHp(hp);
        setAlive(isAlive);
        setCharacterMainAttribute(charAttribute);
        setClassMainAttribute(classAttribute);
        Logger.logToScreen("Character " + getName() + " created as a " + getCharClass(), TypeOfMessages.CREATION);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRandomName() throws FileNotFoundException {
        File randomNames = new File("io/listOfNames.txt");
        Scanner scanner = new Scanner(randomNames);
        List<String> names = new ArrayList<>();
        while (scanner.hasNextLine()) {
            names.add(scanner.nextLine());
        }
        int random = (int) (Math.random() * names.size());
        this.name = names.get(random);
    }

    public String getCharClass() {
        return this.charClass;
    }

    public void setCharClass(String charClass) {
        this.charClass = charClass;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
        if (hp <= 0) {
            setAlive(false);
        } else {
            setAlive(true);
        }
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getCharacterMainAttribute() {
        return characterMainAttribute;
    }

    public void setCharacterMainAttribute(int characterMainAttribute) {
        this.characterMainAttribute = characterMainAttribute;
    }

    public int getClassMainAttribute() {
        return classMainAttribute;
    }

    public void setClassMainAttribute(int classMainAttribute) {
        this.classMainAttribute = classMainAttribute;
    }
    public void setDamage(int damage) {
        setHp(hp - damage);
    }

    public abstract String getCharInfo();
    
    public abstract int attack();
    
    @Override
    public String toString() {
        //@Álex, modifica esta línea para que devuelva lo que necesites.
        return getId() + "," +
                getName() + "," +
                getCharClass() + "," +
                getHp() + "," +
                isAlive() + "," +
                getCharacterMainAttribute() + "," +
                getClassMainAttribute() + "\n";
    }
}

