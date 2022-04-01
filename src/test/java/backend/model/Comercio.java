package backend.model;

public class Comercio {

    private int idComercio;
    private String nombre;
    private String direccion;
    private String localidad;
    private String telefono;
    private float calificacion;
    private String logo;
    private String descripcion;
    private String usuario;
    private String categorias;
    private float costoEnvio;
    private String horario;
    private String diasAbierto;
    private float promCalificacion;

    public Comercio() {

    }

    public int getIdComercio() {
        return idComercio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public String getLogo() {
        return logo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getCategorias() {
        return categorias;
    }

    public float getCostoEnvio() {
        return costoEnvio;
    }

    public String getHorario() {
        return horario;
    }

    public String getDiasAbierto() {
        return diasAbierto;
    }

    public float getPromCalificacion() {
        return promCalificacion;
    }
}
