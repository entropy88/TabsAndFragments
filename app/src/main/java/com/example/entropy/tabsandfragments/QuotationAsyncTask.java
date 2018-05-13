package com.example.entropy.tabsandfragments;

import android.os.AsyncTask;

import com.example.entropy.tabsandfragments.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class QuotationAsyncTask extends AsyncTask<Void, Void, Void>{




        String jsonRepsonse="";
     public static    String text="";
       public static String author="";




        @Override
        protected Void doInBackground(Void... voids) {
            try {
                URL queryUrl = new URL("http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en");

                HttpURLConnection httpURLConnection = (HttpURLConnection) queryUrl.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder sb= new StringBuilder();
                String line = null;
                try {
                    while ((line = bufferedReader.readLine()) != null) {
                        sb.append(line + "\n");
                        jsonRepsonse=jsonRepsonse+line;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


                JSONObject root= new JSONObject(jsonRepsonse);
                author=root.getString("quoteAuthor");
                text=root.getString("quoteText");




            } catch (MalformedURLException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void Void) {

            FragmentOne.tvText.setText(text);
            FragmentOne.tvAuthor.setText(author);
            FragmentOne.btnAdd.setImageResource(R.drawable.ic_favorite_border_black_24px);
            super.onPostExecute(Void);

        }


    }


