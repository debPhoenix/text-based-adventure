package com.example.entity.effect;

import com.example.game.Game;

/**
 * Représente un effet permettant d'arrêter la partie en cours
 */
public class EndGameEffect implements Effect
{
    /**
     * La partie en cours
     */
    private Game game;

    /**
     * Crée un nouvel effet
     * @param game La partie en cours
     */
    public EndGameEffect(Game game)
    {
        this.game = game;
    }

    /**
     * Déclenche l'effet
     */
    public void trigger()
    {
        // Arrête la partie en cours
        game.terminate();
    }
}