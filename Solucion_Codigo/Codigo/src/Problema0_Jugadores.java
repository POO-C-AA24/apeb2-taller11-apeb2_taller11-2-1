import java.util.ArrayList;
import java.util.Arrays;
public class Problema0_Jugadores {
    public static void main(String[] args) {
     ArrayList<Jugador> equipo = new ArrayList<Jugador>(Arrays.asList(new Atacante(10, 5, "Juan", 4, 7312623, 2)
     , new Portero(4, "Carlos", 1, 7273826, 0), new Defensor(20, 9, "Hincapie", 5, 7362109, 1)));   
     for(Jugador lista : equipo){
         System.out.println(lista.calcularValoracion());
     }
    }
}
abstract class Jugador {
   public String nombre;
   public int dorsal;
   public int rut;
   public int goles;
   public int valorGoles;
   public int valorJugador;
   public Jugador(String nombre, int dorsal, int rut, int goles) {
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.rut = rut;
        this.goles = goles;
    }
   public int valoracionJugador(){
       this.valorGoles = this.goles * 30;
       return this.valorGoles;
   }
   public abstract int calcularValoracion();

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", dorsal=" + dorsal + ", rut=" + rut + ", goles=" + goles + ", valorGoles=" + valorGoles + ", valorJugador=" + valorJugador + '}';
    }
}
class Atacante extends Jugador {
    public int pases;
    public int recuperaciones;
    public Atacante(int pases, int recuperaciones, String nombre, int dorsal, int rut, int goles) {
        super(nombre, dorsal, rut, goles);
        this.pases = pases;
        this.recuperaciones = recuperaciones;
    }
    @Override
    public int calcularValoracion(){
        this.valorGoles = super.valoracionJugador() + (this.pases * 2) + (this.recuperaciones * 3);
        return this.valorGoles;
    }
}
class Defensor extends Jugador{
    public int pases;
    public int recuperaciones;
    public Defensor(int pases, int recuperaciones, String nombre, int dorsal, int rut, int goles) {
        super(nombre, dorsal, rut, goles);
        this.pases = pases;
        this.recuperaciones = recuperaciones;
    }
    @Override
    public int calcularValoracion(){
        this.valorGoles = super.valoracionJugador() + this.pases + (this.recuperaciones *4);
        return this.valorGoles;
    }
}
class Portero extends Jugador{
    public int atajadas;
    public Portero(int atajadas, String nombre, int dorsal, int rut, int goles) {
        super(nombre, dorsal, rut, goles);
        this.atajadas = atajadas;
    }
    @Override
    public int calcularValoracion(){
        this.valorGoles = super.valoracionJugador() + (this.atajadas * 4);
        return valorGoles;
    }
}
