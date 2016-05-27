package org.kaltia.apps.yas;


import android.widget.ListView;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kaltia.apps.yas.activities.MainActivity;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;


/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class ListItemsAdapterTest {
    MainActivity mainActivity;
    @Before
    public void setupActivity() {
        mainActivity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void title_at_main_activity_is_app_name() throws Exception {
        assertEquals(
                mainActivity.getTitle(),
                mainActivity.getResources().getString(R.string.app_name));
    }

    @Test
    public void items_number_will_be_match() throws Exception {
        ListView lists = (ListView) mainActivity.findViewById(R.id.shopping_lists);

        assertEquals(lists.getCount(), 3);
    }
}