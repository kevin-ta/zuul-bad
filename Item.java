/**
 * Classe item
 */
public class Item
{
    private String aDescription;
    private double aWeight;

    /**
     * Constructeur de la classe item
     */
    public Item(final String pDescription, final double pWeight)
    {
        this.aDescription = pDescription;
        this.aWeight = pWeight;
    }
    
    /**
     * Accesseur pour avoir la description de l'item
     */
    public String getDescription()
    {
        return this.aDescription;
    }
    
    /**
     * Accesseur pour avoir la description de l'item
     */
    public void setDescription(final String pDescription)
    {
        this.aDescription = pDescription;
    }
    
    /**
     * Accesseur pour avoir le poids de l'item
     */
    public double getWeight()
    {
        return this.aWeight;
    }
    
    /**
     * Mutateur pour définir le poids de l'item
     */
    public void setWeight(final double pWeight)
    {
        this.aWeight = pWeight;
    }
    
    /**
     * Accesseur pour avoir la description de l'item et son poids
     */
    public String getLongDescription()
    {
        return this.aDescription + " of " + this.aWeight + " kg";
    }
}