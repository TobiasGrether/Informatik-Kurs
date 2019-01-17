import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 15.01.2019
 * @author ÄNDERN
 */

public class JFrameHausaufgabe_Zusatzaufgabe extends JFrame {
  // Anfang Attribute
  private JNumberField ZahlEins = new JNumberField();
  private JNumberField ZahlZwei = new JNumberField();
  private JLabel lErsteZahl = new JLabel();
  private JLabel IZahl2 = new JLabel();
  private JButton bAusrechnen = new JButton();
  private JLabel Loesung = new JLabel();
  // Ende Attribute
  
  public JFrameHausaufgabe_Zusatzaufgabe() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 456; 
    int frameHeight = 341;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("JFrameHausaufgabe");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    ZahlEins.setBounds(168, 88, 91, 20);
    ZahlEins.setText("");
    cp.add(ZahlEins);
    ZahlZwei.setBounds(168, 152, 91, 20);
    ZahlZwei.setText("");
    cp.add(ZahlZwei);
    lErsteZahl.setBounds(168, 64, 110, 20);
    lErsteZahl.setText("Erste Zahl");
    cp.add(lErsteZahl);
    IZahl2.setBounds(168, 128, 110, 20);
    IZahl2.setText("Zweite Zahl");
    cp.add(IZahl2);
    bAusrechnen.setBounds(160, 200, 107, 25);
    bAusrechnen.setText("Ausrechnen");
    bAusrechnen.setMargin(new Insets(2, 2, 2, 2));
    bAusrechnen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bAusrechnen_ActionPerformed(evt);
      }
    });
    cp.add(bAusrechnen);
    Loesung.setBounds(160, 240, 110, 20);
    Loesung.setText("");
    Loesung.setVisible(false);
    cp.add(Loesung);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public JFrameHausaufgabe
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new JFrameHausaufgabe();
  } // end of main
  
  public void bAusrechnen_ActionPerformed( ActionEvent evt ) {
      /**
     * Zur erklärung was dieses merkwürdige try{
     *  macht:
     *  Try versucht den code auszuführen, und mit }catch() kann man Fehler, die
     *  im Programm entstehen, "auffangen", sodass das Programm normal weiterläuft und nicht abstürzt.
     *  Diesen Kommentar bitte nach dem lesen entfernen :)
     */
    try{
      
      int eins = ZahlEins.getInt( );
      int zwei = ZahlZwei.getInt( );
      if(eins != 0 && zwei != 0){
        if(eins > 2 && zwei > 2){
          
          Loesung.setVisible( true );
          Loesung.setText( "Die Lösung ist: " + new ggT( ) . ggTEuklid ( eins, zwei ) );
        }else{
          System.out.println("Ein Fehler ist / wäre aufgetreten!");
          return;
        }
      }else{
        
        System.out.println("Ein Fehler ist / wäre aufgetreten!");
        return;
      }
      
    }catch(NumberFormatException e){
      System.out.println("String statt integer angegeben!");
      return;
    } // end of bAusrechnen_ActionPerformed
    
    // Ende Methoden
  }
} // end of class JFrameHausaufgabe

