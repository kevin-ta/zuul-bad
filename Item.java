/**
 * Classe permettant de gerer les items du jeu
 * @author Kevin Ta
 * @version 2015 - 2016
 */
public class Item
{
    private String aDescription;
    private double aWeight;

    /**
     * Constructeur de la classe item
     * @param pDescription Le nom de l'objet Item
     * @param pWeight Le poids de l'objet Item
     */
    public Item(final String pDescription, final double pWeight)
    {
        this.aDescription = pDescription;
        this.aWeight = pWeight;
    }
    
    /**
     * Accesseur permettant d'acceder au nom de l'item
     * @return Le nom de l'item
     */
    public String getDescription()
    {
        return this.aDescription;
    }
    
    /**
     * Mutateur permettant de modifier le nom de l'item
     * @param pDescription Le nom de l'item
     */
    public void setDescription(final String pDescription)
    {
        this.aDescription = pDescription;
    }
    
    /**
     * Accesseur permettant d'acceder au poids de l'item
     * @return Le poids de l'item
     */
    public double getWeight()
    {
        return this.aWeight;
    }
    
    /**
     * Mutateur permettant de modifier le poids de l'item
     * @param pWeight Le poids de l'item
     */
    public void setWeight(final double pWeight)
    {
        this.aWeight = pWeight;
    }
    
    /**
     * Fonction retournant une chaine de caracteres contenant le nom de l'item et son poids
     * @return Une chaine de caracteres contenant le nom de l'item et son poids
     */
    public String getLongDescription()
    {
        return this.aDescription + " of " + this.aWeight + " kg";
    }
}