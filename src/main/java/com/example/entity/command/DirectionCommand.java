package com.example.entity.command;

import com.example.entity.Room;
import com.example.game.Game;

/**
 * Représente une direction que le joueur peut emprunter pour se déplacer d'un lieu à l'autre.
 */
public class DirectionCommand
{
    /**
     * La commande à entrer pour emprunter cette direction
     */
    private String command;
    /**
     * Le nom de la direction
     */
    private String name;
    /**
     * La partie en cours
     */
    private Game game;

    /**
     * Crée une nouvelle direction
     * @param game Lq partie en cours
     * @param command La commande à entrer pour emprunter cette direction
     * @param name Le nom de la direction
     */
    public DirectionCommand(Game game, String command, String name)
    {
        this.game = game;
        this.command = command;
        this.name = name;
    }

    /**
     * Tente de traiter une saisie utilisateur
     * @param userInput La saisie utilisateur à traiter
     * @return La commande a-t-elle réussi à traiter la saisie utilisateur? (vrai = oui, faux = non)
     */
    public boolean process(String userInput)
    {
        // Si la saisie utilisateur correspond à cette direction
        if (userInput.equals(command)) {
            // Cherche le lieu qui se trouve dans cette direction en partant du lieu actuel
            Room nextRoom = game.getCurrentRoom().getRoomInDirection(this);
            // S'il n'y a aucun lieu dans la direction demandée, affiche un message et s'arrête
            if (nextRoom == null) {
                System.out.println("You cannot go in that direction!");
                return true;
            }
            // Change le lieu actuel
            game.setCurrentRoom(nextRoom);
            return true;
        }
        // Sinon, c'est que la saisie utilisateur correspondait à une autre commande (ou à aucune commande)
        // Renvoie faux
        return false;
    }

    /**
     * Récupère la commande à entrer pour emprunter cette direction
     */
    public String getCommand()
    {
        return command;
    }

    /**
     * Récupère le nom de la direction
     */
    public String getName()
    {
        return name;
    }
}