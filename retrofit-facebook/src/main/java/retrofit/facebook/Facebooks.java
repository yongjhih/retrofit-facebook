package retrofit.facebook;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.client.OkClient;
import rx.Observable;

public class Facebooks {
    public static Facebook create(String token) {
        OkHttpClient okClient = new OkHttpClient();
        Client client = new OkClient(okClient);
        okClient.interceptors().add(new AccessTokenInterceptor(token));

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://graph.facebook.com/v2.3")
                .setClient(client)
                .build();

        return restAdapter.create(Facebook.class);
    }

    static class AccessTokenInterceptor implements Interceptor {
        String token;
        public AccessTokenInterceptor(String token) {
            this.token = token;
        }

        @Override public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();

            Request.Builder requestBuilder = request.newBuilder();
            HttpUrl.Builder httpUrlBuilder = request.httpUrl().newBuilder();

            httpUrlBuilder.addEncodedQueryParameter("access_token", token);

            Request newRequest = requestBuilder.url(httpUrlBuilder.build()).build();

            return chain.proceed(newRequest);
        }
    }
}
