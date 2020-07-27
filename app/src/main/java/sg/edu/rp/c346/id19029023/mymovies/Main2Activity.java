package sg.edu.rp.c346.id19029023.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
TextView name, genre, year, description, watchOn, inTheatre;
ImageView rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name = findViewById(R.id.tvtitle);
        rating = findViewById(R.id.imageViewRating);
        genre = findViewById(R.id.tvgenre);
        year = findViewById(R.id.tvyear);
        description = findViewById(R.id.tvDescription);
        watchOn = findViewById(R.id.tvWatchOn);
        inTheatre = findViewById(R.id.tvInTheatre);
        Intent intentReceived = getIntent();
        String mname = intentReceived.getStringExtra("Title");
        String myear = intentReceived.getStringExtra("Year");
        String mrating = intentReceived.getStringExtra("Rating");
        String mgenre = intentReceived.getStringExtra("Genre");
        String mnwatched = intentReceived.getStringExtra("Watched On");
        String mtheatre = intentReceived.getStringExtra("In Theatre");
        String mdescription = intentReceived.getStringExtra("Description");
        name.setText(mname);
        genre.setText(mgenre);
        year.setText(myear);
        description.setText(mdescription);
        watchOn.setText(mnwatched);
        inTheatre.setText(mtheatre);
        if (mrating == "pg13"){
            rating.setImageResource(R.drawable.rating_pg13);
        }else if(mrating == "pg"){
            rating.setImageResource(R.drawable.rating_pg);
        }else if(mrating == "g") {
            rating.setImageResource(R.drawable.rating_g);
        }else if(mrating == "m18") {
            rating.setImageResource(R.drawable.rating_m18);
        }
        else if(mrating == "nc16") {
            rating.setImageResource(R.drawable.rating_nc16);
        }else{
            rating.setImageResource(R.drawable.rating_r21);
        }
    }
}
