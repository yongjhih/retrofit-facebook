package retrofit.facebook;

import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by yongjhih on 12/3/15.
 */
@JsonObject(fieldDetectionPolicy = JsonObject.FieldDetectionPolicy.NONPRIVATE_FIELDS)
public class Cursors {
    public String before;
    public String after;
}
