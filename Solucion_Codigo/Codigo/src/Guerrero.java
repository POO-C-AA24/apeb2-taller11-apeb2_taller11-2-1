/**
 *
 * @author Carlos Sánchez
 */
public class Guerrero extends Personaje {
    double fuerzaAdicional = 20;
    public Guerrero(double vida, double fuerza, int puntosExperiencia) {
        super(vida, fuerza, puntosExperiencia);
    }
    @Override
    public double atacar(Personaje personaje) {
        return personaje.defender(fuerza + fuerzaAdicional);
    }
    @Override
    public double defender(double fuerza) {
        vida -= fuerza;
        muerto = vida <= 0;
        return vida * 0.01;
    }
}
