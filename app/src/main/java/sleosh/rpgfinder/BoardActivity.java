package sleosh.rpgfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import classes.Board;
import classes.BoardDB;

public class BoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(myToolbar);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int value = extras.getInt("key");
            BoardDB database = new BoardDB(this);
            Board bd = database.getBoard(value);

            TextView name = (TextView) findViewById(R.id.boardNameTextView);
            TextView cenary = (TextView) findViewById(R.id.systemCenaryTextView);
            TextView local = (TextView) findViewById(R.id.locationTextView);
            TextView gameday = (TextView) findViewById(R.id.infoTextView);

            name.setText(bd.getName());
            cenary.setText(bd.getSystem()+ ", " + bd.getScenary());
            local.setText(bd.getLocal());
            gameday.setText("O grupo joga aos " + bd.getSessionDay() + ", tendo feito algumas sessões");



            //The key argument here must match that used in the other activity
        }
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
                i = new Intent(BoardActivity.this, SearchActivity.class);
                startActivity(i);
                return true;

            case R.id.addBoard:

                i = new Intent(BoardActivity.this,activity_board_add.class);
                startActivity(i);

                return true;

            case R.id.boards:
                i = new Intent(BoardActivity.this,DashboardActivity.class);
                startActivity(i);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
