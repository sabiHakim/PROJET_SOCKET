import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mainclient {

    public static void main(String[] args) {
     
             JFrame client=new JFrame("Client");
             JLabel n= new JLabel("Nom");
             JTextField name= new JTextField();
             JLabel iplabel= new JLabel("Adresse ip");
            JTextField ip=new JTextField();
            JButton valider=new JButton("Valider");

             client.setLayout(null);
             client.setTitle("serveur");
             client.setSize(300,300);
             client.setLocationRelativeTo(null);
             // client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             client.setResizable(false);
             client.add(n);
             n.setBounds(50,20,100,30);
             client.add(name);
             name.setBounds(50,60,100,30);
             client.add(iplabel);
             iplabel.setBounds(50,100,100,30);
             client.add(ip);
             ip.setBounds(50,140,100,30);
             client.add(valider);
             valider.setBounds(50,170,80,50);
             
             valider.addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent e) {
                      String userInput=name.getText();
                      String host=ip.getText();
                      client.dispose();
                         try{
                      Client frame = new Client(userInput,host);

                      } catch (Exception ex) {
                       System.out.println("Exception occured in client main: " + ex.getStackTrace());
                      }
       
                }
             });
             client.setVisible(true);
            
                      
        

    
    }
}