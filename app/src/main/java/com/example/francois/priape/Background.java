package com.example.francois.priape;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Francois on 18/10/2015.
 */
public class Background extends AsyncTask<String,Void,String> {
   AlertDialog.Builder alertDialog;
    Context ctx; //Context actuelle de l'application Obtenir des infos sur une autre partie du programme
    Background(Context ctx)
    {
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute(){
        alertDialog = new AlertDialog.Builder(ctx);
        alertDialog.setTitle("Login Information");

    }

    @Override
    protected String doInBackground(String... params) {
        String reg_url = "http://192.168.1.2/tfe/register.php";
        String reg_login = "http://192.168.1.2/tfe/login.php";
        String method = params[0];
        if(method.equals("register"))
        {
            String user_email = params[1];
            String user_societe = params[2];
            String user_tva = params[3];
            String user_pass = params[4];
            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWritter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("user_email", "UTF-8") + "=" + URLEncoder.encode(user_email,"UTF-8")+"&"+
                        URLEncoder.encode("user_societe", "UTF-8") + "=" + URLEncoder.encode(user_societe,"UTF-8")+"&"+
                        URLEncoder.encode("user_tva", "UTF-8") + "=" + URLEncoder.encode(user_tva,"UTF-8")+"&"+
                        URLEncoder.encode("user_pass", "UTF-8") + "=" + URLEncoder.encode(user_pass,"UTF-8");
                bufferedWritter.write(data);
                bufferedWritter.flush();
                bufferedWritter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Registration success";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (method.equals("Login"))
        {

          String login_email = params[1];
            String login_pass = params[2];
            try {
                URL url = new URL(reg_login);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("login_email", "UTF-8")+"="+URLEncoder.encode(login_email, "UTF-8")+"&"+
                        URLEncoder.encode("login_pass", "UTF-8")+"="+URLEncoder.encode(login_pass, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                //reponse du serveur

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                String response = "";
                String line ="";
                while ((line = bufferedReader.readLine())!=null)
                {
                    response+=line;
                }
              bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        if(result=="Registration success") {
            Toast.makeText(ctx, result, Toast.LENGTH_SHORT).show();
        }
        else {
            alertDialog.setMessage(result);
            alertDialog.show();
        }
    }
}
