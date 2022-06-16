import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        boolean salir = false;
        Scanner sc = new Scanner(System.in);
        Plane F18 = null;

        final String rutaArchivo = "data/plane.dat";
        FileInputStream fileInput = null;
        BufferedInputStream bufferedInput = null;
        ObjectInputStream objectInput = null;

        try {
            fileInput = new FileInputStream(rutaArchivo);
            bufferedInput = new BufferedInputStream(fileInput);
            objectInput = new ObjectInputStream(bufferedInput);

            try {
                F18 = (Plane) objectInput.readObject();
                System.out.println("El archivo de guardado se ha cargado correctamente");
            } catch (IOException e) {
                System.out.println("Error de E/S");
            } catch (ClassNotFoundException e) {
                System.out.println("Error de lectura del archivo de guardado");
            }

        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra el archivo");
        } catch (IOException e) {
            System.out.println("Error de E/S");
        }

        FileOutputStream fileOutput = null;
        BufferedOutputStream bufferedOutput = null;
        ObjectOutputStream objectOutput = null;

        while (salir == false) {
            System.out.println("");
            System.out.println("1 - Inicializar F18");
            System.out.println("2 - Alternar estado de los flaps");
            System.out.println("3 - Alternar estado del tren de aterrizaje");
            System.out.println("4 - Armar sistema de eyección");
            System.out.println("5 - Eyectar piloto");
            System.out.println("Q - Salir");
            System.out.print("Selecciona una opción: ");
            System.out.println("");
            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Introduzca el número de litros de combustible cargados: ");
                    float litrosCombustible = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Introduzca el apodo del piloto: ");
                    String nombrePiloto = sc.nextLine();

                    System.out.print("Introduzca el número de escuadrón: ");
                    String numeroEscuadron = sc.nextLine();

                    F18 = new Plane(litrosCombustible, nombrePiloto, numeroEscuadron);

                    F18.toggleFlaps();
                    F18.toggleFlaps();
                    F18.toggleLandingGear();
                    F18.toggleLandingGear();
                    F18.setSeatOccupation(true);

                    System.out.println("Se ha creado un F-18. Su estado actual es:");
                    System.out.println(F18);
                    break;

                case "2":
                    try {
                        if (F18.isFlaps()) {
                            System.out.println("Cambiando el estado de los flaps a abajo");
                        } else {
                            System.out.println("Cambiando el estado de los flaps a arriba");
                        }
                        F18.toggleFlaps();
                        System.out.println(F18);

                    } catch (NullPointerException e) {
                        System.out.println("No se ha creado ningún avión, debe crear uno para usar el programa");
                    }
                    break;

                case "3":
                    try {
                        if (F18.isLandingGear()) {
                            System.out.println("Cambiando el estado del tren de aterrizaje a arriba");
                        } else {
                            System.out.println("Cambiando el estado del tren de aterrizaje a abajo");
                        }
                        F18.toggleLandingGear();
                        System.out.println(F18);

                    } catch (NullPointerException e) {
                        System.out.println("No se ha creado ningún avión, debe crear uno para usar el programa");
                    }
                    break;

                case "4":
                    try {
                        if (F18.isEjectionSystem()) {
                            System.out.println("Cambiando el sistema de eyección a armado");
                        } else {
                            System.out.println("Cambiando el sistema de eyección a desarmado");
                        }
                        F18.ejectionSystem();
                        System.out.println(F18);

                    } catch (NullPointerException e) {
                        System.out.println("No se ha creado ningún avión, debe crear uno para usar el programa");
                    }
                    break;

                case "5":
                    try {
                        if (F18.isEjectionSystem()) {
                            F18.setSeatOccupation(false);
                            System.out.println("El piloto ha sido eyectado de manera satisfactoria");
                        } else {
                            System.out.println("AVISO: Para eyectar a el piloto el sistema de eyección debe estar armado");
                        }
                        System.out.println(F18);

                    } catch (NullPointerException e) {
                        System.out.println("No se ha creado ningún avión, debe crear uno para usar el programa");
                    }
                    break;

                case "Q":
                    System.out.println("Saliendo del programa...");
                    try {
                        fileOutput = new FileOutputStream(rutaArchivo);
                        bufferedOutput = new BufferedOutputStream(fileOutput);
                        objectOutput = new ObjectOutputStream(bufferedOutput);

                        objectOutput.writeObject(F18);

                    } catch (FileNotFoundException e) {
                        System.out.println("La ruta indica para el archivo no existe");
                    } catch (IOException e) {
                        System.out.println("Se ha producido un error de E/S");
                    } finally {
                        try {
                            if (objectOutput != null) objectOutput.close();
                            if (bufferedOutput != null) objectOutput.close();
                            if (fileOutput != null) objectOutput.close();
                        } catch (IOException e) {
                            System.out.println("Error: No se ha podido cerrar el archivo");
                        }
                    }

                    salir = true;
                    break;

                default:
                    System.out.println("Por favor, seleccione una opción válida");
                    break;
            }
        }
    }
}