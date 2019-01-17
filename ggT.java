
/**
 * Klasse zur Berechnung verschiedener Faktoren
 * 
 * @author NAME EINTRAGEN
 * @version (eine Versionsnummer oder ein Datum)
 */
public class ggT
{
    public int ggTEuklid ( int a, int b ) {
        int rest = 1000;
        while ( rest > 0 ) {
            if ( b > 0 ) {
                rest = a % b;
                a = b;
                b = rest;
            } else {
                break;
            }
        }
        return a;
    }
    public int kgV ( int a, int b ) {
        int wert = ( a * b ) / ggTEuklid( a, b );
        return wert;
    }
    public boolean istPrim ( int a ) {
        for( int i = 2; i < a; i++ ) {
            if( a % i == 0 ) {
                return false;
            }
            
        }
        return true;
    }
    public String teilermenge ( int a ){
        String ergebnis = "Die Lösungen: {1";
        for( int i = 2; i <= a; i++ ) {
            if ( a % i == 0 ) {
                ergebnis += ", " + i + "";
            }
        }
        ergebnis = ergebnis + "}";
        System.out.println( ergebnis );
        return ergebnis;
    }
}
