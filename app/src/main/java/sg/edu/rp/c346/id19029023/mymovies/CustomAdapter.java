package sg.edu.rp.c346.id19029023.mymovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Movie> movieList;
    public CustomAdapter(Context context, int resource, ArrayList<Movie> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        movieList = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(layout_id, parent, false);
        TextView tvName = rowView.findViewById(R.id.tvtitle);
        TextView tvYear = rowView.findViewById(R.id.tvyear);
        TextView tvGenre = rowView.findViewById(R.id.tvgenre);
        ImageView ivRating = rowView.findViewById(R.id.imageViewRating);
        Movie c = movieList.get(position);
        if (c.getRated() == "pg13"){
            ivRating.setImageResource(R.drawable.rating_pg13);
        }else if(c.getRated() == "pg"){
            ivRating.setImageResource(R.drawable.rating_pg);
        }else if(c.getRated() == "g") {
            ivRating.setImageResource(R.drawable.rating_g);
        }else if(c.getRated() == "m18") {
            ivRating.setImageResource(R.drawable.rating_m18);
        }
        else if(c.getRated() == "nc16") {
            ivRating.setImageResource(R.drawable.rating_nc16);
        }else{
            ivRating.setImageResource(R.drawable.rating_r21);
        }


        tvName.setText(c.getTitle());
        tvYear.setText(""+c.getYear());
        tvGenre.setText(""+c.getGenre());


        return rowView;
    }
}
