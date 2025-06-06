package entities;

public class Generos implements Comparable<Generos> {
    private int id;
    private String nombre;
    private int visitas;


    public Generos(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.visitas = 0;
    }

    public int getId() {return id;}
    public String getNombre() {return nombre;}
    public int getVisitas() {return visitas;}

    public void agregarVisita(){visitas++;}

    @Override
    public int compareTo(Generos o) {
        if (id>o.id) {
            return 1;
        }
        else if (id<o.id) {
            return -1;
        }
        return 0;
    }
}
