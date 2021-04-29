package com.mazharali.sofittask.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mazharali.sofittask.R;
import com.mazharali.sofittask.adapters.ImageTextAdapter;
import com.mazharali.sofittask.adapters.PaymentHistory;
import com.mazharali.sofittask.constants.Const;
import com.mazharali.sofittask.model.ImageTextModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener {
    private RecyclerView imageTxtRecyclerView, paymentHistoryRecyclerView;
    private ImageTextAdapter imageTextAdapter;
    private PaymentHistory paymentHistoryAdapter;
    private List<ImageTextModel> list;
    private ImageView paymentHistoryIcon;
    private LinearLayout layout1, layout2, layout3, layout4;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(view);

        settingRecyclerViews();
    }

    private void settingRecyclerViews() {
        imageTxtRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                RecyclerView.HORIZONTAL, false));
        paymentHistoryRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                RecyclerView.HORIZONTAL, false));

        list = new ArrayList<>();
        list.add(new ImageTextModel("https://photographycourse.net/wp-content/uploads/2014/11/Landscape-Photography-steps.jpg",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"));

        list.add(new ImageTextModel("https://photographylife.com/wp-content/uploads/2016/06/Mass.jpg",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"));

        list.add(new ImageTextModel("https://images.pexels.com/photos/132037/pexels-photo-132037.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"));

        list.add(new ImageTextModel("https://photographylife.com/wp-content/uploads/2016/06/Mass.jpg",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"));

        list.add(new ImageTextModel("https://images.pexels.com/photos/132037/pexels-photo-132037.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry . Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"));

        imageTextAdapter = new ImageTextAdapter(this, list);
        imageTxtRecyclerView.setAdapter(imageTextAdapter);

        list = null;
        list = new ArrayList<>();
        list.add(new ImageTextModel("it-card-icon-images-credit-card-payment-icon.png",
                "Payment \n History"));
        list.add(new ImageTextModel("https://smallimg.pngkey.com/png/small/11-114087_cash-in-hand-icon.png",
                "Payment \n History"));
        list.add(new ImageTextModel("https://www.clipartmax.com/png/small/205-2059072_11-black-credit-card-icon-images-credit-card-payment-icon.png",
                "Payment \n History"));
        list.add(new ImageTextModel("https://smallimg.pngkey.com/png/small/11-114087_cash-in-hand-icon.png",
                "Payment \n History"));
        list.add(new ImageTextModel("https://www.clipartmax.com/png/small/205-2059072_11-black-credit-card-icon-images-credit-card-payment-icon.png",
                "Payment \n History"));

        paymentHistoryAdapter = new PaymentHistory(this, list);
        paymentHistoryRecyclerView.setAdapter(paymentHistoryAdapter);

    }

    private void initViews(View view) {
        layout1 = view.findViewById(R.id.layout1);
        layout2 = view.findViewById(R.id.layout2);
        layout3 = view.findViewById(R.id.layout3);
        layout4 = view.findViewById(R.id.layout4);

        imageTxtRecyclerView = view.findViewById(R.id.recycler_view_id);
        paymentHistoryRecyclerView = view.findViewById(R.id.history_recycler_view_id);
        paymentHistoryIcon = view.findViewById(R.id.menu_icon_id);

        paymentHistoryIcon.setOnClickListener(this);
        layout1.setOnClickListener(this);
        layout2.setOnClickListener(this);
        layout3.setOnClickListener(this);
        layout4.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.menu_icon_id) {
            showMenuPopup(v);
        } else if (v.getId() == R.id.layout1 || v.getId() == R.id.layout2 || v.getId() == R.id.layout3
                || v.getId() == R.id.layout4) {
            Const.mutableLiveData.setValue("change");
        }
    }

    private void showMenuPopup(View v) {
        final PopupMenu popup = new PopupMenu(getActivity(), v);
        popup.getMenuInflater()
                .inflate(R.menu.payment_history_menu, popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(
                        getActivity(),
                        "Clicked : " + item.getTitle(),
                        Toast.LENGTH_SHORT
                ).show();
                popup.dismiss();
                return true;
            }
        });

        popup.show();
    }
}
