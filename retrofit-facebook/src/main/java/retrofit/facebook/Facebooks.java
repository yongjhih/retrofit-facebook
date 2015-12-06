package retrofit.facebook;

import com.squareup.okhttp.OkHttpClient;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.client.OkClient;

public class Facebooks {
    public static Facebook create(String token) {
        OkHttpClient okClient = new OkHttpClient();
        Client client = new OkClient(okClient);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://graph.facebook.com/v2.3")
                .setRequestInterceptor(request -> request.addEncodedQueryParam("access_token", token))
                .setClient(client)
                .build();

        return restAdapter.create(Facebook.class);
    }
}
