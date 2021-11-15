package com.example.entity.command;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.entity.Item;
import com.example.entity.effect.Effect;
import com.example.game.Game;

/**
 * Représente une commande permettant d'interagir avec un élément de l'univers
 */
public class ItemCommand implements Command
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
     * La partie en cours
     */
    private Game game;

    /**
     * Crée une nouvelle commande
     * @param game La partie en cours
     * @param command La saisie utilisateur qui va permettre d'activer cette commande
     * @param defaultMessage Le message par défaut qui doit s'afficher lorsqu'aucun effet n'a été prévu en réponse à cette commande pour un objet donné
     */
    public ItemCommand(Game game, String command, String defaultMessage)
    {
        this.game = game;
        this.command = command;
        this.defaultMessage = defaultMessage;
    }

    /**
     * Tente de traiter une saisie utilisateur
     * @param userInput La saisie utilisateur à traiter
     * @return La commande a-t-elle réussi à traiter la saisie utilisateur? (vrai = oui, faux = non)
     */
    public boolean process(String userInput)
    {
        // Crée une expression régulière à partir du nom de cette commande
        Pattern pattern = Pattern.compile("^" + command + "\\s(.+)$");
        // Vérifie la correspondance de la saisie utilisateur avec l'expression régulière
        Matcher matcher = pattern.matcher(userInput);
        // Si la saisie de l'utilisateur correspond à cette commande
        if (matcher.find()) {
            // Isole le nom de l'objet dans la commande
            String itemName = matcher.group(1);
            // Cherche l'objet correspondant à ce nom parmi les objets présents et visibles
            for (Item item : game.getCurrentRoom().getItems()) {
                if (item.getName().equals(itemName)) {
                    // Si l'objet existe et est visible
                    if (item.isVisible()) {
                        // Récupère l'effet associé à cet élément interactif et à cette commande
                        Effect effect = item.getEffectBoundToCommand(this);
                        // Si aucun effet n'a été programmé pour cette commmande utilisée sur cet élément interactif
                        if (effect == null) {
                            // Affiche le message par défaut de la commande
                            System.out.println(defaultMessage);
                            return true;
                        }
                        // Sinon, déclenche l'effet trouvé
                        effect.trigger();
                        return true;
                    }
                }
            }
            // L'objet n'existe pas
            System.out.println("There is no such object here!");
            return true;
        }
        // Sinon, c'est que la saisie utilisateur correspondait à une autre commande (ou à aucune commande)
        // Renvoie faux
        return false;
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