import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
    public static void main(String[] args) throws Exception {

        try {
            ServerSocket server = new ServerSocket(5000);
            Socket sc;

            System.out.println("Servidor iniciado");

            while(true){

            sc = server.accept();      
           
            DataInputStream in = new DataInputStream(sc.getInputStream());
            DataOutputStream out = new DataOutputStream(sc.getOutputStream());

            out.writeUTF("Indica tu nombre");
            String nombreCliente = in.readUTF();

            ServidorHilo hilo = new ServidorHilo(in, out, nombreCliente);
            hilo.start();
            
            System.out.println("Creada la coneccion con el cliente "+nombreCliente);
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
