
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;



public class ServerThread extends Thread {
    private Socket socket;
    private Vector<ServerThread> threadList;
    private PrintWriter output;

    public ServerThread(Socket socket, Vector<ServerThread> threads) {
        this.socket = socket;
        this.threadList = threads;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader( new InputStreamReader(socket.getInputStream()));
            
            setOutput(new PrintWriter(socket.getOutputStream(),true));

            while(true) {
                String outputString = input.readLine();
                printToClients(outputString);
            }


        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    private void printToClients(String outputString) {
        for( ServerThread i: threadList) {
            i.getOutput().println(outputString);
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Vector<ServerThread> getThreadList() {
        return threadList;
    }

    public void setThreadList(Vector<ServerThread> threadList) {
        this.threadList = threadList;
    }

    public PrintWriter getOutput() {
        return output;
    }

    public void setOutput(PrintWriter output) {
        this.output = output;
    }

    
}