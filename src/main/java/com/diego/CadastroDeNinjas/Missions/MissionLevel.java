package com.diego.CadastroDeNinjas.Missions;

public enum MissionLevel {
    A("Impossível"),
    B("Difícil"),
    C("Médio"),
    D("Baixa complexidade"),
    E("Fácil");

    private String name;

    MissionLevel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
