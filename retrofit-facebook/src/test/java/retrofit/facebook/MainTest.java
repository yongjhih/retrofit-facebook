package retrofit.facebook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import rx.Observable;
import rx.functions.*;
//import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.*;
import java.util.Collections;

public class MainTest {
    @Test public void testMe() {
        Facebook fb = Facebooks.create("");

        assertEquals(fb.me().toBlocking().single().id, "10152246635994118");
    }
    @Test public void testComments() {
        Facebook fb = Facebooks.create("");
        List<Comment> commentList = fb.getComments("10153423476374118").toBlocking().single().data;

        for (Comment comment : commentList) {
            System.out.println("id: " + comment.id);
            System.out.println("from: " + comment.from.name);
            System.out.println("message: " + comment.message);
        }

        assertTrue(commentList.size() > 1);
    }
}
