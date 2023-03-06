package Characters;

import Characterizations.Characterizations;
import Interfaces.IFicha;
import League.Leagues;

import java.util.ArrayList;
import java.util.List;

public abstract class Characters implements IFicha{
    private String type;
    private String name;
    private int age;
    private String genre;
    private List<Characterizations> characterizations = new ArrayList<>();
    private List<Leagues> leagues = new ArrayList<>();
    private List<Characters> enemys = new ArrayList<>();



    public Characters(String type,String name, int age, String genre){
        this.type = type;
        this.name = name;
        this.age = age;
        this.genre = genre;
    }

    public void Add(Characterizations characterization){
        characterizations.add(characterization);
    }

    public void League(Leagues league){
        leagues.add(league);
    }

    public void Enemy(Characters character){
        enemys.add(character);
    }

    public int getAge() {
        return age;
    }

    public String getGenre() {
        return genre;
    }


    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public List<Characters> getEnemys(){
        return enemys;
    }

    public List<Leagues> getLeagues(){
        return leagues;
    }

    public List<Characterizations> getCharacterizations(){
        return characterizations;
    }
}
