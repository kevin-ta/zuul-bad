package pkg_item;

import java.util.ArrayList;

/**
 * Classe permettant de creer un inventaire d'items
 * @author Kevin Ta
 * @version 2015 - 2016
 */
public class ItemList
{
    private ArrayList<Item> items;

    /**
     * Constructeur de la classe ItemList
     */
    public ItemList()
    {
        items = new ArrayList<Item>();
    }

    /**
     * Procedure permettant d'ajouter un item dans l'inventaire
     * @param item Un objet Item
     */
    public void addItem(Item item)
    {
        items.add(item);
    }

    /**
     * Procedure permettant de supprimer un item de l'inventaire
     * @param item Un objet Item
     */
    public void removeItem(Item item)
    {
        items.remove(item);
    }

    /**
     * Fonction permettant de retrouver un item dans l'inventaire
     * @param item Un objet Item
     * @return L'objet Item correspondant s'il existe dans l'inventaire sinon null
     */
    public Item findItem(String item)
    {
        for (int i=0; i < items.size(); i++)
        {
            Item chp = (Item) items.get(i);
            if (item.equals(chp.getDescription()))
            {
                return chp;
            }
        }
        return null;
    }

    /**
     * Fonction retournant une chaine de caracteres contenant tous les items de l'inventaire
     * @return Une chaine de caracteres contenant tous les items de l'inventaire
     */
    public String getItemString()
    {
        String returnString = "Items:";
        for (int i=0; i < items.size(); i++)
        {
            returnString += (" " + ((Item) items.get(i)).getLongDescription());
        }
        return returnString;
    }
    
    /**
     * Fonction retournant le poids courant de l'inventaire
     * @return le poids courant de l'inventaire
     */
    public double getCurrentWeight()
        {
        double totalWeight = 0.0;
        for(int i=0; i < items.size(); i++)
        {
            totalWeight += (items.get(i)).getWeight();
        }
        return totalWeight;
    }
}
