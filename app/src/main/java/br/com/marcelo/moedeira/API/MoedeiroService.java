package br.com.marcelo.moedeira.API;

import java.util.List;

import br.com.marcelo.moedeira.model.Moeda;
import br.com.marcelo.moedeira.model.Noticia;
import br.com.marcelo.moedeira.model.Service;
import retrofit2.Call;
import retrofit2.http.GET;

@EndPoint
public interface MoedeiroService {

    @GET("rest.php?class=JogosArcadeService&method=subtotal")
    Call<Moeda> listMoeda();

    /*** NOTICIA ***/
    @GET("rest.php?class=NoticiaService&method=getNoticias")
    Call<Service> getNoticias();


    /*** PROJETOS ***/
    @GET("rest.php?class=ProjetoService&method=getProjetos")
    Call<Service> getProjetos();


    /*** JOGOS ***/
    @GET("rest.php?class=JogosArcadeService&method=getJogos")
    Call<Service> getJogos();

    /*** JOGOS ***/
    @GET("rest.php?class=CursoService&method=getCursos")
    Call<Service> getCursos();
}
