package principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Clientes {
    public static Scanner s = new Scanner(System.in);
    public String nombre, direccion;
    public int num, saldo, ingresos, gastos, CP;

    public Clientes() {
    }

    public static String CLIENTES = "Clientes.txt";

    public static void menu() {
        boolean volver = true;
        while (volver) {
            System.out.println("Bienvenido, introduzca la opción que desea ejecutar: \n" +
                    "1. Mostrar una lista de clientes con saldos a cero, es decir, los clientes que no deben dinero. \n" +
                    "2. Mostrar una lista de clientes con saldos con crédito, es decir, los clientes a quienes la compañía les\n" +
                    "debe dinero. \n" +
                    "3. Mostrar una lista de clientes con saldos con débito, es decir, los clientes que deben dinero a la\n" +
                    "compañía por los bienes y servicios recibidos en el pasado. \n" +
                    "4. Generar carta de agradecimiento a los clientes Super vips. \n" +
                    "5. Generar carta de aviso a los clientes Robinson.");
            int opc = s.nextInt();
            switch (opc) {
                case 1:
                    saldos_a_cero();
                    break;
                case 2:
                    saldos_con_credito();
                    break;
                case 3:
                    saldos_con_debito();
                    break;
                case 4:
                    carta_de_agradecimiento();
                    break;
                case 5:
                    carta_de_aviso();
                    break;
                default:
                    volver = false;
                    break;
            }
        }
    }

    public static ArrayList<Clientes> lista = new ArrayList<>();

    public static void crearArray() throws IOException {
        int i = 0;
        BufferedReader entrada = null;
        Scanner sc;
        try {
            entrada = new BufferedReader(new FileReader(CLIENTES));
            String linea = entrada.readLine();
            while (linea != null) {
                lista.add(new Clientes());
                sc = new Scanner(linea);
                lista.get(i).num = s.nextInt();
                lista.get(i).nombre = s.next();
                lista.get(i).saldo = s.nextInt();
                lista.get(i).ingresos = s.nextInt();
                lista.get(i).gastos = s.nextInt();
                lista.get(i).direccion = s.next();
                lista.get(i).CP = s.nextInt();
                linea = entrada.readLine();
                i++;
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        } finally {
            entrada.close();
        }
    }

    public static void saldos_a_cero() {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).saldo==0){
                System.out.println(CLIENTES.toString());
            }
        }
        String Clientes0 = "Clientes0.txt";
    }

    public static void saldos_con_credito() {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).saldo<0) System.out.println(CLIENTES.toString());
        }
        String ClientesCredito = "ClientesCredito.txt";
    }

    public static void saldos_con_debito() {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).saldo>0) System.out.println(CLIENTES.toString());
        }
        String ClientesDebito = "ClientesDebito.txt";
    }

    public static void carta_de_agradecimiento() {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).saldo<0){
             if (lista.get(i).ingresos>3000) System.out.println("Le agradecemos su confianza "+ lista.get(i).nombre);
            }
        }
        String CartaAgradecimiento = "CartaAgradecimiento.txt";
    }

    public static void carta_de_aviso() {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).saldo<0){
                if (lista.get(i).gastos>3000) System.out.println("Le avisamos de que su saldo está en peligro "+ lista.get(i).nombre);
            }
        }
        String CartaAviso = "CartaAviso.txt";
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", num=" + num +
                ", saldo=" + saldo +
                ", ingresos=" + ingresos +
                ", gastos=" + gastos +
                ", CP=" + CP +
                '}';
    }
}
