package com.platzi.miprimeraappmaterial;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.platzi.miprimeraappmaterial.adapters.CursosAdapter;
import com.platzi.miprimeraappmaterial.models.Cursos;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "¿Dudas? cursos@platzi.com", Snackbar.LENGTH_LONG)
                        .show();
            }
        });

        setRecyclerView();
    }


    public void setRecyclerView(){

        ArrayList<Cursos>  cursos = new ArrayList<>();

        Cursos curso = new Cursos();
        curso.setTitle("React");
        curso.setDescription("Crea componentes gracias a la libreria de facebook");
        curso.setBadge("react");
        cursos.add(curso);

        Cursos curso2 = new Cursos();
        curso2.setTitle("Marketing Online");
        curso2.setDescription("Se un estratega digital");
        curso2.setBadge("marketing");
        cursos.add(curso2);

        Cursos curso3 = new Cursos();
        curso3.setTitle("Photoshop");
        curso3.setDescription("Aprende Photoshop enfocado a la web");
        curso3.setBadge("photoshop");
        cursos.add(curso3);

        Cursos curso5 = new Cursos();
        curso5.setTitle("Android");
        curso5.setDescription("Aprende a hacer aplicaciones como esta");
        curso5.setBadge("android");
        cursos.add(curso5);

        Cursos curso6 = new Cursos();
        curso6.setTitle("React");
        curso6.setDescription("Crea componentes gracias a la libreria de facebook");
        curso6.setBadge("react");
        cursos.add(curso6);

        Cursos curso7 = new Cursos();
        curso7.setTitle("Marketing Online");
        curso7.setDescription("Se un estratega digital");
        curso7.setBadge("marketing");
        cursos.add(curso7);

        Cursos curso8 = new Cursos();
        curso8.setTitle("Photoshop");
        curso8.setDescription("Aprende Photoshop enfocado a la web");
        curso8.setBadge("photoshop");
        cursos.add(curso8);

        Cursos curso9 = new Cursos();
        curso9.setTitle("Android");
        curso9.setDescription("Aprende a hacer aplicaciones como esta");
        curso9.setBadge("android");
        cursos.add(curso9);




        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.cursos);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new CursosAdapter(cursos, R.layout.row));
        recyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this).build());
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);


        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);
        View bottomSheet = coordinatorLayout.findViewById(R.id.cursos);

        final BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
