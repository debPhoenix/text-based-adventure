package com.example.entity.effect;

import com.example.entity.Item;
import com.example.entity.command.ItemCommand;

/**
 * Représente un effet permettant d'afficher un message dans la console
 */
public class MessageEffect extends AbstractEffect
{
    /**
     * Le message à afficher
     */
    private String message;

    /**
     * Crée un nouvel effet
     * @param message Le message à afficher
     */
    public MessageEffect(Item item, ItemCommand command, String message)
    {
        super(item, command);
        this.message = message;
    }

    /**
     * Déclenche l'effet
     */
    public void trigger()
    {
        // Affiche le message dans la console
        System.out.println(message);
    }
}