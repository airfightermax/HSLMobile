package com.example.rebosura.hslmobile;

/**
 * Created by Rebosura on 3/3/2018.
 */

public class InfoLibrary {
    private String[] mLetters = {"A", "B", "C", "D", "E", "F", "G","H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "T", "U", "V", "W", "X", "Y", "Z",};
    private int[] alphabetImages = {
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
            R.drawable.j,
            R.drawable.k,
            R.drawable.l,
            R.drawable.m,
            R.drawable.n,
            R.drawable.o,
            R.drawable.p,
            R.drawable.q,
            R.drawable.r,
            R.drawable.t,
            R.drawable.u,
            R.drawable.v,
            R.drawable.w,
            R.drawable.x,
            R.drawable.y,
            R.drawable.z
    };
    private String[] mAnimals = {
        "Bird", "Cat", "Deer", "Dog", "Elephant", "Giraffe", "Monkey", "Pig"
    };
    private int[][] animalImages = {
            {R.drawable.bird, R.drawable.birda},
            {R.drawable.cat, R.drawable.cata},
            {R.drawable.deer, R.drawable.testing},
            {R.drawable.dog, R.drawable.doga},
            {R.drawable.elephant, R.drawable.elephanta},
            {R.drawable.giraffe, R.drawable.giraffea},
            {R.drawable.monkey, R.drawable.monkeya},
            {R.drawable.pig, R.drawable.piga}
    };

   private String[] mDictionary = {"Airplane", "All done", "Apple", "Bear", "Bed"};
   private int[] mDictionaryImages = {
           R.drawable.airplane,
           R.drawable.alldone,
           R.drawable.apple,
           R.drawable.bear,
           R.drawable.bed,
   };

    public String getLetters(int a){
        String letter = mLetters[a];
        return letter;
    }
    public int getAlphabetImages(int a){
        return alphabetImages[a];
    }

    public String getAnimals(int a){
        String animal = mAnimals[a];
        return animal;
    }
    public int getAnimalImages(int a, int b){
        return animalImages[a][b];
    }

    public String[] getDictionaryArray(){
        return mDictionary;
    }
    public String getDictionary(int a){
        String dictionary_item = mDictionary[a];
        return dictionary_item;
    }
    public int getDictionaryImages(int a){return mDictionaryImages[a];}
}

