package sg.edu.rp.c346.id19029023.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    ArrayList<Movie> movieList;
    CustomAdapter ca;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lvMovie);
        movieList = new ArrayList<>();
        Calendar date1 = Calendar.getInstance();
        date1.set(2014, 11, 15);
        Calendar date2 = Calendar.getInstance();
        date2.set(2015, 5, 15);
        Movie movie1 = new Movie("The Avengers", 2012, "pg13", " Action | Sci-Fi", date1, "Golden Village - Bishan", "Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army.");
        Movie movie2 = new Movie("Planes", 2013, "pg", " Animation | Comedy", date2, "Cathay - AMK Hub", "A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.");
        movieList.add(movie1);
        movieList.add(movie2);
        ca = new CustomAdapter(this, R.layout.row, movieList);
        lv.setAdapter(ca);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie movieSelected = movieList.get(position);

                String movieTitle = movieSelected.getTitle();
                int movieYear = movieSelected.getYear();
                String movieRating = movieSelected.getRated();
                String movieGenre = movieSelected.getGenre();
                Calendar movieWatchedOn = movieSelected.getWatched_on();
                String movieInTheatre = movieSelected.getIn_theatre();
                String movieDescription = movieSelected.getDescription();

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("Title", movieTitle);
                intent.putExtra("Year", movieYear);
                intent.putExtra("Rating", movieRating);
                intent.putExtra("Genre", movieGenre);
                String watchedOn = movieWatchedOn.get(Calendar.YEAR)+"-"+ (movieWatchedOn.get(Calendar.MONTH)+1)+"-"+movieWatchedOn.get(Calendar.DAY_OF_MONTH);//yyyy-MM-dd
                intent.putExtra("Watched On", watchedOn);
                intent.putExtra("In Theatre", movieInTheatre);
                intent.putExtra("Description", movieDescription);
                startActivity(intent);
            }
        });

    }
}
