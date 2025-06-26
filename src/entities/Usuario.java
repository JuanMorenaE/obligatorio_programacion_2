package entities;

import TADs.Hash.HashLinear;

public class Usuario implements Comparable<Usuario> {
    private int id;
    private HashLinear<Integer, Integer> generosCalificados = new HashLinear<>(5);

    public Usuario(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashLinear<Integer, Integer> getGenerosCalificados() {
        return generosCalificados;
    }

    public void setGenerosCalificados(HashLinear<Integer, Integer> generosCalificados) {
        this.generosCalificados = generosCalificados;
    }

    @Override
    public int compareTo(Usuario u) {
        return Integer.compare(getId(), u.getId());
    }


}
