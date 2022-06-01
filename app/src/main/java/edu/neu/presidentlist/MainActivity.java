package edu.neu.presidentlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "President App";
    Button btn_addOne;
    List<President> presidentList = new ArrayList<>();

    private RecyclerView recyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillPresidentList();
        Log.d(TAG, "onCreate: " + presidentList.toString());
        Toast.makeText(this, "Presidents count = " + presidentList.size(), Toast.LENGTH_LONG).show();
        btn_addOne = findViewById(R.id.btn_addOne);

        btn_addOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddEditOne.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.lv_presidentList);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        myAdapter = new RecycleViewAdapter(presidentList, this);
        recyclerView.setAdapter(myAdapter);
    }

    private void fillPresidentList() {
        President p0 = new President(0, "George Washington", 1788, "https://upload.wikimedia.org/wikipedia/commons/b/b6/Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg");
        President p1 = new President(1, "John Adams", 1796, "https://upload.wikimedia.org/wikipedia/commons/c/cb/John_Trumbull_-_John_Adams_-_Google_Art_Project.jpg");
        President p2 = new President(2, "Thomas_Jefferson", 1800, "https://upload.wikimedia.org/wikipedia/commons/b/b1/Official_Presidential_portrait_of_Thomas_Jefferson_%28by_Rembrandt_Peale%2C_1800%29%28cropped%29.jpg");
        President p3 = new President(3, "James_Madison", 1860, "https://upload.wikimedia.org/wikipedia/commons/1/1d/James_Madison.jpg");
        President p4 = new President(4, "James_Monroe", 1796, "https://upload.wikimedia.org/wikipedia/commons/9/95/James_Monroe_White_House_portrait_1819.gif");
        President p5 = new President(5, "Trump", 1796, "https://static.independent.co.uk/2022/05/29/00/GettyImages-1399664376.jpg?quality=75&width=990&auto=webp&crop=982:726,smart");
        President p6 = new President(6, "Andrew_Jackson", 1796, "https://upload.wikimedia.org/wikipedia/commons/d/d8/Andrew_Jackson_Daguerrotype-crop.jpg");
        President p7 = new President(7, "Martin Van Buren", 1796, "https://upload.wikimedia.org/wikipedia/commons/1/1a/Martin_Van_Buren.jpg");
        President p8 = new President(8, "Henry_Harrison", 1796, "https://upload.wikimedia.org/wikipedia/commons/c/c5/William_Henry_Harrison_daguerreotype_edit.jpg");
        President p9 = new President(9, "John_Tyler", 1796, "https://upload.wikimedia.org/wikipedia/commons/a/ab/John_Tyler_%28cropped_3x4%29.png");

        presidentList.addAll(Arrays.asList(new President[]{p0, p1, p2, p3, p4, p5, p6, p7, p8, p9}));


    }
}