import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Factories.CharacterFactory;
import Characters.Characters;
import Factories.CharacterizationFactory;
import Characterizations.Characterizations;

import Helpers.Helpers;
import League.Leagues;


public class Main{
    public static void main(String[] args){
        menu();
    }

    private static void menu(){
        Scanner scanner = new Scanner(System.in);
        List<Characters> characters = new ArrayList<>();
        List<Characterizations> characterizations = new ArrayList<>();
        List<Leagues> leagues = new ArrayList<>();
        int option;

        do {

            System.out.println("|------------------------------------------");
            System.out.println("| 1) Imprimir personajes. ");
            System.out.println("| 2) Imprimir personajes dependiendo del tipo. ");
            System.out.println("| 3) Imprimir caracteristicas. ");
            System.out.println("| 4) Imprimir caracteristicas dependiendo del tipo. ");
            System.out.println("| 5) Imprimir las ligas. ");
            System.out.println("|------------------------------------------");
            System.out.println("| 6) Crear un personaje. ");
            System.out.println("| 7) Modificar un personaje. ");
            System.out.println("| 8) Crear una caracteristica. ");
            System.out.println("| 9) Crear una liga. ");
            System.out.println("| 0) Salir. ");
            System.out.println("|------------------------------------------");
            System.out.print("Que quieres hacer?: ");
            option = scanner.nextInt();
            switch (option) {
                case 1 -> Helpers.printCharacters(characters);
                case 2 -> Helpers.printCharactersByType(characters);
                case 3 -> Helpers.printCharacterizations(characterizations);
                case 4 -> Helpers.printCharacterizationsByType(characterizations);
                case 5 -> Helpers.printLeagues(leagues);
                case 6 -> characters.add(createCharacter(characters, characterizations, leagues));
                case 7 -> editCharacter(characters, characterizations, leagues);
                case 8 -> characterizations.add(createCharacterization());
                case 9 -> leagues.add(createLeague());
                case 0 -> System.out.println("Bye!");
                default -> System.out.println("[ERROR] No existe esa opcion.");
            }
            System.out.print("Seguir... (s): ");
            scanner.next();
        }while (option!=0);

    }

    private static Characters createCharacter(List<Characters> characters, List<Characterizations> characterizations, List<Leagues> leagues){
        //Selecionar el tipo de personaje
        String type = Helpers.selectCharactersType();

        //Llamar al factory del personaje
        CharacterFactory characterFactory = new CharacterFactory();
        Characters character = characterFactory.createCharacter(type,characters,characterizations,leagues);
        return character;
    }

    private static Characterizations createCharacterization(){
        //Selecionar el tipo de caracteristica
        String type = Helpers.selectCharacterizationsType();

        //Llamar al factory de las caracteristicas
        CharacterizationFactory characterizationFactory = new CharacterizationFactory();
        Characterizations characterization = characterizationFactory.createCharacterization(type);
        return characterization;
    }

    private static Leagues createLeague(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre de la liga: ");
        String name = scanner.next();

        //Llamar al factory de las caracteristicas
        return new Leagues(name);
    }

    private static void editCharacter(List<Characters> characters, List<Characterizations> characterizations, List<Leagues> leagues){
        CharacterFactory characterFactory = new CharacterFactory();
        characterFactory.editCharacter(characters,characterizations,leagues);
    }

}
