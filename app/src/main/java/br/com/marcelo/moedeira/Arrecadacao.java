package br.com.marcelo.moedeira;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.marcelo.moedeira.API.MoedeiroService;
import br.com.marcelo.moedeira.infra.APIService;
import br.com.marcelo.moedeira.infra.Retrofitable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Arrecadacao extends AppCompatActivity implements Retrofitable, NavigationView.OnNavigationItemSelectedListener {
    TextView result, username, email;
    MoedeiroService services;
    APIService apiService;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrecadacao);

        apiService = new APIService();
        setupDrawer();
        setupViews();

    }

    @Override
    protected void onResume() {
        super.onResume();

        services = apiService.getMoedaService();
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        Call<Moeda> listCall = services.listMoeda();
                        listCall.enqueue(
                                new Callback<Moeda>() {
                                    @Override
                                    public void onResponse(Call<Moeda> call, Response<Moeda> response) {
                                        Moeda moeda = response.body();
                                        result.setText(moeda.data.get("subtotal").toString());
                                        try {
                                            onResume();
                                        }catch (Exception ex){
                                            finish();
                                        }

                                    }
                                    
                                    @Override
                                    public void onFailure(Call<Moeda> call, Throwable t) {
                                        Toast.makeText(Arrecadacao.this, t.getMessage(), Toast.LENGTH_LONG).show();
                                    }
                                }
                        );
                    }
                },
                3000);


    }


    @Override
    public void onRetrofitResponse(int status, List dados) {

    }


    @Override
    public void onRetrofitFailure(Throwable t) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        return super.onMenuOpened(featureId, menu);
    }

    private void setupDrawer() {
        toggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mNavigationView.setNavigationItemSelectedListener(this);
    }

    private void setupViews() {
        result = findViewById(R.id.result);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mNavigationView = findViewById(R.id.navigation_view);
        username = mNavigationView.getHeaderView(0).findViewById(R.id.username);
        email = mNavigationView.getHeaderView(0).findViewById(R.id.email);
    }
}
