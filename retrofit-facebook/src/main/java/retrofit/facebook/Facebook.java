package retrofit.facebook;

import retrofit.Call;
import rx.Observable;
import retrofit.http.*;

public interface Facebook {
    // https://developers.facebook.com/docs/facebook-login/manually-build-a-login-flow

    // me
    // curl -i -X GET \
    //  "https://graph.facebook.com/v2.5/me?access_token={}"
    @GET("/me")
    Observable<User> me();

    // 10153423476374118/comments
    // curl -i -X GET \
    //  "https://graph.facebook.com/v2.5/{fbid}/comments?access_token={}"
    @GET("/{fbid}/comments")
    Observable<Comments> getComments(@Path("fbid") String fbid);
}
