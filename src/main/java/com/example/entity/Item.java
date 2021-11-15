package com.example.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.entity.command.ItemCommand;
import com.example.entity.effect.Effect;

/**
 * Représente un élément interactif de l'univers
 */
public class Item
{
    /**
     * Le nom de l'élément
     */
    private String name;
    /**
     * L'élément est-il visible par le joueur?
     */
    private boolean visible;
    /**
     * Le lieu dans lequel se trouve l'élément
     */
    private Room room;
    /**
     * La liste de tous les effets qui peuvent se déclencher lorsqu'on utilise une commande avec cet élément
     */
    private List<Effect> effects;

    /**
     * Crée un nouvel élément interactif visible
     * @param room Le lieu dans lequel se trouve l'élément
     * @param name Le nom de l'élément
     */
    public Item(Room room, String name)
    {
        this.room = room;
        this.name = name;
        this.visible = true;
        // Demande au lieu concerné d'ajouter l'objet que l'on est en train de créer à sa liste d'éléments interactifs
        room.addItem(this);
        effects = new ArrayList<>();
    }

    /**
     * Crée un nouvel élément interactif
     * @param room Le lieu dans lequel se trouve l'élément
     * @param name Le nom de l'élément
     * @param visible L'élément est-il visible par le joueur?
     */
    public Item(Room room, String name, boolean visible)
    {
        this.room = room;
        this.name = name;
        this.visible = visible;
        // Demande au lieu concerné d'ajouter l'objet que l'on est en train de créer à sa liste d'éléments interactifs
        room.addItem(this);
        effects = new ArrayList<>();
    }

    /**
     * Renvoie le nom de l'élément
     */
    public String getName()
    {
        return name;
    }

    /**
     * Renvoie l'élément est-il visible par le joueur?
     */
    public boolean isVisible()
    {
        return visible;
    }

    /**
     * Renvoie le lieu dans lequel se trouve l'élément
     */
    public Room getRoom()
    {
        return room;
    }

    /**
     * Ajoute un effet à la liste
     */
    public void addEffect(Effect effect)
    {
        effects.add(effect);
    }
}