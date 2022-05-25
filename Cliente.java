import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws Exception {
        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");

        try {
            Socket sc = new Socket("127.0.0.1", 5000);

            DataInputStream in = new DataInputStream(sc.getInputStream());
            DataOutputStream out = new DataOutputStream(sc.getOutputStream());

            String mensaje = in.readUTF();
            System.out.println(mensaje);
            
            String nombre = sn.next();
            out.writeUTF(nombre);

            ClienteHilo hilo = new ClienteHilo(in, out);
            hilo.start();
            hilo.join();

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
