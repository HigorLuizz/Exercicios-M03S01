package br.senai.sc;

import br.senai.sc.models.Avaliador;
import br.senai.sc.models.Lance;
import br.senai.sc.models.Leilao;
import br.senai.sc.models.Usuario;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Usuario usuario1 = new Usuario("Higor",25,"12345678910");
        Lance lance1 = new Lance(usuario1, 200);
        Lance lance2 = new Lance(usuario1, 300);
        Lance lance3 = new Lance(usuario1, 500);
        Date datainicio = new Date(2023,1,24);
        Date datatermino = new Date(2023,1,25);
        Leilao leilao = new Leilao(datainicio, datatermino);
        leilao.adiciona(lance2);
        leilao.adiciona(lance3);
        leilao.adiciona(lance1);
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);
        System.out.println(leiloeiro.getMaiorLance());
        System.out.println(leiloeiro.getMenorLance());
    }
}
