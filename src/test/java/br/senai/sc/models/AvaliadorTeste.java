package br.senai.sc.models;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class AvaliadorTeste {

    @Test
    public void deveEncontrarOmaiorEmenorLance(){
        Usuario usuario1 = new Usuario("Higor",25,"12345678910");
        Lance lance1 = new Lance(usuario1, 200);
        Lance lance2 = new Lance(usuario1, 300);
        Lance lance3 = new Lance(usuario1, 500);
        Date datainicio = new Date(2023,1,24);
        Date datatermino = new Date(2023,1,25);
        Leilao leilao = new Leilao(datainicio, datatermino);
        leilao.adiciona(lance1);
        leilao.adiciona(lance2);
        leilao.adiciona(lance3);
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);
        Assert.assertEquals(500.0, leiloeiro.getMaiorLance(),0);
        Assert.assertEquals(200.0, leiloeiro.getMenorLance(),0);
    }

    @Test
    public void naoDeveAvaliarLeilaoSemLance(){
        Usuario usuario1 = new Usuario("Higor",25,"12345678910");
        Lance lance1 = new Lance(usuario1, 200);
        Lance lance2 = new Lance(usuario1, 300);
        Lance lance3 = new Lance(usuario1, 500);
        Date datainicio = new Date(2023,1,24);
        Date datatermino = new Date(2023,1,25);
        Leilao leilao = new Leilao(datainicio, datatermino);
        Avaliador leiloeiro = new Avaliador();
        Assert.assertThrows(IllegalArgumentException.class, () -> leiloeiro.avalia(leilao));
    }
    @Test
    public void deveEncontrarOsTresMaioresLances(){
        Usuario usuario1 = new Usuario("Higor",25,"12345678910");
        Lance lance1 = new Lance(usuario1, 200);
        Lance lance2 = new Lance(usuario1, 300);
        Lance lance3 = new Lance(usuario1, 500);
        Lance lance4 = new Lance(usuario1, 150);
        Lance lance5 = new Lance(usuario1, 400);
        Date datainicio = new Date(2023,1,24);
        Date datatermino = new Date(2023,1,25);
        Leilao leilao = new Leilao(datainicio, datatermino);
        leilao.adiciona(lance1);
        leilao.adiciona(lance2);
        leilao.adiciona(lance3);
        leilao.adiciona(lance4);
        leilao.adiciona(lance5);
        Avaliador leiloeiro = new Avaliador();
        List<Lance> tresMaiores = leiloeiro.getTresMaiores(leilao);
        Assert.assertEquals(tresMaiores.size(), 3);
        Assert.assertEquals(tresMaiores.get(0).getValor(), 500, 0);
        Assert.assertEquals(tresMaiores.get(1).getValor(), 400, 0);
        Assert.assertEquals(tresMaiores.get(2).getValor(), 300, 0);
    }
    @Test
    public void deveEncontrarOsTresMenoresLances(){
        Usuario usuario1 = new Usuario("Higor",25,"12345678910");
        Lance lance1 = new Lance(usuario1, 200);
        Lance lance2 = new Lance(usuario1, 300);
        Lance lance3 = new Lance(usuario1, 500);
        Lance lance4 = new Lance(usuario1, 150);
        Lance lance5 = new Lance(usuario1, 400);
        Date datainicio = new Date(2023,1,24);
        Date datatermino = new Date(2023,1,25);
        Leilao leilao = new Leilao(datainicio, datatermino);
        leilao.adiciona(lance1);
        leilao.adiciona(lance2);
        leilao.adiciona(lance3);
        leilao.adiciona(lance4);
        leilao.adiciona(lance5);
        Avaliador leiloeiro = new Avaliador();
        List<Lance> tresMenores = leiloeiro.getTresMenores(leilao);
        Assert.assertEquals(tresMenores.size(), 3);
        Assert.assertEquals(tresMenores.get(0).getValor(), 150, 0);
        Assert.assertEquals(tresMenores.get(1).getValor(), 200, 0);
        Assert.assertEquals(tresMenores.get(2).getValor(), 300, 0);
    }
    @Test
    public void naoDeveTerDoisLancesConcevutivos(){
        Usuario usuario1 = new Usuario("Higor",25,"12345678910");
        Lance lance1 = new Lance(usuario1, 200);
        Lance lance2 = new Lance(usuario1, 300);
        Lance lance3 = new Lance(usuario1, 500);
        Lance lance4 = new Lance(usuario1, 150);
        Lance lance5 = new Lance(usuario1, 400);
        Date datainicio = new Date(2023,1,24);
        Date datatermino = new Date(2023,1,25);
        Leilao leilao = new Leilao(datainicio, datatermino);
        leilao.adiciona(lance1);
        leilao.adiciona(lance2);
        leilao.adiciona(lance3);
        leilao.adiciona(lance4);
        leilao.adiciona(lance5);
        Avaliador leiloeiro = new Avaliador();

    }
    @Test
    public void umUnicoLance(){
        Usuario usuario1 = new Usuario("Higor",25,"12345678910");
        Lance lance1 = new Lance(usuario1, 200);
        Lance lance2 = new Lance(usuario1, 300);
        Lance lance3 = new Lance(usuario1, 500);
        Lance lance4 = new Lance(usuario1, 150);
        Lance lance5 = new Lance(usuario1, 400);
        Date datainicio = new Date(2023,1,24);
        Date datatermino = new Date(2023,1,25);
        Leilao leilao = new Leilao(datainicio, datatermino);
        leilao.adiciona(lance1);
        leilao.adiciona(lance2);
        leilao.adiciona(lance3);
        leilao.adiciona(lance4);
        leilao.adiciona(lance5);
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);
        Assert.assertEquals(leiloeiro.getMaiorLance(), leiloeiro.getMenorLance(), 0);

    }
}
