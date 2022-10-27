public class Juego {
    public static void main(String[] args) {
        Tablero tablero1 = new Tablero();
        Tablero tablero2 = new Tablero();

        Jugador j1 = new Jugador("Jabin",tablero1,tablero2,true);
        Jugador j2 = new Jugador("Priscila",tablero2,tablero1,false);

        tablero1.generarTableroVacio(j1);
        tablero2.generarTableroVacio(j2);

        j1.ubicarFichas();
        j2.ubicarFichas();

        partida(j1,j2);
    }

    public static void partida(Jugador j1, Jugador j2){
        while(j1.getFichasVivas() != 0 && j2.getFichasVivas() != 0){
            if (j1.getTurno()){
                j1.turno(j2);
            }else{
                j2.turno(j1);
            }
        }

        if (j2.getFichasVivas()==0){
            System.out.println(j1.getNombre() + " ha ganado");
        }
        if (j1.getFichasVivas()==0){
            System.out.println(j2.getNombre() + " ha ganado");
        }
    }
}


