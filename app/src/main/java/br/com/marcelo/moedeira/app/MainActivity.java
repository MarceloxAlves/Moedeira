package br.com.marcelo.moedeira.app;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import br.com.marcelo.moedeira.Arrecadacao;
import br.com.marcelo.moedeira.R;

public class MainActivity extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener {


    private TextView username, email;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        setupDrawer();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.noticias:
                startActivity(new Intent(this, NoticiasActivity.class));
                break;
            case R.id.jogos:
                startActivity(new Intent(this, JogosActivity.class));
                break;
            case R.id.artigos:
                startActivity(new Intent(this, ArtigosActivity.class));
                break;
            case R.id.projetos:
                startActivity(new Intent(this, ProjetosActivity.class));
                break;
            case R.id.cursos:
                startActivity(new Intent(this, CursoActivity.class));
                break;
            case R.id.arrecadacao:
                startActivity(new Intent(this, Arrecadacao.class));
                break;
        }
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
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mNavigationView = findViewById(R.id.navigation_view);
        username = mNavigationView.getHeaderView(0).findViewById(R.id.username);
        email = mNavigationView.getHeaderView(0).findViewById(R.id.email);
    }

}
