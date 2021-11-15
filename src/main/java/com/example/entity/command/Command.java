package com.example.entity.command;

/**
 * Représente la structure à respecter pour toutes les classes représentant des commandes que le joueur peut entrer
 */
public interface Command
{
    /**
     * Tente de traiter une saisie utilisateur
     * @param userInput La saisie utilisateur à traiter
     * @return La commande a-t-elle réussi à traiter la saisie utilisateur? (vrai = oui, faux = non)
     */
    public boolean process(String userInput);
}