package com.example.entity.effect;

/**
 * Représente la structure requise pour tous les effets qui doivent se déclencher quand le joueur utilise une commande sur un élément interactif
 */
public interface Effect
{
    /**
     * Déclenche l'effet
     */
    public void trigger();
}