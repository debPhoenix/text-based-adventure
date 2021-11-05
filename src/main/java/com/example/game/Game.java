package com.example.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.entity.Direction;
import com.example.entity.Item;
import com.example.entity.Room;
import com.example.entity.RoomConnection;

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
     * Liste de toutes les directions existantes
     */
    private Direction[] directions;

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
        Direction east = new Direction("east", "East");
        Direction south = new Direction("south", "South");
        Direction west = new Direction("west", "West");
        Direction north = new Direction("north", "North");
        directions = new Direction[] { east, south, west, north };

        Room bedroom = new Room("bedroom", "This is a beautiful bedroom.");
        Room corridor = new Room("corridor", "This is a beautiful corridor.");
        Room bathroom = new Room("bathroom", "This is a beautiful bathroom.");

        new RoomConnection(bedroom, corridor, west);
        new RoomConnection(corridor, bedroom, east);
        new RoomConnection(corridor, bathroom, south);
        new RoomConnection(bathroom, corridor, north);

        Item bed = new Item(bedroom, "bed");
        Item drawer = new Item(bedroom, "drawer");
        Item notepad = new Item(bedroom, "notepad", false);
        Item toothbrush = new Item(bathroom, "toothbrush");

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

        // Cherche si la saisie utilisateur correspond à une direction existante
        for (Direction direction : directions) {
            // Si la saisie utilisateur correspond à cette direction
            if (userInput.equals( direction.getCommand() )) {
                // Cherche le lieu qui se trouve dans cette direction en partant du lieu actuel
                Room nextRoom = currentRoom.getRoomInDirection(direction);
                // S'il n'y a aucun lieu dans la direction demandée, affiche un message et s'arrête
                if (nextRoom == null) {
                    System.out.println("You cannot go in that direction!");
                    return;
                }
                // Change le lieu actuel
                currentRoom = nextRoom;
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
}