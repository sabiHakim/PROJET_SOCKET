
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener implements ActionListener{

    Client client;

    
    public Listener(Client clien) {
        client=clien;       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        client.send();
    }


}
