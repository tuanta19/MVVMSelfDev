package com.tuantran.mvvm_selfdev;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tuantran.mvvm_selfdev.adapters.RecyclerViewAdapter;
import com.tuantran.mvvm_selfdev.models.NicePlace;
import com.tuantran.mvvm_selfdev.viewmodels.NicePlaceViewModel;

import java.util.List;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;
    private NicePlaceViewModel mNicePlaceViewModel;
    private FloatingActionButton fab;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView=findViewById(R.id.recyclerView);
        fab=findViewById(R.id.fab);
        mProgressBar=findViewById(R.id.progressBar);

        mNicePlaceViewModel= ViewModelProviders.of(this).get(NicePlaceViewModel.class);
        mNicePlaceViewModel.init();

        mNicePlaceViewModel.getNicePlaces().observe(this, new Observer<List<NicePlace>>() {
            @Override
            public void onChanged(List<NicePlace> nicePlaces) {
                mAdapter.notifyDataSetChanged();
              //  mRecyclerView.smoothScrollToPosition(nicePlaces.size()-1);
            }
        });

        mNicePlaceViewModel.getIsUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean){
                    mProgressBar.setVisibility(View.VISIBLE);
                }
                else{
                    mProgressBar.setVisibility(View.INVISIBLE);
                    mRecyclerView.smoothScrollToPosition(mNicePlaceViewModel.getNicePlaces().getValue().size()-1);
                }
            }
        });

        initRecyclerView();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNicePlaceViewModel.addNewValue(new NicePlace("https://i.redd.it/obx4zydshg601.jpg",
                        "Austrailia"));
            }
        });

    }

    private void initRecyclerView() {
        mAdapter=new RecyclerViewAdapter(this, mNicePlaceViewModel.getNicePlaces().getValue());
        RecyclerView.LayoutManager linearLayoutManager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

}
