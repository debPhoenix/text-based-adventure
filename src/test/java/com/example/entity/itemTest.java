package com.example.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tests de la classe ITem
 */
public class ItemTest
{
    /**
     * Teste le contructeur
     */
    @Test
    public void testConstructor()
    {
        Room room = new Room("bedroom", "This is a beautiful bedroom.");

        Item item = new Item(room, "bed");
        assertEquals("bed", item.getName());
        assertEquals(room, item.getRoom());
        assertEquals(true, item.isVisible());
        assertTrue(room.getItems().contains(item));

        item = new Item(room, "bed", false);
        assertEquals("bed", item.getName());
        assertEquals(room, item.getRoom());
        assertEquals(false, item.isVisible());
        assertTrue(room.getItems().contains(item));
    }
}