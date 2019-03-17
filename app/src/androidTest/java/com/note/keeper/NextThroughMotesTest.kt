package com.note.keeper

import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isEnabled
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withSpinnerText
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NextThroughMotesTest {

    @Rule
    @JvmField
    val noteListActivity = ActivityTestRule(NoteListActivity::class.java)

    @Ignore("Does not recognise NoteInfo class for some reason")
    @Test
    fun nextThroughNotes() {
        // given
        onData(allOf(instanceOf(NoteInfo::class.java), equalTo(DataManager.notes[0]))).perform(click())

        for (index in 0..DataManager.notes.lastIndex) {
            val note = DataManager.notes[index]

            onView(withId(R.id.spinnerCourses)).check(matches(withSpinnerText(note.course?.courseTitle)))
            onView(withId(R.id.textNoteTitle)).check(matches(withText(note.noteTitle)))
            onView(withId(R.id.textNoteText)).check(matches(withText(note.noteText)))

            if (index != DataManager.notes.lastIndex) {
                onView(allOf(withId(R.id.action_next), isEnabled())).perform(click())
            }

            onView(withId(R.id.action_next)).check(matches(isEnabled()))

        }
    }
}