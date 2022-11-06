package com.example.myapplication.ui.youtube;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.FragmentYoutubeBinding;
import com.example.myapplication.ui.youtube.YoutubeViewModel;

public class YoutubeFragment extends Fragment {

    private FragmentYoutubeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        YoutubeViewModel youtubeViewModel =
                new ViewModelProvider(this).get(YoutubeViewModel.class);

        binding = FragmentYoutubeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textYoutube;
        youtubeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}