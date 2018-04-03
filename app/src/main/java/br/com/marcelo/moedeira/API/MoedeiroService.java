package br.com.marcelo.moedeira.API;

import br.com.marcelo.moedeira.model.Moeda;
import br.com.marcelo.moedeira.services.ServiceNoticia;
import br.com.marcelo.moedeira.services.ServiceProjeto;
import retrofit2.Call;
import retrofit2.http.GET;

@EndPoint
public interface MoedeiroService {

    @GET("rest.php?class=JogosArcadeService&method=subtotal")
    Call<Moeda> listMoeda();

    /*** NOTICIA ***/
    @GET("rest.php?class=NoticiaService&method=getNoticias")
    Call<ServiceNoticia> getNoticias();


    /*** PROJETOS ***/
    @GET("rest.php?class=ProjetoService&method=getProjetos")
    Call<ServiceProjeto> getProjetos();


    /*** JOGOS ***/
    @GET("rest.php?class=JogosArcadeService&method=getJogos")
    Call<ServiceNoticia> getJogos();

    /*** JOGOS ***/
    @GET("rest.php?class=CursoService&method=getCursos")
    Call<ServiceNoticia> getCursos();
}
