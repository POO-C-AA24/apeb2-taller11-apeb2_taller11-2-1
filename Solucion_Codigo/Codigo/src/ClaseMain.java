/**
 *
 * @author Carlos Sánchez
 */
public class ClaseMain {
    public static void main(String[] args) {
        Guerrero guerrero = new Guerrero(100, 200, 0);
        Mago mago = new Mago(200, 50, 0, 75);
        Arquero arquero = new Arquero(45, 75, 125, 125, 0);
        guerrero.atacar(arquero);
        mago.atacar(arquero);
        arquero.atacar(mago);
        System.out.println("Vida actual del guerrero: " + guerrero.vida);
        System.out.println("Vida actual del mago: " + mago.vida);
        System.out.println("Vida actual del arquero: " + arquero.vida);
    }
}
