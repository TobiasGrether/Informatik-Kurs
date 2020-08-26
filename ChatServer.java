/**
 * Klasse ChatServer. Stellt einen Chat-Server zur Verfuegung.
 * 
 * @author Rudolf Silberberg
 * @author Sven Hees 
 * @author Hans Haase(Anpassungen an den Unterricht)
 * @version 2020-08-24
 */

public class ChatServer extends Server
{
    //Attribute
    private List<Chatter> chatterList;  //Speichert die angemeldeten Chatter

    //Konstruktor
    /**
     * Erzeugt einen neuen ChatServer
     * 
     * @param der Port, auf dem der Server arbeitet
     */
    public ChatServer(int port)
    {
        super(port);      //Ruft Konstrukter der abstrakten Elternklassee Server auf
        chatterList = new List<Chatter>();  //Erzeugt die Liste
        System.out.println("Der Server wartet an Port "+port+"!");  //LogFile auf Konsole
    }

    /**
     * Methode wird aufgerufen, wenn ein neuer Client sich beim  Server einwaehlt.
     * Erstellt einen neuen Chatter und speichert diesen in der Liste.
     * 
     * @param pClientIP, die IP des neuen Client
     * @param pClientPort, die Portnummer des neuen Client
     */
    public void processNewConnection(String pClientIP, int pClientPort) {
        //Begruessungstext entsprechend Protokoll
        //send(pClientIP, pClientPort,pMessage); 

        //Neuen Chatter anlegen und in Liste speichern

        //LogFile auf Konsole
        send(pClientIP, pClientPort, "200 Herzlich Willkommen!" + 
            "QUIT beendet die Verbindung" +
            "HELP kontextbezogene Hilfe/n" + 
            "Wahlen Sie einen Nicknamen mit/n" + "NICK <name>"
        );
        Chatter neu = new Chatter (pClientIP, pClientPort);
        chatterList.append(neu);
        //LogFile auf Konsole
        System.out.println("Der Client "+ pClientIP + ":" + pClientPort + "hat eine Verbindung aufgebaut");
    }

        

    /**
     * Methode wird aufgerufen, wenn ein Client eine Nachricht sendet.
     * Entsprechend dem Zustand des Chatters werden Methoden zur
     * Verarbeitung der Nachricht aufgerufen.
     * 
     * @param pClientIP, die IP des neuen Client
     * @param pClientPort, die Portnummer des neuen Client
     * @param pMessage, die Nachricht
     */
    @Override
    public void processMessage(String pClientIP, int pClientPort, String pMessage) {
        //Der Chatter wird anhand des Sockets aus der Liste gesucht

        //Existiert ein Chatter wird der Zustand abgefragt und die verarbeitende Methode aufgerufen
        Chatter chatter = sucheChatterByIPAndPort(pClientIP, pClientPort);
        String befehl = pMessage.substring(0, 4);
        if(chatter.getZustand() == Zustand.CHAT){
            if(befehl.equals("SEND")){
                send(chatter.getIP(), chatter.getPort(), "400 Nachricht gesendet");
                chatterList.toFirst();
                while(chatterList.hasAccess()){
                    send(chatterList.getContent().getIP(), chatterList.getContent().getPort(), chatter.getName() + ":" + pMessage.substring(5));
                    chatterList.next();
                }
            }else if(befehl.equals("QUIT")){
                send(pClientIP, pClientPort, "410 Auf Wiedersehen!");
                chatterList.toFirst();
                while(chatterList.hasAccess()){
                    send(chatterList.getContent().getIP(), chatterList.getContent().getPort(), chatter.getName() + " hat den Chat verlassen");
                    chatterList.next();
                }
                chatter.setZustand(Zustand.ANMELDUNG);
            }else if(befehl.equals("CHNG")){
                chatterList.toFirst();
                while(chatterList.hasAccess()){
                    send(chatterList.getContent().getIP(), chatterList.getContent().getPort(), chatter.getName() + " hat den Chat verlassen");
                    chatterList.next();
                }
                chatter.setName(pMessage.substring(5));
                send(chatter.getIP(), chatter.getPort(), "420 Name geändert");
            }else if(befehl.equals("HELP")){
                send(pClientIP, pClientPort, "430 Benutze CHNG, QUIT oder SEND");
            }else{
                send(pClientIP, pClientPort, "440 unültige Eingabe");
            }
        }else{
            if(befehl.equals("NICK")){
                send(chatter.getIP(), chatter.getPort(), "300 Ihr name lautet: " + pMessage.substring(5));
                chatterList.toFirst();
                while(chatterList.hasAccess()){
                    send(chatterList.getContent().getIP(), chatterList.getContent().getPort(), pMessage.substring(5) + " hat den Chat betreten");
                    chatterList.next();
                }
                chatter.setName(pMessage.substring(5));
                chatter.setZustand(Zustand.CHAT);
            }else if(befehl.equals("QUIT")){
                send(chatter.getIP(), chatter.getPort(), "320 Auf Wiedersehen");
            }else if(befehl.equals("HELP")){
                send(chatter.getIP(), chatter.getPort(), "330 Liste der möglichen Befehle: \n NICK <name> - Namensfestlegung \n QUIT - beendet die Verbindung \n HELP - Diese Liste ");
            }
        }
    }

    @Override
    public void processClosedConnection(String pClientIP, int pClientPort) {
        //muss nicht ueberschrieben werden
    }

    //Such- und Loeschmethoden

    /**
     * Sucht anhand des uebergebenen Socket (IP und Port)
     * den zugehoerigen Chatter aus der chatterList.
     * Existiert ein Chatter mit dem Socket, wird dieser zurueckgegeben,
     * sonst wird null zurueck gegeben.
     * 
     * @param pClientIP, die IP des Client
     * @param pClientPort, die Portnummer des Client
     * 
     * @return den zugehoerigen Chatter oder null
     */
    private Chatter sucheChatterByIPAndPort(String pClientIP, int pClientPort) {
        chatterList.toFirst(); 
        while (chatterList.hasAccess()) {
            Chatter chatter = chatterList.getContent();
            if (chatter.vergleicheIPAndPort(pClientIP, pClientPort)) {
                return(chatter);
            }
            chatterList.next();
        }
        return(null);
    }

    /**
     * Sucht und loescht anhand des uebergebenen Socket (IP und Port)
     * den zugehoerigen Chatter aus der chatterList.
     * Existiert ein Chatter mit dem Socket, wird dieser geloescht,
     * sonnst bleibt die Liste unveraendert.
     * 
     * @param pClientIP, die IP des Client
     * @param pClientPort, die Portnummer des Client
     */
    private void loescheChatterByIPAndPort(String pClientIP, int pClientPort) {
        chatterList.toFirst();
        while (chatterList.hasAccess()) {
            Chatter chatter = chatterList.getContent();
            if (chatter.vergleicheIPAndPort(pClientIP, pClientPort)) {
                chatterList.remove();
            }
            chatterList.next();
        }
    }

    /**
     * Sucht anhand des uebergebenen Usernamen
     * den zugehoerigen Chatter aus der chatterList.
     * Existiert ein Chatter mit dem Usernamen, wird dieser zurueckgegeben,
     * sonst wird null zurueck gegeben.
     * 
     * @param pClientIP, die IP des Client
     * @param pClientPort, die Portnummer des Client
     * 
     * @return den zugehoerigen Chatter oder null
     */
    private Chatter sucheChatterByName(String name) {
        chatterList.toFirst();
        while (chatterList.hasAccess()) {
            Chatter chatter = chatterList.getContent();
            if (chatter.vergleicheName(name)) {
                return(chatter);
            }
            chatterList.next();
        }
        return(null);
    }

    //Fuer die Verwendung auf Linux-Servern und Windows-Clients
    /*
    public void send(String pClientIP, int pClientPort, String pMessage){
    super.send(pClientIP,pClientPort,pMessage+"\r");
    }

    public void sendToAll(String pMessage) {
    super.sendToAll(pMessage+"\r");
    }
     */

    /*
     * Main-Methode zum starten ohne BlueJ
     */
    public static void main(String[] args) {
        new ChatServer(2500);
    }

}
