package Fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.mulwatech.k_farmer.R;

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
import java.util.ArrayList;

/**
 * Created by CJ-SERVER on 8/13/2015.
 */
public class Search_dealerby_location extends Fragment {
    private String url = "http://kfarmer.co.nf/dealers.php";
    private ListView lvdealers;
    private DealerAdapter adapter;
    private ArrayList<DealerModel> dealers = new ArrayList<DealerModel>();

    private ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.dealerlist, container, false);

        lvdealers = (ListView) view.findViewById(R.id.dealerlv);

        if (isNetworkAvailable()) {
            Showprogress();
            fetchdata();

        } else {
            Toast.makeText(getActivity(), "please make sure you have Internet", Toast.LENGTH_SHORT).show();
        }


        return view;
    }

    private void fetchdata() {
        new NetworkAsyncTask().execute(url);
    }

    private class NetworkAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... myurl) {
            try {
                URL url = new URL(myurl[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Accept", "application/json");
                connection.connect();

                InputStream inputStream = connection.getInputStream();

                int status = connection.getResponseCode();
                StringBuilder stringBuilder = new StringBuilder();

                switch (status) {
                    case 200:
                        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                        String line;
                        while ((line = reader.readLine()) != null) {
                            stringBuilder.append(line);
                        }
                        reader.close();
                        return stringBuilder.toString();
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();

            }

            return null;
        }

        @Override
        protected void onPostExecute(String results) {
            try {
                JSONObject response = new JSONObject(results);
                JSONArray expertsArray = response.getJSONArray("delears");

                for (int j = 0; j < expertsArray.length(); j++) {
                    JSONObject col = expertsArray.getJSONObject(j);
                    int id = col.getInt("id");
                    String firm_name = col.getString("firm_name");

                    String county = col.getString("county");
                    String location = col.getString("location");
                    String dealerof = col.getString("education");
                    String mobile = col.getString("mobile");

                    DealerModel dealerModel = new DealerModel(firm_name, county, location, dealerof, mobile);
                    dealers.add(dealerModel);


                    addToADapter();
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }

            Stopprogress();

        }

    }

    private void addToADapter() {
        adapter = new DealerAdapter(getActivity().getApplicationContext(), dealers);
        adapter.notifyDataSetChanged();

        lvdealers.setAdapter(adapter);
    }

    private Boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    private void Showprogress() {
        progressDialog = ProgressDialog.show(getActivity(), "Please wait", "Fetching Data.....");
    }

    private void Stopprogress() {
        progressDialog.cancel();
    }
}
