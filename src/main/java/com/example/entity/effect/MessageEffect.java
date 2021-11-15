package com.example.entity.effect;

/**
 * Effet permettant d'afficher un message dans la console
 */
public class MessageEffect
{
    /**
     * Le message à afficher
     */
    private String message;

    public MessageEffect(String message)
    {
        this.message = message;
    }

    /**
     * Affiche le message
     */
    public void display()
    {
        System.out.println(message);
    }
}