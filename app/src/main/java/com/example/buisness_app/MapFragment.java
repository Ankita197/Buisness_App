package com.example.buisness_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buisness_app.adapter.ItemListAdapter;
import com.example.buisness_app.adapter.ItemOnClick;
import com.example.buisness_app.model.ItemList;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;


public class MapFragment extends Fragment implements OnMapReadyCallback {

    MapView mapFragment;
    TextView tvShowList;
    View view;
    ArrayList<ItemList> itemListArrayList = new ArrayList<>();
    BottomSheetBehavior behavior;
    private LinearLayout bottomSheet;
    RecyclerView rvItemList;
    ItemListAdapter itemListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null)
                parent.removeView(view);
        }
        try {
            view = inflater.inflate(R.layout.fragment_map, container, false);
        } catch (InflateException e) {
            /* map is already there, just return view as it is */
        }
        init(view);
        setList();
        setAdapter();
        setItemClick();
        setClick();
        initMap(savedInstanceState);
        return view;

    }
    private void initMap(Bundle savedInstanceState) {
        mapFragment.onCreate(savedInstanceState);
        mapFragment.onResume();
        MapsInitializer.initialize(getActivity());
        if (mapFragment != null) {
            Log.d("___@___", "this is not null");
            setCallBack();
        } else {
            Log.d("___@___", "this is null");
        }
    }

    private void init(View view) {
        mapFragment = view.findViewById(R.id.map);
        tvShowList = view.findViewById(R.id.tvShowList);
        bottomSheet = view.findViewById(R.id.bottomSheet);
        behavior = BottomSheetBehavior.from(bottomSheet);
        rvItemList = view.findViewById(R.id.rvItemList);
    }

    private void setAdapter() {
        itemListAdapter = new ItemListAdapter(getActivity(), itemListArrayList);
        rvItemList.setAdapter(itemListAdapter);
    }

    private void setList() {
        itemListArrayList.add(new ItemList(R.drawable.school, "primary school", "Rajkot,near hanuman ..", (float) 4.1));
        itemListArrayList.add(new ItemList(R.drawable.college, "primary school", "Rajkot,near hanuman ..", (float) 5));
        itemListArrayList.add(new ItemList(R.drawable.school, "primary school", "Rajkot,near hanuman ..", (float) 4.3));
        itemListArrayList.add(new ItemList(R.drawable.college, "primary school", "Rajkot,near hanuman ..", (float) 4.2));
        itemListArrayList.add(new ItemList(R.drawable.school, "primary school", "Rajkot,near hanuman ..", (float) 4.1));
        itemListArrayList.add(new ItemList(R.drawable.school, "primary school", "Rajkot,near hanuman ..", (float) 4.1));
        itemListArrayList.add(new ItemList(R.drawable.college, "primary school", "Rajkot,near hanuman ..", (float) 5));
        itemListArrayList.add(new ItemList(R.drawable.school, "primary school", "Rajkot,near hanuman ..", (float) 4.3));
        itemListArrayList.add(new ItemList(R.drawable.college, "primary school", "Rajkot,near hanuman ..", (float) 4.2));
        itemListArrayList.add(new ItemList(R.drawable.school, "primary school", "Rajkot,near hanuman ..", (float) 4.1));

    }
    private void setItemClick() {
        itemListAdapter.setClick(new ItemOnClick() {
            @Override
            public void OnClick(int position, RecyclerView.ViewHolder holder) {
                behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                startActivity(new Intent(getActivity(),ItemDetailsActivity.class));
            }
        });
    }
    private void setClick() {
        tvShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                behavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);


            }
        });
    }

    private void setCallBack() {
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {


        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(37.4233438, -122.0728817))
                .title("LinkedIn")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(37.4629101, -122.2449094))
                .title("Facebook")
                .snippet("Facebook HQ: Menlo Park"));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(37.3092293, -122.1136845))
                .title("Apple"));

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.4233438, -122.0728817), 10));
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onResume() {
        super.onResume();
        mapFragment.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapFragment.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapFragment.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapFragment.onLowMemory();
    }
}
