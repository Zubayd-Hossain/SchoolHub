package com.apifytech.schoolhub;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class NavigationHandler {

    private final Context context;

    public NavigationHandler(Context context) {
        this.context = context;

    }

    // Menu action handler
    public void handleNavigationAction(String title) {
        switch (title) {

            case "Privacy Policy":
                // Privacy Policy action
                Toast.makeText(context, "Privacy Policy", Toast.LENGTH_SHORT).show();
                privacyPolicy();
                break;
            case "Rate Our App":
                // Rate App action
                Toast.makeText(context, "Rate Our App", Toast.LENGTH_SHORT).show();
                openStoreIntent(context.getPackageName());
                break;
            case "Share":
                // Share action
                Toast.makeText(context, "Share", Toast.LENGTH_SHORT).show();
                shareApp(context.getPackageName());
                break;
            case "About":
                // About action
                Toast.makeText(context, " About", Toast.LENGTH_SHORT).show();

                break;
            case "Log out":
                // Log out action
                Toast.makeText(context, "Log out", Toast.LENGTH_SHORT).show();

                break;
            default:
                Toast.makeText(context, "Unknown Action", Toast.LENGTH_SHORT).show();
                break;
        }
    }











    private void shareApp(String app_package) {

        String shareText ="https://play.google.com/store/apps/details?id=" + app_package ;
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
        Intent chooser = Intent.createChooser(shareIntent, "Share via");
        chooser.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(chooser);
    }

    private void openStoreIntent(String app_package) {
        String url = "market://details?id=" + app_package;
        Intent storeIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        storeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        try {
            context.startActivity(storeIntent);
        } catch (Exception e) {
            url = "https://play.google.com/store/apps/details?id=" + app_package;
            storeIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            storeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
            context.startActivity(storeIntent);
        }
    }

    private void privacyPolicy() {
        String url = "https://apifytech.com/QuizShakti_Privacy_Policy.html";
        Intent storeIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        storeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        try {
            context.startActivity(storeIntent);
        } catch (Exception e) {
            url = "https://apifytech.com/QuizShakti_Privacy_Policy.html" ;
            storeIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            storeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
            context.startActivity(storeIntent);
        }
    }

    private void Terms_of_Service() {
        String url = "";
        Intent storeIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        storeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        try {
            context.startActivity(storeIntent);
        } catch (Exception e) {
            url = "" ;
            storeIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            storeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
            context.startActivity(storeIntent);
        }
    }






}
