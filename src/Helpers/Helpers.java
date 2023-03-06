package Helpers;

import java.util.List;
import java.util.Scanner;

import Characters.Characters;
import Characterizations.Characterizations;
import League.Leagues;

public class Helpers {

    public static void printCharacters(List<Characters> characters){

        if(characters.size()==0){
            System.out.println("NO HAY PERSONAJES");
            return;
        }

        System.out.println("LOS PERSONAJES ACTUALMENTE SON: ");
        for (Characters character: characters) {
            System.out.println(" ["+characters.indexOf(character)+"]- "+character.getName());
            System.out.println("    -> Edad: "+character.getAge()+", Genero: "+character.getGenre());
            if(character.getCharacterizations().size()==0){
                System.out.print("    -> Caracteristicas: (No tiene)");
            } else {
                System.out.print("    -> Caracteristicas: ");
                for (Characterizations characterization: character.getCharacterizations()) {
                    System.out.print(characterization.getName()+", ");
                }
            }
            System.out.println();

            if(character.getLeagues().size()==0){
                System.out.print("    -> Ligas: (No tiene)");
            } else {
                System.out.print("    -> Ligas: ");
                for (Leagues leagues: character.getLeagues()) {
                    System.out.print(leagues.getName()+", ");
                }
            }
            System.out.println();

            if(character.getEnemys().size()==0){
                System.out.print("    -> Enemigos: (No tiene)");
            } else {
                System.out.print("    -> Enemigos: ");
                for (Characters enemy: character.getEnemys()) {
                    System.out.print(enemy.getName()+", ");
                }
            }
            System.out.println();
        }
    }

    public static void printCharacterizations(List<Characterizations> characterizations){

        if(characterizations.size()==0){
            System.out.println("NO HAY CARACTERISTICAS");
            return;
        }

        System.out.println("LAS CARACTERISTICAS ACTUALMENTE SON: ");
        for (Characterizations characterization: characterizations) {
            System.out.println(" ["+characterizations.indexOf(characterization)+"] - "+characterization.getName());
            System.out.println("    ->"+characterization.getDescription());
        }
    }

    public static void printLeagues(List<Leagues> leagues){

        if(leagues.size()==0){
            System.out.println("NO HAY LIGAS");
            return;
        }

        System.out.println("LAS LIGAS ACTUALMENTE SON: ");
        for (Leagues league: leagues) {
            System.out.println(" ["+leagues.indexOf(league)+"] - "+league.getName());
        }
    }


    public static void printCharactersByType(List<Characters> characters){

        if(characters.size()==0){
            System.out.println("NO HAY PERSONAJES");
            return;
        }

        String type = selectCharactersType();

        System.out.println("Los personajes "+ type + "actualmente son: ");
        for (Characters character: characters) {
            if(character.getType().equals(type)){
                System.out.println(" - "+character.getName());
            }
        }
    }

    public static void printCharacterizationsByType(List<Characterizations> characterizations){

        if(characterizations.size()==0){
            System.out.println("NO HAY CARACTERISTICAS");
            return;
        }

        String type = selectCharacterizationsType();

        System.out.println("Los caracteristicas "+ type + "actualmente son: ");
        for (Characterizations characterization: characterizations) {
            if(characterization.getType().equals(type)){
                System.out.println(" - "+characterization.getName());
            }
        }
    }

    public static String selectCharactersType(){
        Scanner scanner = new Scanner(System.in);

        String type = null;
        do{
            System.out.println("Crear un nuevo personaje... ");
            System.out.println("Tipos: ");
            System.out.println("1) Humanos");
            System.out.println("2) Superhumanos");
            System.out.println("3) Artificiales");
            System.out.println("4) Aliens");
            System.out.print("Elige una opcion: #");
            int option = scanner.nextInt();
            switch (option) {
                case 1 -> type = "Humans";
                case 2 -> type = "Superhumans";
                case 3 -> type = "Artificials";
                case 4 -> type = "Aliens";
                default -> System.out.println("[ERROR] No existe esa opcion.");
            }
        }while (type == null);
        return type;
    }

    public static String selectCharacterizationsType(){
        Scanner scanner = new Scanner(System.in);

        String type = null;
        do{
            System.out.println("Crear una nueva caracteristica... ");
            System.out.println("Tipos: ");
            System.out.println("1) Poderes");
            System.out.println("2) Habilidades");
            System.out.println("3) Debilidades");
            System.out.println("4) Personalidades");
            System.out.print("Elige una opcion: #");
            int option = scanner.nextInt();
            switch (option) {
                case 1 -> type = "Powers";
                case 2 -> type = "Skills";
                case 3 -> type = "Weaknesses";
                case 4 -> type = "Personalities";
                default -> System.out.println("[ERROR] No existe esa opcion.");
            }
        }while (type == null);
        return type;
    }

}
