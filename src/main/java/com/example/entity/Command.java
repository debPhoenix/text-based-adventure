package com.example.entity;

/**
 * Représente une commande que le joueur peut entrer
 */
public class Command
{
    /**
     * La saisie utilisateur qui va permettre d'activer cette commande
     */
    private String command;
    /**
     * Le message par défaut qui doit s'afficher lorsqu'aucun effet n'a été prévu en réponse à cette commande pour un objet donné
     */
    private String defaultMessage;

    /**
     * Crée une nouvelle commande
     * @param command La saisie utilisateur qui va permettre d'activer cette commande
     * @param defaultMessage Le message par défaut qui doit s'afficher lorsqu'aucun effet n'a été prévu en réponse à cette commande pour un objet donné
     */
    public Command(String command, String defaultMessage)
    {
        this.command = command;
        this.defaultMessage = defaultMessage;
    }

    /**
     * Renvoie la saisie utilisateur qui va permettre d'activer cette commande
     */
    public String getCommand()
    {
        return command;
    }

    /**
     * Renvoie le message par défaut qui doit s'afficher lorsqu'aucun effet n'a été prévu en réponse à cette commande pour un objet donné
     */
    public String getDefaultMessage()
    {
        return defaultMessage;
    }
}