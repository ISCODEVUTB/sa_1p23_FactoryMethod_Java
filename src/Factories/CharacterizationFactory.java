package Factories;

import Characterizations.Characterizations;
import Characterizations.*;

import java.util.Scanner;

public class CharacterizationFactory {

    public Characterizations createCharacterization(String type){

        Scanner scanner = new Scanner(System.in);

        //Datos de la caracteristica
        System.out.print("Nombre: ");
        String name = scanner.next();
        System.out.print("Description: ");
        String description = scanner.next();


        switch (type) {
            case "Powers" -> {
                return new Powers(type, name, description);
            }
            case "Skills" -> {
                return new Skills(type, name, description);
            }
            case "Weaknesses" -> {
                return new Weaknesses(type, name, description);
            }
            case "Personalities" -> {
                return new Personalities(type, name, description);
            }
            default -> {
                System.out.println("[ERROR] Este tipo no ha sido implementado.");
                return new Powers(type, name, description);
            }
        }
    }

}
