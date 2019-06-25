
/**
 * Beschreiben Sie hier die Klasse Stundenplan.
 * 
 * @author (Ihr Name) 
 * @version (JJJJ-MM-TT)
 */
public class Stundenplan
{
    //Attribute
    private String[][] stundenplan;
  
    //Konstruktor
    /**
     * Konstruktor für Objekte der Klasse Stundenplan
     */
    public Stundenplan()
    {
        stundenplan = new String[5][8];
        eintragen(0, 0, "EK 8");
        eintragen(0, 1, "IF 8");
        eintragen(0, 2, "SW");
        eintragen(0, 3, "SW");
        eintragen(0, 4, "Reli");
        eintragen(0, 5, "Mu");
        eintragen(0, 6, "MVK");
        eintragen(0, 7, "MVK");
        eintragen(1, 0, "GE");
        eintragen(1, 1, "GE");
        eintragen(1, 2, "BI");
        eintragen(1, 3, "E");
        eintragen(1, 4, "SP");
        eintragen(1, 5, "SP");
        eintragen(1, 6, "IF");
        eintragen(1, 7, "IF");
        eintragen(2, 0, "Reli");
        eintragen(2, 1, "Reli");
        eintragen(2, 2, "EK");
        eintragen(2, 3, "EK");
        eintragen(2, 4, "D");
        eintragen(2, 5, "M");
        eintragen(2, 6, "Sp");
        eintragen(2, 7, "Sw");
        eintragen(3, 0, "E");
        eintragen(3, 1, "E");
        eintragen(3, 2, "Mu");
        eintragen(3, 3, "Mu");
        eintragen(3, 4, "D");
        eintragen(3, 5, "D");
        eintragen(4, 0, "Ge");
        eintragen(4, 1, "Frei");
        eintragen(4, 2, "M");
        eintragen(4, 3, "M");
        eintragen(4, 4, "Bio");
        eintragen(4, 5, "Bio");
    }
    public void eintragen(int tag, int stunde, String fach){
        stundenplan[tag][stunde] = fach;
    }
    public void austragen(int tag, int stunde){
        stundenplan[tag][stunde] = null;
    }
    public void ausgeben(){
        System.out.println("Mo\tDi\tMi\tDo\tFr");
        System.out.println("------------------------------------");
        
            for(int i1 = 0; i1 <= 7; i1++){
                for(int i = 0; i <= 4; i++){
                    if(stundenplan[i][i1] == null){
                        System.out.print("// \t");
                    }else{
                        System.out.print(stundenplan[i][i1] + "\t");
                    }
                
            }
            System.out.println("");
        }
    }

    
    //Methoden
  
  
}
