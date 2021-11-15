package com.example.entity.effect;

import com.example.entity.Item;
import com.example.entity.command.ItemCommand;

/**
 * Représente un effet en général et contient le code commun à tous les effets possibles
 */
public abstract class AbstractEffect implements Effect
{
    /**
     * L'élément interactif auquel cet effet est rattaché
     */
    protected Item item;
    /**
     * La commande qui permet de déclencher cet effet lorsqu'elle est utilisé sur l'élément interactif rattaché
     */
    protected ItemCommand command;

    /**
     * Crée un nouvel effet
     * @param game La partie en cours
     */
    public AbstractEffect(Item item, ItemCommand command)
    {
        this.item = item;
        this.command = command;
        item.addEffect(this);
        command.addEffect(this);
    }

    /**
     * Récupère l'élément interactif auquel cet effet est rattaché
     */
    public Item getItem()
    {
        return item;
    }

    /**
     * Récupère la commande qui permet de déclencher cet effet lorsqu'elle est utilisé sur l'élément interactif rattaché
     */
    public ItemCommand getCommand()
    {
        return command;
    }
}