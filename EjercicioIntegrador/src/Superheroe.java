public class Superheroe {
    private String nombre, descripcion;
    private boolean tieneCapa;
    private int poder;

    public Superheroe(String nombre,String descripcion, boolean tieneCapa, int poder) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tieneCapa = tieneCapa;
        this.poder = poder;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isTieneCapa() {
        return tieneCapa;
    }

    public void setTieneCapa(boolean tieneCapa) {
        this.tieneCapa = tieneCapa;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    @Override
    public String toString() {
        return "Superheroe{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", tieneCapa=" + tieneCapa +
                ", poder=" + poder +
                '}';
    }
}
