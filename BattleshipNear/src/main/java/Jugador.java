import java.util.Scanner;

//AHHHHHHHHHHHHHHHHHHHHHHHHHHHHH
public class Jugador {
    private String nombre;
    private Tablero tableroPropio;
    private Tablero tableroEnemigo;

    static Scanner teclado = new Scanner(System.in);

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public void ubicarFichas(){
        for (int i = 0; i < 13; i++) {
            int fila = 1;
            int columna = 1;

            System.out.println("Elija la fila para ubicar su ficha");
            pedirIngresarFila(fila);

            System.out.println("Elija la columna para ubicar su ficha");
            pedirIngresarColumna(columna);

            tableroPropio.ocuparCasilla(fila, columna);
        }
    }

    public int pedirIngresarFila(int fila){
        if(fila<0&&fila<10){
            fila = teclado.nextInt();
        }else{
            System.out.println("Por favor ingrese un valor valido");
            fila = teclado.nextInt();
            pedirIngresarFila(fila);
        }
        return fila;
    }

    public int pedirIngresarColumna(int columna){
        if(columna<0&&columna<10){
            columna = teclado.nextInt();
        }else{
            System.out.println("Por favor ingrese un valor valido");
            columna = teclado.nextInt();
            pedirIngresarFila(columna);
        }
        return columna;
    }
}
//ahhhhhhhhhhhhhhhhhhh
