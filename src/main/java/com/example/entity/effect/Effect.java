package com.example.entity.effect;

import com.example.entity.Item;
import com.example.entity.command.ItemCommand;

/**
 * Représente la structure requise pour tous les effets qui doivent se déclencher quand le joueur utilise une commande sur un élément interactif
 */
public interface Effect
{
    /**
     * Déclenche l'effet
     */
    public void trigger();
    /**
     * Récupère l'élément interactif auquel cet effet est rattaché
     */
    public Item getItem();
    /**
     * Récupère la commande qui permet de déclencher cet effet lorsqu'elle est utilisé sur l'élément interactif rattaché
     */
    public ItemCommand getCommand();
}