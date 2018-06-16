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

        boards = database.BoardsToList();

        listView.setAdapter(new BoardDashboardAdapter(this, boards));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Board a = boards.get(position);
                int value = a.getId();
                Intent i = new Intent(DashboardActivity.this,BoardActivity.class);
                i.putExtra("key",value);
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

