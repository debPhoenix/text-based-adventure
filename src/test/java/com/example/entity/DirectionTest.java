package com.example.entity;

import static org.junit.Assert.assertEquals;

import com.example.entity.command.DirectionCommand;
import com.example.game.Game;

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
        DirectionCommand direction = new DirectionCommand(new Game(), "north", "North");
        assertEquals("north", direction.getCommand());
        assertEquals("North", direction.getName());
    }
}