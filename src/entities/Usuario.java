package entities;

import TADs.Hash.HashLinear;

public class Usuario implements Comparable<Usuario> {
    private int id;
    private HashLinear<Integer, Generos> generosVistos;

    public Usuario(int id) {
        this.id = id;
        generosVistos = new HashLinear<>(5);
    }

    public int getId() {return id;}


    public Generos getGeneroVisto(int id) {

        return generosVistos.get(id);}



    public void agregarGenero(Generos genero) {
        int generoId = genero.getId();
        generosVistos.add(generoId, genero);
    }
    public void agregarVisita(int generoId) {
        generosVistos.get(generoId).agregarVisita();
    }

    @Override
    public int compareTo(Usuario u) {
        if (id>u.id) {
            return 1;
        }
        else if (id<u.id) {
            return -1;
        }
        return 0;
    }


}
