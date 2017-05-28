/**
 * Classe permettant de creer le beamer
 * @author Kevin Ta
 * @version 2015 - 2016
 */
public class Beamer extends Item
{
    private Room aRoom;
    private boolean aCharged;

    /**
     * Constructeur de la classe Beamer
     * @param pDescription Le nom de l'objet beamer
     * @param pWeight Le poids de l'objet beamer
     */
    public Beamer(final String pDescription, final double pWeight)
    {
        super(pDescription, pWeight);
    }

    /**
     * Accesseur permettant d'acceder a la piece sauvegardee
     * @return Un objet Room
     */
    public Room getRoom()
    {
        return this.aRoom;
    }

    /**
     * Mutateur permettant de modifier la piece sauvegarde
     * @param pRoom La piece a sauvegarder
     */
    public void setRoom(final Room pRoom)
    {
        this.aRoom = pRoom;
    }

    /**
     * Accesseur permettant de connaître l'etat du beamer
     * @return True si le beamer est charge sinon false
     */
    public boolean getCharged()
    {
        return this.aCharged;
    }

    /**
     * Mutateur permettant de modifier l'etat du beamer
     * @param pCharged Un boolean
     */
    public void setCharged(final boolean pCharged)
    {
        this.aCharged = pCharged;
    }
}
