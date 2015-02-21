package hacklikeagirl.com.nikerally.network;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

public class RallyClient {

    private static final String API_URL = "YOUR_URL_HERE";
    private static RallyClient instance = null;
    private RallyService service;

    private RallyClient() {
        OkHttpClient okHttpClient = new OkHttpClient();
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .setConverter(new GsonConverter(new Gson()))
                .setClient(new OkClient(okHttpClient))
                .build();

        restAdapter.setLogLevel(RestAdapter.LogLevel.FULL);
        service = restAdapter.create(RallyService.class);
    }

    public static RallyClient getInstance() {
        if (instance == null) {
            instance = new RallyClient();
        }
        return instance;
    }


    public void startRun(Callback<Object> callback) {
        service.startRun(callback);
    }

    public void lookForRally(Callback<Rally> callback) {
        service.lookForRally(callback);
    }




}
