package com.example.entity;

/**
 * Représente une direction que le joueur peut emprunter pour se déplacer d'un lieu à l'autre.
 */
public class Direction
{
    /**
     * La commande à entrer pour emprunter cette direction
     */
    private String command;
    /**
     * Le nom de la direction
     */
    private String name;

    /**
     * Crée une nouvelle direction
     * @param command La commande à entrer pour emprunter cette direction
     * @param name Le nom de la direction
     */
    public Direction(String command, String name)
    {
        this.command = command;
        this.name = name;
    }

    /**
     * Récupère la commande à entrer pour emprunter cette direction
     */
    public String getCommand()
    {
        return command;
    }

    /**
     * Récupère le nom de la direction
     */
    public String getName()
    {
        return name;
    }
}
