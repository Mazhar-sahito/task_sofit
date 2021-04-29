package com.mazharali.sofittask.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mazharali.sofittask.R;
import com.mazharali.sofittask.adapters.JsonAdapter;
import com.mazharali.sofittask.retrofit.JsonInterface;
import com.mazharali.sofittask.retrofit.JsonPojo;
import com.mazharali.sofittask.retrofit.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsFragment extends Fragment {
    private RecyclerView recyclerView;
    private JsonAdapter jsonAdapter;
    private ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.post_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.json_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));

        // showing progress till the data fetched
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        JsonInterface service = RetrofitClientInstance.getRetrofitInstance().create(JsonInterface.class);
        Call<List<JsonPojo>> call = service.getAllPosts();

        call.enqueue(new Callback<List<JsonPojo>>() {
            @Override
            public void onResponse(Call<List<JsonPojo>> call, Response<List<JsonPojo>> response) {
                progressDialog.dismiss();
                jsonAdapter = new JsonAdapter(response.body());
                recyclerView.setAdapter(jsonAdapter);
            }

            @Override
            public void onFailure(Call<List<JsonPojo>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getActivity(), "Something went Wrong", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
