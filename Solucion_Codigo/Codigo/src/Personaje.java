/**
 *
 * @author Carlos Sánchez
 */
public abstract class Personaje {
    double vida, fuerza;
    int puntosExperiencia;
    boolean muerto = false;
    public Personaje(double vida, double fuerza, int puntosExperiencia) {
        this.vida = vida;
        this.fuerza = fuerza;
        this.puntosExperiencia = puntosExperiencia;
    }
    public abstract double atacar(Personaje personaje);
    public abstract double defender(double fuerza);
}
