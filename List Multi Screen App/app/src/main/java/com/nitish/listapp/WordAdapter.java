package com.nitish.listapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;

    public WordAdapter(Context context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView frenchTextView = (TextView) listItemView.findViewById(R.id.french);

        frenchTextView.setText(currentWord.getMiwokTranslation());

        TextView englishTextView = (TextView) listItemView.findViewById(R.id.english);
        englishTextView.setText(currentWord.getDefaultTranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }
        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);
        return listItemView;

    }
}

