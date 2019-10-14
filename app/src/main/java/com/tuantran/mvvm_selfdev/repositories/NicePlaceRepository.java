package com.tuantran.mvvm_selfdev.repositories;

import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;

import com.tuantran.mvvm_selfdev.models.NicePlace;

import java.util.ArrayList;
import java.util.List;

public class NicePlaceRepository {
    
    private static NicePlaceRepository instance;
    private ArrayList<NicePlace> dataSet = new ArrayList<>();
    
    public static synchronized NicePlaceRepository getInstance(){
        if(instance==null){
            instance=new NicePlaceRepository();
        }
        return instance;
    }
    
    public MutableLiveData<List<NicePlace>> getNicePlaces(){
        setNicePlace();
        
        MutableLiveData<List<NicePlace>> mutableLiveData=new MutableLiveData<>();
        mutableLiveData.setValue(dataSet);
        return mutableLiveData;
    }


    private void setNicePlace() {
        dataSet.add(
                new NicePlace("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg",
                        "Havasu Falls")
        );
        dataSet.add(
                new NicePlace("https://i.redd.it/tpsnoz5bzo501.jpg",
                        "Trondheim")
        );
        dataSet.add(
                new NicePlace("https://i.redd.it/qn7f9oqu7o501.jpg",
                        "Portugal")
        );
        dataSet.add(
                new NicePlace("https://i.redd.it/j6myfqglup501.jpg",
                        "Rocky Mountain National Park")
        );
        dataSet.add(
                new NicePlace("https://i.redd.it/0h2gm1ix6p501.jpg",
                        "Havasu Falls")
        );
        dataSet.add(
                new NicePlace("https://i.redd.it/k98uzl68eh501.jpg",
                        "Mahahual")
        );
        dataSet.add(
                new NicePlace("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg",
                        "Frozen Lake")
        );
        dataSet.add(
                new NicePlace("https://i.redd.it/obx4zydshg601.jpg",
                        "Austrailia"));
    }
}
