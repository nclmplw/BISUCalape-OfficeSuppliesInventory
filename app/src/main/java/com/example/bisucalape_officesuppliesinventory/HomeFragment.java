package com.example.bisucalape_officesuppliesinventory;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import com.example.furnitureapp.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.bestSellerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToItemFragment();
            }
        });
        binding.popularItemButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToItemFragment();
            }
        });

        MainActivity activity = (MainActivity) requireActivity();
        activity.getBinding().bottomNavigation.setVisibility(View.VISIBLE);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    private void navigateToItemFragment() {
        int action = R.id.action_homeFragment_to_itemFragment;
        Navigation.findNavController(requireView()).navigate(action);
    }
}
