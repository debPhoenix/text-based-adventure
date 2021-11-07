package com.example.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.entity.Item;
import com.example.entity.Room;
import com.example.entity.RoomConnection;
import com.example.entity.command.Command;
import com.example.entity.command.DirectionCommand;
import com.example.entity.command.ExitCommand;
import com.example.entity.command.ItemCommand;
import com.example.entity.command.ResetCommand;

/**
 * Représente une partie jouée par le joueur.
 */
public class Game
{
    /**
     * La partie est-elle en cours?
     */
    private boolean isRunning;
    /**
     * Le lieu dans lequel le joueur se trouve actuellement
     */
    private Room currentRoom;
    /**
     * Interface permettant de surveiller les saisies utilisateur
     */
    private Scanner scanner;
    /**
     * Liste de toutes les commandes existantes
     */
    private Command[] commands;

    /**
     * Crée une nouvelle partie
     */
    public Game()
    {
        scanner = new Scanner(System.in);
    }

    /**
     * Initialise la partie en créant les objets de l'univers
     */
    public void setup()
    {
        // Crée une instance de chaque commande globale
        ExitCommand exitCommand = new ExitCommand(this);
        ResetCommand resetCommand = new ResetCommand(this);

        // Crée une instance de chaque direction
        DirectionCommand east = new DirectionCommand(this, "east", "East");
        DirectionCommand south = new DirectionCommand(this, "south", "South");
        DirectionCommand west = new DirectionCommand(this, "west", "West");
        DirectionCommand north = new DirectionCommand(this, "north", "North");

        // Crée une instance de chaque command permettant d'interagir avec les éléments du jeu
        ItemCommand open = new ItemCommand(this, "open", "This doesn't seem to open.");
        ItemCommand close = new ItemCommand(this, "close", "This doesn't seem to close.");
        ItemCommand use = new ItemCommand(this, "use", "You have no idea how to use this.");

        Command[] commands = new Command[] { exitCommand, resetCommand, east, south, west, north, open, close, use };

        // Crée les lieux
        Room bedroom = new Room("bedroom", "This is a beautiful bedroom.");
        Room corridor = new Room("corridor", "This is a beautiful corridor.");
        Room bathroom = new Room("bathroom", "This is a beautiful bathroom.");

        // Crée les connexions entre les lieux
        new RoomConnection(bedroom, corridor, west);
        new RoomConnection(corridor, bedroom, east);
        new RoomConnection(corridor, bathroom, south);
        new RoomConnection(bathroom, corridor, north);

        // Crée les éléments interactifs
        Item bed = new Item(bedroom, "bed");
        bed.bindMessageToCommand(use, "You took a quick nap.");
        Item drawer = new Item(bedroom, "drawer");
        drawer.bindMessageToCommand(open, "You opened the drawer.");
        drawer.bindMessageToCommand(close, "You closed the drawer.");
        Item notepad = new Item(bedroom, "notepad", false);
        Item toothbrush = new Item(bathroom, "toothbrush");

        // Initialise le lieu de départ
        currentRoom = bedroom;
        isRunning = true;
    }

    /**
     * Décrit un cycle d'exécution de la partie
     */
    public void update()
    {
        // Affiche la description du lieu actuel
        System.out.println("");
        System.out.println( String.format("You are in the %s.", currentRoom.getName()) );
        System.out.println(currentRoom.getDescription());
        // Affiche les sorties existantes partant de ce lieu
        System.out.print("Available exits: ");
        List<String> availableDirectionNames = new ArrayList<>();
        for (RoomConnection connection : currentRoom.getConnectionsFrom()) {
            availableDirectionNames.add(connection.getDirection().getName());
        }
        System.out.println(String.join(", ", availableDirectionNames) + ".");
        // Affiche les éléments interactifs présents dans ce lieu (s'il y en a)
        List<Item> items = currentRoom.getItems();
        if (items.isEmpty()) {
            System.out.println("No available items.");
        } else {
            System.out.print("Available items: ");
            List<String> availableItemNames = new ArrayList<>();
            for (Item item : items) {
                if (item.isVisible()) {
                    availableItemNames.add(item.getName());
                }
            }
            System.out.println(String.join(", ", availableItemNames) + ".");
        }

        // Attend une saisie utilisateur
        String userInput = scanner.nextLine();

        // Demande à chaque commande, indépendamment de son type réel, de tenter de traiter la saisie utilisateur
        // Si cette commande a réussi à traiter la saisie utilisateur, alors arrête le processus
        for (Command command : commands) {
            if (command.process(userInput)) {
                return;
            }
        }

        // Si aucune commande n'a été reconnue, affiche un message
        System.out.println("Invalid command!");
    }

    /**
     * Arrête la partie
     */
    public void terminate()
    {
        isRunning = false;
    }

    /**
     * Permet de savoir si la partie est en cours
     */
    public boolean isRunning()
    {
        return isRunning;
    }

    /**
     * Renvoie le lieu dans lequel le joueur se trouve actuellement
     */
    public Room getCurrentRoom()
    {
        return currentRoom;
    }

    /**
     * Modifie le lieu dans lequel le joueur se trouve actuellement
     */
    public void setCurrentRoom(Room room)
    {
        this.currentRoom = room;
    }
}