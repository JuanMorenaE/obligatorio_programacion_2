package entities;

public class Generos {
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

}
