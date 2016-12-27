package com.udacity.gradle.builditbigger;

/**
 * Created by ramkrishna on 27/12/16.
 */

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertFalse;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class AppInstrumentedTest implements ApiJokeRequest.IGetApiData{
    @Test
    public void testJokeApi() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        new ApiJokeRequest(appContext, this).execute();
    }

    @Override
    public void getData(String data) {
        assertFalse(data == null);
        assertFalse(data.isEmpty());
    }
}
