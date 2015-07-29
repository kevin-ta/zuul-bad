import java.util.ArrayList;

   /**
    * Class for creating lists of items
    */
   public class ItemList
   {
    private ArrayList<Item> items;

    /**
     * Constructor of class ItemList.
     */
    public ItemList()
    {
        items = new ArrayList<Item>();
    }

    /**
     * Add an item in a list.
     */
    public void addItem(Item item)
    {
        items.add(item);
    }

    /**
     * Remove an item in a list.
     */
    public void removeItem(Item item)
    {
        items.remove(item);
    }

    /**
     * Find an item in a list with its name.
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
     * @return all the items present in a list.
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
     * @return the current weight of a list
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
