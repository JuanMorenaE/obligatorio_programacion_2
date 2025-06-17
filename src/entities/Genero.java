package entities;

public class Genero implements Comparable<Genero> {
    private int id;
    private String nombre;
    private int visitas;


    public Genero(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.visitas = 0;
    }

    public void agregarVisita(){visitas++;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVisitas() {
        return visitas;
    }

    public void setVisitas(int visitas) {
        this.visitas = visitas;
    }

    @Override
    public int compareTo(Genero o) {
        return Integer.compare(getId(), o.getId());
    }
}
