package me.didik.task;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import me.didik.task.feature.tasks.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.core.deps.guava.base.Preconditions.checkArgument;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by didik on 07/06/16.
 * Screen Test
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class TaskScreenTest {

    private Matcher<View> withItemText(final String itemText) {
        checkArgument(!TextUtils.isEmpty(itemText), "itemText cannot be null or empty");
        return new TypeSafeMatcher<View>() {
            @Override
            public boolean matchesSafely(View item) {
                return allOf(
                        isDescendantOfA(isAssignableFrom(RecyclerView.class)),
                        withText(itemText)).matches(item);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("is isDescendantOfA RV with text " + itemText);
            }
        };
    }

    // Deskripsikan Activity yang dites
    @Rule
    public ActivityTestRule<MainActivity> mNotesActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void clickAddTaskButton_openAddTaskUI() throws Exception {
        // Klik button tambah task
        onView(withId(R.id.fab_new_task)).perform(click());

        // Cek apakah sebuah view berhasil ditampilkan
        onView(withId(R.id.et_title)).check(matches(isDisplayed()));
    }

    @Test
    public void addTask() throws Exception {
        String title = "Espresso";
        String desc = "UI Testing with Espresso";

        // Klik button tambah task
        onView(withId(R.id.fab_new_task)).perform(click());

        // Isi judul dan deskripsi
        onView(withId(R.id.et_title)).perform(typeText(title), closeSoftKeyboard());
        onView(withId(R.id.et_desc)).perform(typeText(desc), closeSoftKeyboard());

        // Simpan task
        onView(withId(R.id.fab_save_task)).perform(click());
    }
}
