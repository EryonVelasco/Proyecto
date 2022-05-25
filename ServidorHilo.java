import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorHilo extends Thread {
    private DataInputStream in;
    private DataOutputStream out;
    private String nombreCliente;

    public ServidorHilo(DataInputStream in, DataOutputStream out, String nombreCliente) {
        this.in = in;
        this.out = out;
        this.nombreCliente = nombreCliente;
    }

    @Override
    public void run() {

        int opcion;
        File f = new File("empleados.txt");
        while (true) {

            try {
                opcion = in.readInt();
                switch (opcion) {
                    case 1:
                        String contratar = in.readUTF();
                        agregarEmpleado(f,contratar);
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    default:
                        out.writeUTF("ERROR 141: Eliga una opcion dentro del menu");

                }

            } catch (IOException ex) {
                Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);

            }

        }
    }

    public void agregarEmpleado(File f, String contratar) throws IOException{

        FileWriter fw = new FileWriter(f,true);
        fw.write("Empleado"+": "+contratar+"\r\n");
        fw.close();


 }




}
