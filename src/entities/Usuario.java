package entities;

import TADs.Hash.HashLinear;

public class Usuario implements Comparable<Usuario> {
    private int id;
    private HashLinear<Integer, Genero> generosVistos;

    public Usuario(int id) {
        this.id = id;
        generosVistos = new HashLinear<>(5);
    }

    public Genero getGeneroVisto(int id) {
        return generosVistos.get(id);
    }


    public void agregarGenero(Genero genero) {
        int generoId = genero.getId();
        generosVistos.add(generoId, genero);
    }

    public void agregarVisita(int generoId) {
        generosVistos.get(generoId).agregarVisita();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashLinear<Integer, Genero> getGenerosVistos() {
        return generosVistos;
    }

    public void setGenerosVistos(HashLinear<Integer, Genero> generosVistos) {
        this.generosVistos = generosVistos;
    }

    @Override
    public int compareTo(Usuario u) {
        return Integer.compare(getId(), u.getId());
    }


}
