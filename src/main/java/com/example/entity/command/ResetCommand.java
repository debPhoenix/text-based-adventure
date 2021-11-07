package com.example.entity.command;

import com.example.game.Game;

/**
 * Représente une commande permettant de remettre la partie à zéro
 */
public class ResetCommand implements Command
{
    /**
     * La partie en cours
     */
    private Game game;

    /**
     * Crée une nouvelle commande
     * @param game La partie en cours
     */
    public ResetCommand(Game game)
    {
        this.game = game;
    }

    /**
     * Tente de traiter une saisie utilisateur
     * @param userInput La saisie utilisateur à traiter
     * @return La commande a-t-elle réussi à traiter la saisie utilisateur? (vrai = oui, faux = non)
     */
    public boolean process(String userInput)
    {
        // Si la saisie utilisateur correspond à "reset"
        if (userInput.equals("reset")) {
            // Remet la partie à zéro
            game.setup();
            // Renvoie vrai
            return true;
        }
        // Sinon, c'est que la saisie utilisateur correspondait à une autre commande (ou à aucune commande)
        // Renvoie faux
        return false;
    }
}