package articulos;
import articulos.Articulo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestArticulos {
    public static void main(String[] args) {
        Articulo a1 = new Articulo(1, 2, "Alfajor", "", new BigDecimal("45.90"));
        Articulo a2 = new Articulo(2, 6, "Caramelos", "", new BigDecimal("41.90"));
        List<Articulo> lista = new ArrayList<>();
        lista.add(a1);
        lista.add(a2);
        for (Articulo articulo : lista) {
            System.out.println(articulo.toString());
        }
    }
}
