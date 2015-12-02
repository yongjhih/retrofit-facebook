package retrofit.facebook;

import retrofit.Call;
import rx.Observable;
import retrofit.http.*;

public interface Facebook {
    // curl -i -X GET \
    //  "https://graph.facebook.com/v2.5/me?access_token={}"
    @GET("/me")
    Observable<User> me();

    //@Keep
    public static class User {
        String name;
        String id;
    }
}
