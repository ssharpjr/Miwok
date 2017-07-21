package com.example.android.miwok;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class WordAdapter extends ArrayAdapter<Word> {

    // Resource ID for the background color for this list of words.
    private int mColorResourceId;


    /**
     * Create {@link WordAdapter} object.
     *
     * @param context is the current context (Activity) that the adpater is being created in.
     * @param words   is the list of {@link Word}s to be displayed.
     */
    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise, inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the miwok_text_view name.
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the word from the current Word object and set this on the view.
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the default_text_view name.
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the word from the current Word object and set this on the view.
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        // Check for an Image
        if (currentWord.hasImage()) {
            // If Image, set the ImageView to the image resource specified in the current Word.
            imageView.setImageResource(currentWord.getImageResourceId());

            // Make sure the view is visible.
            imageView.setVisibility(View.VISIBLE);
        } else {
            // If no Image, hide the View.
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to.
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View.
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 1 ImageView and 2 TextViews) so that
        // it can be shown in the ListView.
        return listItemView;
    }
}
