import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
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
        int opcion1 = 0;
        int opcion2 = 0;
        int opcion3 = 0;
        boolean salir = false;

        while (!salir) {
            try {

                System.out.println(
                        "------------------Bienvenido------------------\n-----Archivos con los que desea trabajar------");
                System.out.println("1.-Empleados");
                System.out.println("2.-Areas");
                System.out.println("3.-Salir\n----------------------------------------------");

                opcion1 = sn.nextInt();
                out.writeInt(opcion1);

                switch (opcion1) {

                    case 1:
                        do {
                            System.out.println(
                                    "----------------------------------------------\n--------------Archivo empleados---------------");
                            System.out.println("1.-Agregar Empleado");
                            System.out.println("2.-Consultar Empleado");
                            System.out.println("3.-Eliminar Empleado");
                            System.out.println("4.-Modificar Empleado");
                            System.out.println("5.-Regresar\n----------------------------------------------");

                            opcion2 = sn.nextInt();
                            out.writeInt(opcion2);

                            switch (opcion2) {

                                case 1:
                                    String contratar = agregarEmpleado("nuevo");
                                    out.writeUTF(contratar);
                                    mensaje = in.readUTF();
                                    System.out.println(mensaje);

                                    break;
                                case 2:
                                    mensaje = in.readUTF();
                                    System.out.println(mensaje);
                                    leerEmpleados();

                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    mensaje = in.readUTF();
                                    System.out.println(mensaje);
                                    break;
                                default:

                                    mensaje = in.readUTF();
                                    System.out.println(mensaje);
                                    break;
                            }
                        } while (opcion2 != 5);
                        break;
                    case 2:
                        do {
                            System.out.println(
                                    "----------------------------------------------\n-----------------Archivo Area-----------------");
                            System.out.println("1.-Agregar Area");
                            System.out.println("2.-Consultar Area");
                            System.out.println("3.-Eliminar Area");
                            System.out.println("4.-Modificar Area");
                            System.out.println("5.-Regresar\n----------------------------------------------");

                            opcion3 = sn.nextInt();
                            out.writeInt(opcion3);

                            switch (opcion3) {

                                case 1:
                                    String agregar = agregarArea("nuevo");
                                    out.writeUTF(agregar);
                                    mensaje = in.readUTF();
                                    System.out.println(mensaje);
                                    break;
                                case 2:
                                    mensaje = in.readUTF();
                                    System.out.println(mensaje);
                                    leerAreas();
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    System.out.println("----------------------------------------------");
                                    break;
                                default:

                                    mensaje = in.readUTF();
                                    System.out.println(mensaje);
                                    break;
                            }
                        } while (opcion3 != 5);
                        break;
                    case 3:

                        System.out.println(
                                "----------------------------------------------\n--------------------Adios---------------------\n----------------------------------------------");
                        salir = true;

                        break;
                    default:
                        mensaje = in.readUTF();
                        System.out.println(mensaje);

                        break;

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

        System.out.println("----------------------------------------------\nNombre:");
        nombreEmpleado = sc.nextLine();
        System.out.println("Apellido Paterno:");
        apPaterno = sc.nextLine();
        System.out.println("Apellido Materno:");
        apMaterno = sc.nextLine();
        System.out.println("Matricula:");
        matricula = sc.nextInt();

        String empleado = matricula + " " + nombreEmpleado + " " + apPaterno + " " + apMaterno;

        return empleado;

    }

    public String agregarArea(String nuevaArea) {

        Scanner sc = new Scanner(System.in);
        String nombreArea;

        System.out.println("----------------------------------------------\n------Nombre de la nueva area de trabajo------");
        nombreArea = sc.nextLine();

        return nombreArea;
    }
    public void leerEmpleados(){

        try {
            FileReader empleados = new FileReader("D:/Java Workspace/Servidor2.0/empleados.txt");
            int c = empleados.read();

            while(c!=-1){

                c=empleados.read();

                char letra =(char)c;
                System.out.print(letra);
            }
            empleados.close();
        } catch (IOException e) {
           
           System.out.println("El archivo no existe");
        }


    }
    public void leerAreas(){

        try {
            FileReader area = new FileReader("D:/Java Workspace/Servidor2.0/area.txt");
            int c = area.read();

            while(c!=-1){

                c=area.read();

                char letra =(char)c;
                System.out.print(letra);
            }
            area.close();
        } catch (IOException e) {
           
           System.out.println("El archivo no existe");
        }


    }

}
