public class Main {
    static Tablero tablero = new Tablero();
    static Jugador j1 = new Jugador("Jabin");
    static Jugador j2 = new Jugador("Priscila");
    public static void main(String[] args) {
        tablero.generarTableroVacio(j1);
        tablero.generarTableroVacio(j2);
        tablero.imprimirTablero(j1);
        System.out.println();
        tablero.imprimirTablero(j2);
    }
}
