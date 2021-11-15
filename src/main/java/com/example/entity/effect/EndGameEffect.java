package com.example.entity.effect;

import com.example.entity.Item;
import com.example.entity.command.ItemCommand;
import com.example.game.Game;

/**
 * Représente un effet permettant d'arrêter la partie en cours
 */
public class EndGameEffect extends AbstractEffect
{
    /**
     * La partie en cours
     */
    private Game game;

    /**
     * Crée un nouvel effet
     * @param game La partie en cours
     */
    public EndGameEffect(Item item, ItemCommand command, Game game)
    {
        super(item, command);
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