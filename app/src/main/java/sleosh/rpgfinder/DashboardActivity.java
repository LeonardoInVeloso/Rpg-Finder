package sleosh.rpgfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;


import java.util.ArrayList;


import classes.Board;
import classes.BoardDB;
import custom.elements.BoardDashboardAdapter;

public class DashboardActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ArrayList<Board> boards;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        
        setSupportActionBar(myToolbar);

        ListView listView = (ListView) findViewById(R.id.myBoardsListView);

        BoardDB database = new BoardDB(this);

        ArrayList<String> mesasName = new ArrayList<>();

        mesasName.add("Aventureiros de Arton");
        mesasName.add("LoudWater Heroes");
        mesasName.add("Battle on Middle Earth");

        ArrayList<String> locals = new ArrayList<>();

        locals.add("Copacabana");
        locals.add("Largo do Machado");
        locals.add("Largo do Machado");

        ArrayList<Double> rating = new ArrayList<>();

        rating.add(5.0);
        rating.add(3.9);
        rating.add(2.5);

        ArrayList<String> system = new ArrayList<>();

        system.add("D&D 3.5");
        system.add("D&D 5.0");
        system.add("3DT");

        ArrayList<String> scenary = new ArrayList<>();

        scenary.add("Tormenta");
        scenary.add("Forgotten Realms");
        scenary.add("Terra Media");

        ArrayList<Integer> limitPeople = new ArrayList<>();

        limitPeople.add(10);
        limitPeople.add(5);
        limitPeople.add(8);

        ArrayList<Boolean> female = new ArrayList<>();

        female.add(false);
        female.add(true);
        female.add(false);

        ArrayList<Boolean> children = new ArrayList<>();

        children.add(true);
        children.add(true);
        children.add(false);

        ArrayList<Boolean> begginer = new ArrayList<>();

        begginer.add(true);
        begginer.add(true);
        begginer.add(false);

        ArrayList<Boolean> publicLocal = new ArrayList<>();

        publicLocal.add(true);
        publicLocal.add(true);
        publicLocal.add(false);

        ArrayList<String> sessionDays = new ArrayList<>();

        sessionDays.add("Mensalmente");
        sessionDays.add("Domingos");
        sessionDays.add("Sabados");

        ArrayList<Integer> icons = new ArrayList<>();

        icons.add(0x7f0c0001);
        icons.add(0x7f0c0005);
        icons.add(0x7f0c000a);

        for(int i = 0; i < 3; i++){
            Board a = new Board(i+1);
            a.setName(mesasName.get(i));
        //    a.setPublicLocal(publicLocal.get(i));
          //  a.setRating(rating.get(i));
            a.setLimitPeople(limitPeople.get(i));
        //    a.setBegginer(begginer.get(i));
         //   a.setChildren(children.get(i));
       //     a.setFemale(female.get(i));
            a.setScenary(scenary.get(i));
            a.setSessionDay(sessionDays.get(i));
            a.setLocal(locals.get(i));
            a.setSystem(system.get(i));
            a.setIcon(icons.get(i));
            database.save(a);
        }

        boards = database.BoardsToList();

        listView.setAdapter(new BoardDashboardAdapter(this, boards));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Board a = boards.get(position);
                Intent i = new Intent(DashboardActivity.this,BoardActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Board a = boards.get(position);
        Intent i = new Intent(DashboardActivity.this,BoardActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_itens, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent i;

        switch (item.getItemId()) {
            case R.id.search:
                i = new Intent(DashboardActivity.this, SearchActivity.class);
                startActivity(i);
                return true;

            case R.id.addBoard:

                i = new Intent(DashboardActivity.this,activity_board_add.class);
                startActivity(i);

                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

}

