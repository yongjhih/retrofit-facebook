package retrofit.facebook;

import java.util.List;

import retrofit.Call;
import rx.Observable;
import retrofit.http.*;

public interface Facebook {
    // curl -i -X GET \
    //  "https://graph.facebook.com/v2.5/me?access_token={}"
    @GET("/me")
    Observable<User> me();

    // 10153423476374118/comments
    @GET("/{fbid}/comments")
    Observable<Comments> getComments(@Path("fbid") String fbid);
}
