package com.example.fuelcap;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

public class SendMailTask extends AsyncTask {

    //I used a similar method for this as I previously used.

    private ProgressDialog sDialog;
    private Activity sendMailActivity;

    public SendMailTask(Activity activity) {
        sendMailActivity = activity;
    }

    // this is a method for making /showing the progress dialogs.
    protected void onPreExecute(){
        sDialog = new ProgressDialog(sendMailActivity);
        sDialog.setMessage("Getting Ready...");
        sDialog.setIndeterminate(false);
        sDialog.setCancelable(false);
        sDialog.show();
    }

    @Override
    protected Object doInBackground(Object... args) {
        try{
            Log.i("SendMailTask", "Getting your email ready..");
            publishProgress("Illegally storing your information. lol");
            GMail androidEmail = new GMail(args[0].toString(),
                    args[1].toString(),(List) args[2], args[3].toString(),
                    args[4].toString());
            publishProgress("Prepping your info..");
            androidEmail.createEmailMessage();
            publishProgress("In the process of sending your info..");
            androidEmail.sendEmail();
            publishProgress("Info belongs to us now. ;)");
            Log.i("SendMailTask", "Your email has been sent, please disregard the jokes about your info previously");
        }
        catch (Exception e){
            publishProgress(e.getMessage());
            Log.e("SendMailTask", e.getMessage(), e);
        }
        return null;
    }

    // Setting or creating the dialog messages
    @Override
    public void onProgressUpdate(Object... values){
        sDialog.setMessage(values[0].toString());
    }

    // Dismissing or getting rid of the dialogs messages.
    @Override
    public void onPostExecute(Object result){
        sDialog.dismiss();
    }
}
