package com.example.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tests de la classe RoomConnection
 */
public class RoomConnectionTest
{
    /**
     * Teste le contructeur
     */
    @Test
    public void testConstructor()
    {
        // Crée deux lieux et un passage entre les deux
        Room bedroom = new Room("bedroom", "This is a beautiful bedroom.");
        Room livingRoom = new Room("living room", "This is a beautiful living room.");
        Direction east = new Direction("east", "East");
        RoomConnection connection = new RoomConnection(bedroom, livingRoom, east);
        // Vérifie que le constructeur assigne bien les arguments aux bonnes propriétés
        assertEquals(bedroom, connection.getFromRoom());
        assertEquals(livingRoom, connection.getToRoom());
        assertEquals(east, connection.getDirection());
        // Vérifie que le constructeur a bien ajouté une référence au passage dans le lieu de départ
        assertTrue(bedroom.getConnectionsFrom().contains(connection));
    }
}
