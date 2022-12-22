
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JLabel;

public class ClientHandler implements Runnable {

    Client client;
    BufferedReader input;

    public ClientHandler(Client client) throws IOException {
        setclient(client);
        setInput(new BufferedReader( new InputStreamReader(getclient().getSocket().getInputStream())));

    }
    
    @Override
    public void run() {
        
            try {
                while(true) {
                     String response = getInput().readLine();
                     System.out.println(response);
                     JLabel label = new JLabel(response);
                     label.setBounds(50,getclient().getheigth(),600,25);

                     // System.out.println(getclient().getTitle());
                     getclient().add(label);
                     getclient().setheigth(getclient().getheigth()+25);
                     getclient().repaint();
                     
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    input.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
    }

    

    public BufferedReader getInput() {
        return input;
    }
    public Client getclient() {
        return client;
    }

    public void setclient(Client client) {
        this.client = client;
    }

    public void setInput(BufferedReader input) {
        this.input = input;
    }

    
    
}