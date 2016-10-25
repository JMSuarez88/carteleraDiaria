package finales;

/**
 * Created by Klincaja on 25/10/16.
 */
public class Mesa {
    private String nameMateria;
    private String idMateria;
    private String sede;
    private String fecha;
    private String fechaInscripcionStart;
    private String fechaInscripcionEnd;

    public Mesa(String nameMateria, String idMateria, String sede, String fecha, String fechaInscripcionStart, String fechaInscripcionEnd) {
        this.nameMateria = nameMateria;
        this.idMateria = idMateria;
        this.sede = sede;
        this.fecha = fecha;
        this.fechaInscripcionStart = fechaInscripcionStart;
        this.fechaInscripcionEnd = fechaInscripcionEnd;
    }

    @Override
    public String toString() {
        return "";
    }

    public String getFechaInscripcionStart() {
        return fechaInscripcionStart;
    }

    public void setFechaInscripcionStart(String fechaInscripcionStart) {
        this.fechaInscripcionStart = fechaInscripcionStart;
    }

    public String getNameMateria() {
        return nameMateria;
    }

    public void setNameMateria(String nameMateria) {
        this.nameMateria = nameMateria;
    }

    public String getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(String idMateria) {
        this.idMateria = idMateria;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFechaInscripcionEnd() {
        return fechaInscripcionEnd;
    }

    public void setFechaInscripcionEnd(String fechaInscripcionEnd) {
        this.fechaInscripcionEnd = fechaInscripcionEnd;
    }
}
