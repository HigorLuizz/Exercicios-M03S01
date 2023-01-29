package br.senai.sc.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Leilao {
    private Date dataInicio;
    private Date dataTermino;
    private List<Lance> lances;

    public Leilao(Date dataInicio, Date dataTermino){
        super();
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.lances = new ArrayList<>();
    }

    public void adiciona(Lance lance){
        this.lances.add(lance);

    }
    public void remove(Lance lance){
        this.lances.remove(lance);

    }

}
