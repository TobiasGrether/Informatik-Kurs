import java.util.ArrayList;

/**
 * Die Klasse Einkaufsliste verfügt über die elementaren Funktionen einer Liste.
 * Man kann Artikel einfügen, suchen und löschen. Die Einkaufsliste kann auch
 * ausgegeben werden.
 *
 */
public class Einkaufsliste {
   private ArrayList<Artikel> einkaufsliste = new ArrayList<Artikel>();

    /**
     * Die Liste wird um einen neuen Artikel ergänzt.
     *
     * @param pArtikel Objekt vom Typ Artikel wird angehängt
     */
    public void neuerArtikel(Artikel pArtikel) {
        einkaufsliste.add(pArtikel);
    }
    public Artikel findeArtikel(String pName){
        for( Artikel a : einkaufsliste){
            if(a.getArtikelname().equals(pName)){
                return a;
            }
        }
        return null;
    }
    /**
     * Die Einkaufsliste wird nach einem Artikel durchsucht.
     *
     * @param pName Der Name des Artikels vom Typ String ist der Suchparameter
     * @return true oder false
     */
    public boolean sucheArtikel(String pName) {
        for( Artikel a : einkaufsliste){
            if(a.getArtikelname().equals(pName)){
                return true;
            }
        }
        return false;
    }

    /**
     * Ein Artikel wird von der Einkaufsliste gelöscht.
     *
     * @param pName Der Name gibt an, welcher Artikel gelöscht werden soll
     *              Wird der zu löschende Artikel nicht gefunden, passiert nichts
     */
    public void loeschen(String pName) {
       if(sucheArtikel(pName) == true){
           einkaufsliste.remove(findeArtikel(pName));
        }
    }

    /**
     * Die Einkaufsliste wird ausgegeben
     */
    public void listeAusgeben() {
        for (Artikel a : einkaufsliste) {
            System.out.println("Artikel: " + a.getArtikelname());
        }
    }
}
