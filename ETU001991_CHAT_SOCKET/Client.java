
import java.io.PrintWriter;
import java.net.Socket;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Client extends JFrame{
    
    String name;
    Socket socket;
    int heigth;
    PrintWriter output;
    JTextField text;
    JButton envoyer;
    ImageIcon img;


    public Client(String name, String host)throws Exception{

        setSocket(new Socket(host,1234));
        setName(name);
        setTitle(getName());
        setOutput(new PrintWriter(socket.getOutputStream(),true));

        ClientHandler clientRun = new ClientHandler(this);
        new Thread(clientRun).start();
        setResizable(false);
        setSize(700,500);
        setLayout(null);
        setheigth(25);

        setText(new JTextField());
        getText().setBounds(500,30, 300, 40);
        this.add(getText());
         
        setEnvoyer(new JButton("Envoyer"));
        getEnvoyer().setBounds(500, 80, 100, 40);
        getEnvoyer().addActionListener(new Listener(this));
        this.add(getEnvoyer());    
        setVisible(true);
        getOutput().println(getName()+" join the discuss");
    }

    public int getheigth() {
        return heigth;
    }

    public void setheigth(int heigth) {
        this.heigth = heigth;
    }

    public JTextField getText() {
        return text;
    }

    public void setText(JTextField text) {
        this.text = text;
    }

    public JButton getEnvoyer() {
        return envoyer;
    }

    public void setEnvoyer(JButton envoyer) {
        this.envoyer = envoyer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }    

    
    public PrintWriter getOutput() {
        return output;
    }

    public void setOutput(PrintWriter output) {
        this.output = output;
    }
    
    public void send(){
        String message = (getName()+ " : " );
        message = message + this.getText().getText();
        getOutput().println(message);
        getText().setText("");
    }

}

