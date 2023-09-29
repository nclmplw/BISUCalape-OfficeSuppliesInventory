package com.example.bisucalape_officesuppliesinventory;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.fragment.app.Fragment;
import com.example.BISUCalapeOfficeSuppliesInventory.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;
    private SharedPref sharedPref;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        sharedPref = new SharedPref(((MainActivity) requireActivity()).getApplicationContext());

        binding.toggleModeSwitch.setChecked(sharedPref.getNightModeState());
        binding.toggleModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sharedPref.setNightModeState(isChecked);
                restartApp();
            }
        });

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    private void restartApp() {
        MainActivity activity = (MainActivity) requireActivity();
        Intent intent = new Intent(activity.getApplicationContext(), MainActivity.class);
        activity.finish();
        startActivity(intent);
    }
}
