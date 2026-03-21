package articulos;

import java.math.BigDecimal;

public class Articulo {

    private int id, cantidad;
    private String nombre, detalle;
    private BigDecimal precio;

    public Articulo(int id, int cantidad, String nombre, String detalle, BigDecimal precio) {
        this.id = id;
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.detalle = detalle;
        this.precio = precio;
    }

    public Articulo(int cantidad, String nombre, String detalle, BigDecimal precio) {
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.detalle = detalle;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Articulo{");
        sb.append("id=").append(id);
        sb.append(", cantidad=").append(cantidad);
        sb.append(", nombre=").append(nombre);
        sb.append(", detalle=").append(detalle);
        sb.append(", precio=").append(precio);
        sb.append('}');
        return sb.toString();
    }

}
