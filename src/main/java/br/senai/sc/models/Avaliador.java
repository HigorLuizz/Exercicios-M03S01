package br.senai.sc.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class Avaliador {
    private double maiorLance = Double.NEGATIVE_INFINITY;
    private double menorLance = Double.POSITIVE_INFINITY;
    public int cont;

    public void avalia(Leilao leilao){
        List<Lance> lancesDoLeilao = leilao.getLances();
        for (Lance lance:lancesDoLeilao
             ) {
            cont ++;
            if(cont == 1){
                maiorLance = lance.getValor();
                menorLance = lance.getValor();
            }else{
                if(lance.getValor() > maiorLance){
                    maiorLance = lance.getValor();
                }else if (lance.getValor() < menorLance){
                    menorLance = lance.getValor();
                }
            }

        }

    }
    public List<Lance> getTresMaiores(Leilao leilao){
        List<Lance> lancesDoLeilao = leilao.getLances();
        Collections.sort(lancesDoLeilao);
        return lancesDoLeilao.subList(0,3);
    }
    public List<Lance> getTresMenores(Leilao leilao){
        Collections.sort(leilao.getLances());
        Collections.reverse(leilao.getLances());
        return leilao.getLances().subList(0,3);
    }
}
