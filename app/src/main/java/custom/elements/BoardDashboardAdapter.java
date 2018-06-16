package custom.elements;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import classes.Board;
import sleosh.rpgfinder.R;

/**
 * Created by 318005 on 10/05/2018.
 */

public class BoardDashboardAdapter extends BaseAdapter {

    private final Context context;
    private final List<Board> boards;

    public BoardDashboardAdapter(Context context, List<Board> boards) {
        super();
        this.context = context;
        this.boards = boards;
    }

    @Override
    public int getCount() {
        return boards.size();
    }

    @Override
    public Object getItem(int position) {
        return boards.get(position);
    }

    @Override
    public long getItemId(int position) {
        return boards.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.adapter_board_dashboard, parent, false);
        Board a = boards.get(position);
        TextView name = (TextView) view.findViewById(R.id.boardNameTextView);
        TextView local = (TextView) view.findViewById(R.id.local);
        TextView publicLocal = (TextView) view.findViewById(R.id.localTextView);
        TextView limitPeople = (TextView) view.findViewById(R.id.membersTextView);
        TextView rating = (TextView) view.findViewById(R.id.rating);
        TextView tempo = (TextView) view.findViewById(R.id.tempo);
        TextView other = (TextView) view.findViewById(R.id.othersTextView);
        TextView system = (TextView) view.findViewById(R.id.systemTextView);
        TextView days = (TextView) view.findViewById(R.id.daysTextView);
        TextView scenary = (TextView) view.findViewById(R.id.scennaryTextView);

        de.hdodenhof.circleimageview.CircleImageView img = (de.hdodenhof.circleimageview.CircleImageView) view.findViewById(R.id.boardIcon);

        String color = "#DCFC6533";
        if(a.getRating() > 4.0){
            color = "#A233E607";
        }else if (a.getRating() > 2.5){
            color = "#DC0773E6";
        }
        String others = "";
        others += (a.isBegginer())? "Iniciante;" : "";
        others += (a.isChildren())? "Crianças;" : "";
        others += (a.isFemale())? "Feminina;" : "";
        name.setText(a.getName());
        local.setText(a.getLocal());
        publicLocal.setText((a.isPublicLocal()) ? "Publico" : "Privado");
        other.setText(others);
        limitPeople.setText("7 / " + a.getLimitPeople());
        rating.setText(String.valueOf(a.getRating()));
        rating.setTextColor(Color.parseColor(color));
        system.setText(a.getSystem());
        scenary.setText(a.getScenary());
        days.setText(a.getSessionDay());
        Random r = new Random();
        int i1 = r.nextInt(4 - 1);
        if(i1 == 1){
            img.setImageResource(R.mipmap.barbarian_icom_round);
        }else if(i1 == 2){
            img.setImageResource(R.mipmap.demi_rpg_round);
        }else if(i1 == 3){
            img.setImageResource(R.mipmap.dragon_party_round);
        }else if(i1 == 4){
            img.setImageResource(R.mipmap.party_round);
        }

        img.setBorderColor(Color.parseColor(color));
        return view;
    }
}
