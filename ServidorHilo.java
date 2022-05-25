import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorHilo extends Thread {
    private Socket sc;
    private DataInputStream in;
    private DataOutputStream out;
    private String nombreCliente;

    public ServidorHilo(Socket sc, DataInputStream in, DataOutputStream out, String nombreCliente) {
        this.sc = sc;
        this.in = in;
        this.out = out;
        this.nombreCliente = nombreCliente;
    }

    @Override
    public void run() {

        int opcion1;
        int opcion2;
        int opcion3;
        File f = new File("empleados.txt");
        File j = new File("area.txt");
        boolean salir = false;
        while (!salir) {

            try {

                opcion1 = in.readInt();
                switch (opcion1) {
                    case 1:
                        do {
                            opcion2 = in.readInt();
                            switch (opcion2) {
                                case 1:
                                    String contratar = in.readUTF();
                                    agregarEmpleado(f, contratar);
                                    out.writeUTF(
                                            "----------------------------------------------\n--Datos del empleado guardados correctamente--");
                                    break;
                                case 2:
                                out.writeUTF(
                                "----------------------------------------------\n---------Descargando base de datos...---------");
                                

                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    out.writeUTF("----------------------------------------------");
                                    break;

                                default:
                                    out.writeUTF(
                                            "----------------------------------------------\n--ERROR 141: Eliga una opcion dentro del menu-");
                                    break;
                            }
                        } while (opcion2 != 5);

                        break;
                    case 2:
                        do {
                            opcion3 = in.readInt();
                            switch (opcion3) {
                                case 1:
                                    String agregar = in.readUTF();
                                    agregarArea(j, agregar);
                                    out.writeUTF(
                                            "----------------------------------------------\n-----------Area creada correctamente----------");
                                    break;
                                case 2:
                                out.writeUTF(
                                    "----------------------------------------------\n---------Descargando base de datos...---------");
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    out.writeUTF("----------------------------------------------");
                                    break;

                                default:
                                    out.writeUTF(
                                            "----------------------------------------------\n--ERROR 141: Eliga una opcion dentro del menu-");
                                    break;
                            }
                        } while (opcion3 != 5);
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        out.writeUTF(
                                "----------------------------------------------\n--ERROR 141: Eliga una opcion dentro del menu-");

                }

            } catch (IOException ex) {
                Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);

            }

        }
        try {
            sc.close();
        } catch (IOException ex) {
            Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Conexion cerrada con el cliente " + nombreCliente);
    }

    public void agregarEmpleado(File f, String contratar) throws IOException {

        FileWriter fw = new FileWriter(f, true);
        fw.write("Empleado" + ": " + contratar + "\r\n");
        fw.close();
    }

    public void agregarArea(File j, String agregar) throws IOException {

        FileWriter fw = new FileWriter(j, true);
        fw.write("Area" + ": " + agregar + "\r\n");
        fw.close();

    }

    
  
}
