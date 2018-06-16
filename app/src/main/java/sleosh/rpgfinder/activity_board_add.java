package sleosh.rpgfinder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import classes.Board;
import classes.BoardDB;

public class activity_board_add extends AppCompatActivity {

    Spinner state;
    Spinner city;
    Spinner neighborhood;
    AutoCompleteTextView systemAutoComplete;
    AutoCompleteTextView cenary;
    Spinner gameDay;
    AutoCompleteTextView name;
    Context cont = this;
    CheckBox female;
    CheckBox children;
    CheckBox beginer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_add);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
       // Button btnClick = (Button) findViewById(R.id.saveButton);
        setSupportActionBar(myToolbar);
        state = (Spinner) findViewById(R.id.StateSpinner);
        city = (Spinner) findViewById(R.id.citySpinner);
        neighborhood = (Spinner) findViewById(R.id.neighborhoodSpinner);
        systemAutoComplete = (AutoCompleteTextView) findViewById(R.id.systemAutoComplete) ;
        cenary = (AutoCompleteTextView) findViewById(R.id.cenaryAutoComplete);
        gameDay = (Spinner) findViewById(R.id.gameDaySpinner);
        name = (AutoCompleteTextView) findViewById(R.id.nameAutoComplete);
        female = (CheckBox) findViewById(R.id.womenCheckBox);
        beginer = (CheckBox) findViewById(R.id.begginersCheckBox);
        children = (CheckBox) findViewById(R.id.childrenCheckBox);

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
                i = new Intent(activity_board_add.this, SearchActivity.class);
                startActivity(i);
                return true;

            case R.id.boards:
                i = new Intent(activity_board_add.this, DashboardActivity.class);
                startActivity(i);

                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    public void but(View v) {

        Board board = new Board(10);

        String local = neighborhood.getSelectedItem().toString() + " | " + state.getSelectedItem().toString() + " - " + city.getSelectedItem().toString();

        board.setLocal(local);

        board.setName(name.getText().toString());

        board.setSystem(systemAutoComplete.getText().toString());

        board.setScenary(cenary.getText().toString());

        board.setSessionDay(gameDay.getSelectedItem().toString());

        if(beginer.isChecked()) {
            board.setBegginer(true);
        }
        if(female.isChecked()) {
            board.setFemale(true);
        }
        if(children.isChecked()) {
            board.setChildren(true);
        }

        BoardDB boarddb = new BoardDB(cont);

        boarddb.save(board);

       Intent i = new Intent(activity_board_add.this, DashboardActivity.class);
       startActivity(i);
    }

}
