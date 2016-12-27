package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.ramkrishna.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by ramkrishna on 27/12/16.
 */

class ApiJokeRequest extends AsyncTask<Void, Void, String> {

    private static MyApi myApiService = null;
    private Context mContext;
    private IGetApiData delegate;

    ApiJokeRequest(Context context, IGetApiData listener){
        mContext = context;
        delegate = listener;
    }

    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null){
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();
        }
        try {
            return myApiService.fetchJoke().execute().getJoke();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        if(joke == null && !joke.isEmpty()){
            delegate.getData(null);
        }else{
            delegate.getData(joke);
        }
    }

    public interface IGetApiData{
        void getData(String data);
    }
}
