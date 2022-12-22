
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import javax.swing.*; 


public class MainServer extends JFrame{
      static  Vector<ServerThread> threadList = new Vector<>();
      ServerSocket serversocket ;
      public MainServer() throws Exception{
        serversocket= new ServerSocket(1234);
      }
      public void start(){
        try{
            System.out.println(" serveur demarer");
           
            while(!serversocket.isClosed()) {       
            Socket socket = serversocket.accept();
            System.out.println("Demarrer");
            ServerThread serverThread = new ServerThread(socket,threadList);
            threadList.add(serverThread); 
            serverThread.start();

            }
        } catch (Exception e) {
            System.out.println( e.getStackTrace());
        }
      }
        
    


    public static void main(String[] args) throws Exception{
        MainServer server=new MainServer();
        server.start();
    }
 

      
}