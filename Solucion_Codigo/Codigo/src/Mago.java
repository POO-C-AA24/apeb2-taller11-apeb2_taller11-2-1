/**
 *
 * @author Carlos Sánchez
 */
public class Mago extends Personaje {
    double escudo;
    public Mago(double vida, double fuerza, int puntosExperiencia, double escudo) {
        super(vida, fuerza, puntosExperiencia);
        this.escudo = escudo;
    }
    @Override
    public double atacar(Personaje personaje) {
        return personaje.defender(fuerza);
    }
    @Override
    public double defender(double fuerza) {
        vida -= (fuerza - escudo);
        muerto = vida <= 0;
        return vida * 0.01;
    }
}
