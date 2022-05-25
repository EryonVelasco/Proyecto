import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteHilo extends Thread {

    private DataInputStream in;
    private DataOutputStream out;

    public ClienteHilo(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {
        Scanner sn = new Scanner(System.in);

        String mensaje;
        int opcion = 0;
        boolean salir = false;

        while (!salir) {
            try {
                System.out.println("1.-Agregar Empleado");
                System.out.println("2.-Consultar Empleado");
                System.out.println("3.-Eliminar Empleado");
                System.out.println("4.-Modificar Empleado");
                System.out.println("5.-Agregar Area");
                System.out.println("6.-Consultar Areas");
                System.out.println("7.-Eliminar Area");
                System.out.println("8.-Modificar Area");

                opcion = sn.nextInt();
                out.writeInt(opcion);

                switch (opcion) {

                    case 1:
                        String contratar = agregarEmpleado("nuevo");
                        out.writeUTF(contratar);

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

                        mensaje = in.readUTF();
                        System.out.println(mensaje);
                }

            } catch (IOException ex) {
                Logger.getLogger(ClienteHilo.class.getName()).log(Level.SEVERE, null, ex);

            }

        }

    }

    public String agregarEmpleado(String contrato) {

        Scanner sc = new Scanner(System.in);
        int matricula;
        String nombreEmpleado;
        String apPaterno;
        String apMaterno;

       
        System.out.println("Nombre:");
        nombreEmpleado = sc.nextLine();
        System.out.println("Apellido Paterno:");
        apPaterno = sc.nextLine();
        System.out.println("Apellido Materno:");
        apMaterno = sc.nextLine();
        System.out.println("Matricula:");
        matricula = sc.nextInt();

        String empleado = matricula+" "+nombreEmpleado +" "+ apPaterno+" "+ apMaterno;

        return empleado;

    }

}