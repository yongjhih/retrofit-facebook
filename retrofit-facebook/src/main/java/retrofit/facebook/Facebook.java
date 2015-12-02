package retrofit.facebook;

import rx.Observable;
import retrofit.http.*;

public interface Facebook {
    @GET("/me")
    Observable<User> me();
    public static class User {
    }
}
