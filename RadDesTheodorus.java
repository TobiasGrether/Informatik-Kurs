import java.lang.Math;
class RadDesTheodorus{
    /*
    Pseudo-Code
    funktion rechne(double hypo, int zahl)
        FALLS zahl == ende
            RÜCKGABE hypo
        SONST
            RÜCKGABE rechne(Wurzel aus hypo zum Quadrat plus eins, zahl plus eins)
    ENDE
     */
    static double calc(double hyp, int zahl){
        if(zahl == end) return hyp;
        return calc(((Math.sqrt(hyp) * Math.sqrt(hyp)) + 1), zahl+1);
    }
}
