package com.example.vetclinic.model.entities;

public enum TipoAnimal {
    CACHORRO("Cachorro"),
    GATO("Gato"),
    PASSARO("Pássaro"),
    REPTIL("Réptil");

    private final String descricao;

    TipoAnimal(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() { return descricao; }
}
