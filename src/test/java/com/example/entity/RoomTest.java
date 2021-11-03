package com.example.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * Tests de la classe Room
 */
public class RoomTest
{
    /**
     * Teste le contructeur
     */
    @Test
    public void testConstructor()
    {
        // Vérifie que le constructeur assigne bien les arguments aux bonnes propriétés
        Room room = new Room("bedroom", "This is a beautiful bedroom.");
        assertEquals("bedroom", room.getName());
        assertEquals("This is a beautiful bedroom.", room.getDescription());
    }

    /**
     * Teste les passages entre les lieux
     */
    @Test
    public void testConnections()
    {
        // Crée deux lieux deux directions
        Room bedroom = new Room("bedroom", "This is a beautiful bedroom.");
        Room livingRoom = new Room("living room", "This is a beautiful living room.");
        Direction east = new Direction("east", "East");
        Direction west = new Direction("west", "West");
        // Crée un passage partant de la chambre, aboutissant dans le salon, et allant vers l'est
        new RoomConnection(bedroom, livingRoom, east);
        // Crée un passage partant du salon, aboutissant dans la chambre, et allant vers l'ouest
        new RoomConnection(livingRoom, bedroom, west);

        // Lorsque l'on demande à la chambre quel lieu se trouve à son est, elle doit répondre: le salon
        assertEquals(livingRoom, bedroom.getRoomInDirection(east));
        // Lorsque l'on demande à la chambre quel lieu se trouve à son ouest, elle doit répondre: aucun
        assertNull(bedroom.getRoomInDirection(west));
        // Lorsque l'on demande au salon quel lieu se trouve à son ouest, il doit répondre: la chambre
        assertEquals(bedroom, livingRoom.getRoomInDirection(west));
        // Lorsque l'on demande au salon quel lieu se trouve à son est, il doit répondre: aucun
        assertNull(livingRoom.getRoomInDirection(east));
    }
}
