package models;

public class Menu {

    public static void main(String[] args){
        // Menu de ejecucion de java para comprobar lo que voy construyendo
        // Polimorfismo

        FormaPago efectivo = new Efectivo(100);
        System.out.println(efectivo.getImporte());
    }
}
