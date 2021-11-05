package com.example.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests de la classe Direction
 */
public class DirectionTest
{
    /**
     * Teste le contructeur
     */
    @Test
    public void testConstructor()
    {
        // Vérifie que le constructeur assigne bien les arguments aux bonnes propriétés
        Direction direction = new Direction("north", "North");
        assertEquals("north", direction.getCommand());
        assertEquals("North", direction.getName());
    }
}