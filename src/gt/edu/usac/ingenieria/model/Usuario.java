package gt.edu.usac.ingenieria.model;

public class Usuario {
    private final String nombre;
    private final String apellido;
    private final int carnet;

    public Usuario(String nombre, String apellido, int carnet) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getCarnet() {
        return carnet;
    }
}
