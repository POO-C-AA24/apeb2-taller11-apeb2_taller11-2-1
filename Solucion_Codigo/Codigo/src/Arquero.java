/**
 *
 * @author Carlos Sánchez
 */
public class Arquero extends Personaje {
    double flechaImpacto, escudoMadera;
    public Arquero(double flechaImpacto, double escudoMadera, double vida, double fuerza, int puntosExperiencia) {
        super(vida, fuerza, puntosExperiencia);
        this.flechaImpacto = flechaImpacto;
        this.escudoMadera = escudoMadera;
    }
    @Override
    public double atacar(Personaje personaje) {
        return personaje.defender(fuerza + (flechaImpacto * 2));
    }
    @Override
    public double defender(double fuerza) {
        vida -= (fuerza - (escudoMadera * 0.5));
        muerto = vida <= 0;
        return vida * 0.01;
    }
}
