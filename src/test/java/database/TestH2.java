
package database;

import articulos.Articulo;
import java.math.BigDecimal;
import usuarios.Usuario;

public class TestH2 {
    
    public static void main(String[] args) {
        //ConexionH2Test c = new ConexionH2Test();
        ConexionH2 c = new ConexionH2();
        c.initDB();
        c.seedDB();
        int ret;
        ret = c.agregarArticulo(new Articulo(78, "Galletitas", "Criollitas", new BigDecimal("0.78")));
        System.out.println("Agregado: " + ret);
        //duplicado
        //ret = c.agregarArticulo(new Articulo(78, "Galletitas", "Criollitas", new BigDecimal("0.78")));
        //System.out.println("Agregado: " + ret);
        ret = c.agregarArticulo(new Articulo(78, "Galletitas Dulces", "Criollitas", new BigDecimal("1.78")));
        System.out.println("Agregado: " + ret);
        c.readDB();
    }
}
