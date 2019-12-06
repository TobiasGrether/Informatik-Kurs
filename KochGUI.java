import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 18.11.2014
  * @author 
  */

public class KochGUI extends JFrame {
  // Anfang Attribute
  private JLabel jLabel1 = new JLabel();
  private JLabel jLabel2 = new JLabel();
  private JLabel jLabel3 = new JLabel();
  private JTextField jTextField1 = new JTextField();
  private JButton jButton1 = new JButton();
  private JTextArea jTextArea1 = new JTextArea("");
  private JScrollPane jTextArea1ScrollPane = new JScrollPane(jTextArea1);
  private JButton jButton2 = new JButton();
  public Queue<String> queue;
  // Ende Attribute
  
  public KochGUI(String title) { 
    // Frame-Initialisierung
    super(title);
    queue = new Queue<String>();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 351; 
    int frameHeight = 300;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jLabel1.setBounds(88, 16, 180, 28);
    jLabel1.setText("Küchenverwaltung");
    jLabel1.setFont(new Font("Dialog", Font.BOLD, 20));
    cp.add(jLabel1);
    jLabel2.setBounds(8, 72, 164, 20);
    jLabel2.setText("aktuell zu kochendes Gericht:");
    jLabel2.setFont(new Font("Dialog", Font.PLAIN, 12));
    cp.add(jLabel2);
    jLabel3.setBounds(184, 72, 110, 20);
    jLabel3.setText("text");
    cp.add(jLabel3);
    jTextField1.setBounds(8, 224, 150, 20);
    cp.add(jTextField1);
    jButton1.setBounds(168, 224, 123, 25);
    jButton1.setText("Gericht kochen");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
    public void actionPerformed(ActionEvent evt) { 
    jButton1_ActionPerformed(evt);
    }
    });
    cp.add(jButton1);
    jTextArea1ScrollPane.setBounds(8, 104, 137, 113);
    jTextArea1.setEditable(false);
    cp.add(jTextArea1ScrollPane);
    jButton2.setBounds(184, 96, 115, 25);
    jButton2.setText("Gericht fertig");
    jButton2.setMargin(new Insets(2, 2, 2, 2));
    jButton2.addActionListener(new ActionListener() { 
    public void actionPerformed(ActionEvent evt) { 
    jButton2_ActionPerformed(evt);
    }
    });
    cp.add(jButton2);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public KochGUI
  
  // Anfang Methoden
  public void jButton1_ActionPerformed(ActionEvent evt) {
    
    queue.enqueue(jTextField1.getText());
    jTextField1.setText("");
    jLabel3.setText(queue.front());
  } // end of jButton1_ActionPerformed

  public void jButton2_ActionPerformed(ActionEvent evt) {
    
  
    queue.dequeue();
    jLabel3.setText(queue.front());
    // end of if
  } // end of jButton2_ActionPerformed

  // Ende Methoden
  
  public static void main(String[] args) {
    new KochGUI("KochGUI");
  } // end of main
  
} // end of class KochGUI
