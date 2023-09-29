package com.example.bisucalape_officesuppliesinventory;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.example.furnitureapp.databinding.FragmentItemBinding;

public class ItemFragment extends Fragment {

    private FragmentItemBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentItemBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        MainActivity activity = (MainActivity) requireActivity();
        activity.getBinding().bottomNavigation.setVisibility(View.GONE);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
