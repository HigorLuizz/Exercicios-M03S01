package br.senai.sc.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Lance implements Comparable<Lance> {
    private Usuario usuario;
    private double valor;

    public Lance(Usuario usuario, double valor){
        super();
        this.usuario = usuario;
        this.valor = valor;
    }

    @Override
    public int compareTo(Lance outro) {
        if(this.valor > outro.valor){
            return -1;
        }else if (this.valor < outro.valor){
            return 1;
        }
        return 0;
    }
}
