package com.apps.akhilsreekar.frontend;
import java.util.ArrayList;
/**
 * Created by AKHIL on 27-09-2016.
 */
public class Data {
    static int[] colors = {
            R.color.orange,
            R.color.violet,
            R.color.magenta,
            R.color.dark_blue,
    };
    public static ArrayList<Information> getData() {
        ArrayList<Information> data = new ArrayList<>();
        int[] images = {
                R.drawable.logo,
                R.drawable.logo,
                R.drawable.logo,
                R.drawable.logo,
                R.drawable.logo,
                R.drawable.logo,
                R.drawable.logo,
                R.drawable.logo,
                R.drawable.logo,
                R.drawable.logo,
                R.drawable.logo,
                R.drawable.logo,
                R.drawable.logo,
                R.drawable.logo,
                R.drawable.logo,
        };

        String[] Categories = {
                "Game 1", "Game 2", "Game 3", "Game 4", "Game 5","Game 6", "Game 7", "Game 8", "Game 9", "Game 10","Game 11", "Game 12", "Game 13", "Game 14", "Game 15"
        };

        for (int i = 0; i < images.length; i++) {
            Information current = new Information();
            current.title = Categories[i];
            current.imageId = images[i];
            data.add(current);
        }

        return data;
    }
    public static int getBackGroundColor(int x){
        return colors[x%colors.length];
    }
}
