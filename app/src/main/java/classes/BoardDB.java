package classes;

/**
 * Created by 318005 on 13/06/2018.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class BoardDB extends SQLiteOpenHelper{

    public BoardDB(Context context) {

        super(context, "boards", null, '1');
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("create", "Criando tabela board..");
        db.execSQL("create table if not exists boards (id integer primary key, name text, system text, scenary text, sessionDay text, rating real, local text, publicLocal integer, sessions integer, limitPeople integer, female integer, children integer, begginer integer, active integer, summary text);");
        Log.d("sucess", "Tabela criada com sucesso");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String save(Board board){
        SQLiteDatabase db = getWritableDatabase();
        try {
            ContentValues values = new ContentValues();

            values.put("name", board.getName());
            values.put("system", board.getSystem());
            values.put("scenary", board.getScenary());
            values.put("sessionDay", board.getSessionDay());
            values.put("rating", board.getRating());
            values.put("local", board.getLocal());
            values.put("publicLocal", board.isPublicLocal());
            values.put("sessions", board.getSessions());
            values.put("limitPeople", board.getLimitPeople());
            values.put("female", board.isFemale() == true ? 1 : 0);
            values.put("children", board.isChildren() == true ? 1 : 0);
            values.put("begginer ", board.isBegginer() == true ? 1 : 0);
            values.put("active", board.isActive() == true ? 1 : 0);
//            values.put("summary", board.getSummary());

            db.insert("boards", "", values);
            return String.valueOf(board.getId());
        }
        finally {
            db.close();
        }

    }

    public String update(Board board){
        SQLiteDatabase db = getWritableDatabase();
        try {
            ContentValues values = new ContentValues();

            values.put("id", board.getId());
            values.put("name", board.getName());
            values.put("system", board.getSystem());
            values.put("scenary", board.getScenary());
            values.put("sessionDay", board.getSessionDay());
            values.put("rating", board.getRating());
            values.put("local", board.getLocal());
            values.put("publicLocal", board.isPublicLocal());
            values.put("sessions", board.getSessions());
            values.put("limitPeople", board.getLimitPeople());
            values.put("female", board.isFemale());
            values.put("children", board.isChildren());
            values.put("begginer ", board.isBegginer());
            values.put("active", board.isActive());
         //   values.put("summary", board.getSummary());

            db.update("aluno", values, "id="+board.getId(),null);
            //db.update("aluno", values, "matricula=?",new String[]{aluno.getMatricula()});
        }
        finally {
            db.close();
        }
        return String.valueOf(board.getId());
    }

    public ArrayList<Board> BoardsToList(){
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Board> boards = null;
        try {
            //Cursor c = db.query("aluno", null, null, null, null, null, null);
            //rawQuery("SELECT id, name FROM people WHERE name = ? AND id = ?", new String[] {"David", "2"});
            Cursor c = db.rawQuery("select * from boards", null);
            if(c.moveToFirst()){
                boards = new ArrayList<Board>();
                do {
                    int id = c.getInt(c.getColumnIndex("id"));
                    Board board = new Board(id);

                    board.setName(c.getString(c.getColumnIndex("name")));
                    board.setSystem(c.getString(c.getColumnIndex("system")));
                    board.setScenary(c.getString(c.getColumnIndex("scenary")));
                    board.setSessionDay(c.getString(c.getColumnIndex("sessionDay")));
                  //  board.setSummary(c.getString(c.getColumnIndex("summary")));
                    board.setRating(c.getDouble(c.getColumnIndex("rating")));
                    board.setLocal(c.getString(c.getColumnIndex("local")));
                    board.setPublicLocal(c.getInt(c.getColumnIndex("publicLocal")) == 1 ? true : false);
                    board.setLimitPeople(c.getInt(c.getColumnIndex("limitPeople")));
                    board.setSessions(c.getInt(c.getColumnIndex("sessions")));
                    board.setActive(c.getInt(c.getColumnIndex("active")) == 1 ? true : false);
                    board.setFemale(c.getInt(c.getColumnIndex("female")) == 1 ? true : false);
                    board.setChildren(c.getInt(c.getColumnIndex("children")) == 1 ? true : false);
                    board.setBegginer(c.getInt(c.getColumnIndex("begginer")) == 1 ? true : false);

                    boards.add(board);

                }while(c.moveToNext());
            }
        }
        finally {
            db.close();
        }
        return boards;
    }

}
