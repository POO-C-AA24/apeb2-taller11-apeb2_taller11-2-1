import java.util.ArrayList;
public class Problema2_Restaurant {
    public static void main(String[] args) {
        Cuenta cuenta1 = new Cuenta("Juan Valladares");
        Carta menuCarta = new Carta("Plato a la Carta", 10, 2, 1.5, 5);
        menuCarta.calcularMenu();
        cuenta1.agregarMenu(menuCarta);
        cuenta1.calcularSubtotal();
        cuenta1.calcularTotal();
        System.out.println("Cuenta de: " + cuenta1.getNombreCliente());
        System.out.println("Menús solicitados:");
        for (Menu menu : cuenta1.getMenus()) {
            System.out.println(" - " + menu.getNombrePlato() + ": $" + menu.getValorMenu());
        }
        System.out.println("Subtotal: $" + cuenta1.getSubtotal());
        System.out.println("Valor total (incluyendo IVA): $" + cuenta1.getTotal());
        System.out.println("--------------------------------------");
        
        Cuenta cuenta2 = new Cuenta("Tatiana Peñafiel");
        Dia menuDia = new Dia("Plato del Día", 8, 1, 1);
        menuDia.calcularMenu();
        cuenta2.agregarMenu(menuDia);
        cuenta2.calcularSubtotal();
        cuenta2.calcularTotal();
        System.out.println("Cuenta de: " + cuenta2.getNombreCliente());
        System.out.println("Menús solicitados:");
        for (Menu menu : cuenta2.getMenus()) {
            System.out.println(" - " + menu.getNombrePlato() + ": $" + menu.getValorMenu());
        }
        System.out.println("Subtotal: $" + cuenta2.getSubtotal());
        System.out.println("Valor total (incluyendo IVA): $" + cuenta2.getTotal());
        System.out.println("--------------------------------------");  
        
        Cuenta cuenta3 = new Cuenta("Javier Murillo");
        Guaguas menuNinos = new Guaguas("Plato de Niños", 5, 1, 1.5);
        menuNinos.calcularMenu();
        cuenta3.agregarMenu(menuNinos);
        cuenta3.calcularSubtotal();
        cuenta3.calcularTotal();
        System.out.println("Cuenta de: " + cuenta3.getNombreCliente());
        System.out.println("Menús solicitados:");
        for (Menu menu : cuenta3.getMenus()) {
            System.out.println(" - " + menu.getNombrePlato() + ": $" + menu.getValorMenu());
        }
        System.out.println("Subtotal: $" + cuenta3.getSubtotal());
        System.out.println("Valor total (incluyendo IVA): $" + cuenta3.getTotal());
        System.out.println("--------------------------------------");;
        
        Cuenta cuenta4 = new Cuenta("Cody Cabrera");
        Economico menuEconomico = new Economico("Plato Económico", 7, 10);
        menuEconomico.calcularMenu();
        cuenta4.agregarMenu(menuEconomico);
        cuenta4.calcularSubtotal();
        cuenta4.calcularTotal();
        System.out.println("Cuenta de: " + cuenta4.getNombreCliente());
        System.out.println("Menús solicitados:");
        for (Menu menu : cuenta4.getMenus()) {
            System.out.println(" - " + menu.getNombrePlato() + ": $" + menu.getValorMenu());
        }
        System.out.println("Subtotal: $" + cuenta4.getSubtotal());
        System.out.println("Valor total (incluyendo IVA): $" + cuenta4.getTotal());
    }
}
class Cuenta {
    public String nombreCliente;
    public ArrayList<Menu> menus;
    public double subtotal;
    public double iva;
    public double total;
    public Cuenta(String nombreCliente) {
        this.nombreCliente = nombreCliente;
        this.menus = new ArrayList<>();
        this.iva = 0.12; 
    }
    public void agregarMenu(Menu menu) {
        menus.add(menu);
    }
    public double calcularSubtotal() {
        subtotal = 0;
        for (Menu menu : menus) {
            subtotal += menu.getValorMenu();
        }
        return subtotal;
    }
    public double calcularTotal() {
        total = subtotal + (subtotal * iva);
        return total;
    }
    public String getNombreCliente() {
        return nombreCliente;
    }
    public ArrayList<Menu> getMenus() {
        return menus;
    }
    public double getSubtotal() {
        return subtotal;
    }
    public double getTotal() {
        return total;
    }
}
abstract class Menu {
    public String nombrePlato;
    public double valorMenu;
    public double valorInicial;
    public Menu(String nombrePlato, double valorInicialMenu) {
        this.nombrePlato = nombrePlato;
        this.valorInicial = valorInicial;
    }
    public String getNombrePlato() {
        return nombrePlato;
    }
    public double getValorMenu() {
        return valorMenu;
    }
    public abstract void calcularMenu();
}
class Carta extends Menu {
    public double porcion;
    public double bebida;
    public double porcentaje;
    public Carta(String nombrePlato, double valorMenu, double porcion, double bebida, double porcentaje) {
        super(nombrePlato, valorMenu);
        this.porcion = porcion;
        this.bebida = bebida;
        this.porcentaje = porcentaje;
    }
    @Override
    public void calcularMenu() {
        this.valorMenu = this.valorMenu + this.porcion + this.bebida + (this.valorMenu * this.porcentaje / 100);
    }
}
class Dia extends Menu {
    public double postre;
    public double bebida;
    public Dia(String nombrePlato, double valorMenu, double postre, double bebida) {
        super(nombrePlato, valorMenu);
        this.postre = postre;
        this.bebida = bebida;
    }
    @Override
    public void calcularMenu() {
        this.valorMenu = this.valorMenu + this.postre + this.bebida;
    }
}
class Guaguas extends Menu {
    public double helado;
    public double pastel;
    public Guaguas(String nombrePlato, double valorMenu, double helado, double pastel) {
        super(nombrePlato, valorMenu);
        this.helado = helado;
        this.pastel = pastel;
    }
    @Override
    public void calcularMenu() {
        this.valorMenu = this.valorMenu + this.helado + this.pastel;
    }
}
class Economico extends Menu {
    private double descuento;
    public Economico(String nombrePlato, double valorMenu, double descuento) {
        super(nombrePlato, valorMenu);
        this.descuento = descuento;
    }
    @Override
    public void calcularMenu() {
        this.valorMenu = this.valorMenu - (valorMenu * this.descuento / 100);
    }
}