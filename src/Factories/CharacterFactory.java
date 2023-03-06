package Factories;

import Characters.Characters;
import Characters.*;
import Characterizations.Characterizations;
import Helpers.Helpers;
import League.Leagues;

import java.util.List;
import java.util.Scanner;

public class CharacterFactory {

    public Characters createCharacter(String type, List<Characters> characters, List<Characterizations> characterizations, List<Leagues> leagues){

        Scanner scanner = new Scanner(System.in);

        String opcion;

        //Datos del personaje
        System.out.print("Nombre: ");
        String name = scanner.next();
        System.out.print("Edad: ");
        int age = scanner.nextInt();
        System.out.print("Genero: ");
        String genre = scanner.next();

        Characterizations characterization = null;
        System.out.print("Quiere asignarle una caracteristica?:[s/n] ");
        opcion = scanner.next();
        if(opcion.equals("s")){
            if(characterizations.isEmpty()){
                System.out.println("No hay caracteristicas para agregar");
            } else {
                Helpers.printCharacterizations(characterizations);
                System.out.print("Ingrese una caracteristica: #");
                characterization = characterizations.get(scanner.nextInt());
            }
        }

        Leagues league = null;
        System.out.print("Quiere asignarle una liga?:[s/n] ");
        opcion = scanner.next();
        if(opcion.equals("s")){
            if(leagues.isEmpty()){
                System.out.println("No hay ligas para agregar");
            } else {
                Helpers.printLeagues(leagues);
                System.out.print("Ingrese una liga: #");
                league = leagues.get(scanner.nextInt());
            }
        }

        System.out.print("Quiere asignarle un enemigo?:[s/n] ");
        opcion = scanner.next();
        Characters enemy = null;
        if(opcion.equals("s")){
            if(characters.isEmpty()){
                System.out.println("No hay enemigos para agregar");
            } else {
                Helpers.printCharacters(characters);
                System.out.print("Ingrese un enemigo: #");
                enemy = characters.get(scanner.nextInt());
            }
        }

        switch (type) {
            case "Humans" -> {
                Characters c = new HumanCharacters(type, name, age, genre);
                if(!(enemy == null)) c.Enemy(enemy);
                if(!(characterization == null)) c.Add(characterization);
                if(!(league == null)) c.League(league);
                return c;
            }
            case "Superhumans" -> {
                return new SuperhumanCharacters(type, name, age, genre);
            }
            case "Artificials" -> {
                return new ArtificialCharacters(type, name, age, genre);
            }
            case "Aliens" -> {
                return new AlienCharacters(type, name, age, genre);
            }
            default -> {
                System.out.println("[ERROR] Este tipo no ha sido implementado.");
                return new HumanCharacters(type, name, age, genre);
            }
        }
    }

    public void editCharacter(List<Characters> characters, List<Characterizations> characterizations, List<Leagues> leagues){
        Scanner scanner = new Scanner(System.in);
        String opcion;

        if(characters.isEmpty()){
            System.out.println("No hay personajes para modificar");
            return;
        }

        Helpers.printCharacters(characters);
        System.out.println("Ingrese un personaje para modificar: #");
        Characters character = characters.get(scanner.nextInt());

        System.out.println("Agregar una caracteristica? (s/n) ");
        opcion = scanner.next();
        if(opcion.equalsIgnoreCase("s")){
            if(characterizations.isEmpty()){
                System.out.println("No hay caracteristicas para agregar");
            } else {
                Helpers.printCharacterizations(characterizations);
                System.out.print("Ingrese una caracteristica: #");
                character.Add(characterizations.get(scanner.nextInt()));
            }
        }
        System.out.println("Agregar una liga? ");
        opcion = scanner.next();
        if(opcion.equalsIgnoreCase("s")){
            if(leagues.isEmpty()){
                System.out.println("No hay ligas para agregar");
            } else {
                Helpers.printLeagues(leagues);
                System.out.print("Ingrese una liga: #");
                character.League(leagues.get(scanner.nextInt()));
            }
        }
        System.out.println("Agregar una enemigo? ");
        opcion = scanner.next();
        if(opcion.equalsIgnoreCase("s")){
            Helpers.printCharacters(characters);
            System.out.print("Ingrese un enemigo: #");
            character.Enemy(characters.get(scanner.nextInt()));
        }
        System.out.println("Se modifico el personaje correactamente");
    }

}
