public class Tablero {
    private String[][] tablero;
    private String vacio = "[ ]";
    private String ocupado = "[*]";
    private int dimension = 10;

    public void generarTableroVacio(Jugador jugador) {
        //Genera un tablero vacio
        tablero = new String[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                tablero[i][j] = vacio;
            }
        }
//Estos 2 for generan el contorno del tablero
        char[] letras = {'0','a','b','c','d','e','f','g','h','i'};
        for (int i = 0; i < dimension; i++) {
            tablero[i][0] = " " + letras[i];
        }
        for (int j = 0; j < dimension; j++) {
            tablero[0][j] = " " + j;
        }
    }

    public void imprimirTablero(Jugador jugador) {
        //Muestra el tablero
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.print(tablero[i][j] + "\t");     //tiene que ser print no println
            }
            System.out.println("\n");
        }
    }

    public boolean isDisponible(int fila, int columna){
        if (tablero[fila][columna].equals(vacio)){
            System.out.println("Casilla libre");
            return true;
        }else{
            System.out.println("Casilla ocupada");
            return false;
        }
    }

    public void ocuparCasilla(int fila, int columna){
        if (isDisponible(fila, columna)){
            tablero[fila][columna] = ocupado;
        }else{
            System.out.println("La casilla no estaba disponible");
        }
    }

    public void vaciarCasilla(int fila, int columna){
        if (isDisponible(fila, columna)==false){
            tablero[fila][columna] = vacio;
        }else{
            System.out.println("La casilla no estaba ocupada");
        }
    }
}
