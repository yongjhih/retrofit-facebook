package retrofit.facebook;

import com.github.aurae.retrofit.LoganSquareConverterFactory;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Observable;

public class Facebooks {
    public static Facebook create(String token) {
        OkHttpClient client = new OkHttpClient();
        client.interceptors().add(new AccessTokenInterceptor(token));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://graph.facebook.com/v2.5")
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(LoganSquareConverterFactory.create())
                .build();

        return retrofit.create(Facebook.class);
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
