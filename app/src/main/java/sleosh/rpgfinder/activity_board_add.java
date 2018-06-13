package sleosh.rpgfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import classes.Board;
import classes.BoardDB;

public class activity_board_add extends AppCompatActivity implements View.OnClickListener {

    Spinner state;
    Spinner city;
    Spinner neighborhood;
    AutoCompleteTextView systemAutoComplete;
    AutoCompleteTextView cenary;
    Spinner gameDay;
    AutoCompleteTextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_add);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        Button btnClick = (Button) findViewById(R.id.saveButton);
        setSupportActionBar(myToolbar);
        state = (Spinner) findViewById(R.id.StateSpinner);
        city = (Spinner) findViewById(R.id.citySpinner);
        neighborhood = (Spinner) findViewById(R.id.neighborhoodSpinner);
        systemAutoComplete = (AutoCompleteTextView) findViewById(R.id.systemAutoComplete) ;
        cenary = (AutoCompleteTextView) findViewById(R.id.cenaryAutoComplete);
        gameDay = (Spinner) findViewById(R.id.gameDaySpinner);
        name = (AutoCompleteTextView) findViewById(R.id.nameAutoComplete);
        btnClick.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_itens, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.profile:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;

            case R.id.boards:
                Intent i = new Intent(activity_board_add.this, DashboardActivity.class);
                startActivity(i);

                return true;

            case R.id.addBoard:

                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public void onClick(View v) {

        Board board = new Board(10);

        String local = state.getSelectedItem().toString() + city.getSelectedItem().toString() + neighborhood.getSelectedItem().toString();

        board.setLocal(local);

        board.setName(name.getText().toString());

        board.setSystem(systemAutoComplete.getText().toString());

        board.setScenary(cenary.getText().toString());

        board.setSessionDay(gameDay.getSelectedItem().toString());


        BoardDB boarddb = new BoardDB(this);

        boarddb.save(board);

        Intent i = new Intent(activity_board_add.this, DashboardActivity.class);
        startActivity(i);
    }
}
