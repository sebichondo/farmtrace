package net.azurewebsites.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * Created by sebichondo on 8/12/15.
 */
@Module
public class APIServicesModule {

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            .create();

    @Provides
    public IApiService provideApiService(RestAdapter adapter) {
        return adapter.create(IApiService.class);
    }

    @Provides
    public RestAdapter provideRestAdapter(OkHttpClient client) {
        return new RestAdapter.Builder()
                .setEndpoint("http://farmtrace.azurewebsites.net/api/")
                .setConverter(new GsonConverter(gson))

                        //.setRequestInterceptor(new XSessionInterceptor())
                .setClient(new OkClient(client))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
    }


    @Provides
    public OkHttpClient provideHttpClient() { //Kill me as soon as possible (When we get the certs sorted out on the server)
        OkHttpClient client = new OkHttpClient();
        return client;
    }
}
