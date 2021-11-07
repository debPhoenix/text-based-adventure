package com.example.entity;

import com.example.entity.command.DirectionCommand;

/**
 * Représente un passage entre deux lieux
 */
public class RoomConnection
{
    /**
     * Le lieu de départ
     */
    private Room fromRoom;
    /**
     * Le lieu d'arrivée
     */
    private Room toRoom;
    /**
     * La direction qu'il faut emprunter pour aller du lieu de départ au lieu d'arrivée
     */
    private DirectionCommand direction;

    /**
     * Crée un nouveau passage entre deux lieux
     * @param fromRoom Le lieu de départ
     * @param toRoom Le lieu d'arrivée
     * @param direction La direction qu'il faut emprunter pour aller du lieu de départ au lieu d'arrivée
     */
    public RoomConnection(Room fromRoom, Room toRoom, DirectionCommand direction)
    {
        this.fromRoom = fromRoom;
        this.toRoom = toRoom;
        this.direction = direction;
        // Ajoute une référence à ce passage dans le lieu de départ
        fromRoom.addConnectionFrom(this);
    }

    /**
     * Récupère le lieu de départ
     */
    public Room getFromRoom()
    {
        return fromRoom;
    }

    /**
     * Récupère le lieu d'arrivée
     * @return
     */
    public Room getToRoom()
    {
        return toRoom;
    }

    /**
     * Récupère la direction qu'il faut emprunter pour aller du lieu de départ au lieu d'arrivée
     */
    public DirectionCommand getDirection()
    {
        return direction;
    }
}