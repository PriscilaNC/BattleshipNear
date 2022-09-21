import java.util.Scanner;

public class Jugador {
    private String nombre;
    private int fichasVivas = 14;
    private Tablero tableroPropio;
    private Tablero tableroEnemigo;
    private Boolean turno;

    static Scanner teclado = new Scanner(System.in);

    public Jugador(String nombre, Tablero tableroPropio, Tablero tableroEnemigo, Boolean turno) {
        this.nombre = nombre;
        this.tableroPropio = tableroPropio;
        this.tableroEnemigo = tableroEnemigo;
        this.turno = turno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setTurno(Boolean turno) {
        this.turno = turno;
    }

    public Boolean getTurno() {
        return turno;
    }

    public int getFichasVivas() {
        return fichasVivas;
    }

    public void ubicarFichas(){
        int fichasRestantes = 14;

        while (fichasRestantes != 0) {
            System.out.println("Ingrese una fila para ubicar su ficha");
            int fila = pedirIngresarFila();

            System.out.println("Ingrese una columna para ubicar su ficha");
            int columna = pedirIngresarColumna();

            if (tableroPropio.ocuparCasilla(fila, columna)) {
                fichasRestantes--;
            }
            tableroPropio.imprimirTablero();
        }
    }

    public int pedirIngresarFila(){
        int fila = teclado.nextInt();
        if(fila>0&&fila<10){
            return fila;
        }else{
            System.out.println("Por favor ingrese un valor valido");
            fila = teclado.nextInt();
            pedirIngresarFila();
        }
        return fila;
    }

    public int pedirIngresarColumna(){
        int columna = teclado.nextInt();
        if(columna>0&&columna<10){
            return columna;
        }else{
            System.out.println("Por favor ingrese un valor valido");
            columna = teclado.nextInt();
            pedirIngresarFila();
        }
        return columna;
    }

    public void quitarFicha(Jugador enemigo){
        enemigo.fichasVivas--;
    }

    public void atacar(int fila, int columna, Jugador enemegio){
        if(tableroEnemigo.esDisponible(fila, columna)==false){
            System.out.println("Boom");
            quitarFicha(enemegio);
            atacar(fila, columna, enemegio);
        }else{
            System.out.println("Ataque fallido");
            setTurno(false);
        }
    }

    public void turno(Jugador enemigo){
        setTurno(true);
        System.out.println("Se necesita fila y columna para atacar");
        atacar(pedirIngresarFila(), pedirIngresarColumna(), enemigo);
        this.setTurno(false);
        enemigo.setTurno(true);
    }
}

