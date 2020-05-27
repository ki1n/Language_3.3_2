package com.example.language_33_2;

import android.app.Activity;
import android.content.Intent;

public class Utils {
    private static int sTheme;  // для цвета
    private static int mlTheme; // для отступа

    public final static int THEME_BLACK = 0;
    public final static int THEME_GREEN = 1;
    public final static int THEME_BLUE = 2;

    public final static int THEME_MARGIN_1 = 0;
    public final static int THEME_MARGIN_3 = 1;
    public final static int THEME_MARGIN_10 = 2;

    public static void changeToTheme(Activity activity, int theme) {
        sTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    public static void changeMlToTheme(Activity activity, int theme) {
        mlTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    public static void onActivityCreateSetThemeMl(Activity activity) {
        switch (mlTheme) {
            default:
            case THEME_MARGIN_1:
                activity.setTheme(R.style.Margin_1);
                break;
            case THEME_MARGIN_3:
                activity.setTheme(R.style.Margin_3);
                break;
            case THEME_MARGIN_10:
                activity.setTheme(R.style.Margin_10);
                break;
        }
    }

    public static void onActivityCreateSetTheme(Activity activity) {
        switch (sTheme) {
            default:
            case THEME_BLACK:
                activity.setTheme(R.style.AppThemeBlack);
                break;
            case THEME_GREEN:
                activity.setTheme(R.style.AppThemeGreen);
                break;
            case THEME_BLUE:
                activity.setTheme(R.style.AppThemeBlue);
                break;
        }
    }
}
