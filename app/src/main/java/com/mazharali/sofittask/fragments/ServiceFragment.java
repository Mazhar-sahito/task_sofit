package com.mazharali.sofittask.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mazharali.sofittask.R;
import com.mazharali.sofittask.adapters.ServicesDummyAdapter;

import java.util.ArrayList;
import java.util.List;

public class ServiceFragment extends Fragment {
    private RecyclerView servicesRecyclerView;
    private ServicesDummyAdapter dummyAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.service_fragment_layout , container , false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        servicesRecyclerView = view.findViewById(R.id.services_recycler_view_id);
        servicesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity() , RecyclerView.VERTICAL, false));
        List<String> list = new ArrayList<>();
        list.add("dummy");
        list.add("dummy");
        list.add("dummy");
        list.add("dummy");
        list.add("dummy");

        dummyAdapter = new ServicesDummyAdapter( list);
        servicesRecyclerView.setAdapter(dummyAdapter);
    }
}
