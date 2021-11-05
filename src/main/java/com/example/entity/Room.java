

package com.example.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente un lieu dans lequel le joueur peut se trouver.
 */
public class Room
{
    /**
     * Le nom du lieu
     */
    private String name;
    /**
     * La description du lieu
     */
    private String description;
    /**
     * La liste de tous les passages qui prennent ce lieu comme lieu de départ
     */
    private List<RoomConnection> connectedFrom;
    /**
     * La liste de tous les éléments interactifs présents dans ce lieu
     */
    private List<Item> items;

    /**
     * Crée un nouveau lieu
     * @param name Le nom du lieu
     * @param description La description du lieu
     */
    public Room(String name, String description)
    {
        this.name = name;
        this.description = description;
        connectedFrom = new ArrayList<>();
        items = new ArrayList<>();
    }

    /**
     * Récupère le nom du lieu
     */
    public String getName()
    {
        return name;
    }

    /**
     * Récupère la description du lieu
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Renvoie la liste de tous les passages qui prennent ce lieu comme lieu de départ
     */
    public List<RoomConnection> getConnectionsFrom()
    {
        return connectedFrom;
    }

    /**
     * Ajoute un passage prenant ce lieu comme lieu de départ
     * @param connection
     */
    public void addConnectionFrom(RoomConnection connection)
    {
        connectedFrom.add(connection);
    }

    /**
     * Renvoie la liste de tous les éléments interactifs présents dans ce lieu
     */
    public List<Item> getItems()
    {
        return items;
    }

    /**
     * Ajoute un élément interactif à la liste des éléments présents dans ce lieu
     * @param item L'élément interactif à ajouter
     */
    public void addItem(Item item)
    {
        items.add(item);
    }

    /**
     * Renvoie le lieu où l'on arrive lorsque l'on emprunte une direction spécifiée en partant de ce lieu
     * @param direction La direction à emprunter à partir de ce lieu
     * @return
     */
    public Room getRoomInDirection(Direction direction)
    {
        // Pour chaque passage qui part de ce lieu
        for (RoomConnection connection : connectedFrom) {
            // Si la direction pour emprunter le passage correspond à la direction recherchée
            if (connection.getDirection() == direction) {
                // Renvoie le lieu d'arrivée de ce passage
                return connection.getToRoom();
            }
        }
        // Si la boucle s'est finie sans trouver de passage correspondant à la direction recherchée,
        // c'est donc qu'il n'y a aucun lieu dans cette direction
        return null;
    }
}