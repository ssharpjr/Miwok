package com.example.android.miwok;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwak translation for that word.
 */

public class Word {

    // No image constant
    private static final int NO_IMAGE_PROVIDED = -1;
    // Default translation for the word
    private String mDefaultTranslation;
    // Miwok translation for the word
    private String mMiwokTranslation;
    // Image resource ID for the word
    private int mImageResourceId = NO_IMAGE_PROVIDED;


    /**
     * Constructor 1 (2 arguments)
     *
     * @param defaultTranslation is the word in a familiar language (like English).
     * @param miwokTranslation   is the Miwok word.
     */
    public Word(String defaultTranslation, String miwokTranslation) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    /**
     * Constructor 2 (3 arguments)
     *
     * @param defaultTranslation is the word in a familiar language (like English).
     * @param miwokTranslation   is the Miwok word.
     * @param imageResourceId    is the drawable resource ID for the image.
     */
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
    }


    /**
     * Getters
     */

    // Get the default translation of the word.
    public String getDefaultTranslation() {

        return mDefaultTranslation;
    }

    // Get the Miwok translation of the word.
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    // Return the image resource ID of the word.
    public int getImageResourceId() {
        return mImageResourceId;
    }

    // Returns whether or not there is an image for this word.
    // Returns True if there is an image.
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}
