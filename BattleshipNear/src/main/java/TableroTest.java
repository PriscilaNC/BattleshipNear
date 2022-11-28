import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableroTest {

    Tablero tablero1;
    Tablero tablero2;
    Jugador j1;
    Jugador j2;

    @BeforeEach
    void setUp() {
        tablero1 = new Tablero();
        tablero2 = new Tablero();
        j1 = new Jugador("Jabin",tablero1,tablero2,true);
        j2 = new Jugador("Priscila",tablero2,tablero1,false);
    }

    @Test
    @DisplayName("Tableros iniciales iguales")
    void generarTableroVacio() {
        tablero1.generarTableroVacio();
        tablero2.generarTableroVacio();
        assertArrayEquals(j1.getTableroPropio(),j2.getTableroPropio());
    }

    @AfterEach
    void tearDown() {
        tablero1 = new Tablero();
        tablero2 = new Tablero();

        j1 = new Jugador("Jabin",tablero1,tablero2,true);
        j2 = new Jugador("Priscila",tablero2,tablero1,false);
    }
}