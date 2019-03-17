package com.note.keeper

import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.closeSoftKeyboard
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.assertj.core.api.Assertions.assertThat
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CreateNewNoteTest {

    @Rule
    @JvmField
    val noteListActivity = ActivityTestRule(NoteListActivity::class.java)

    @Test
    fun shouldCreateNewNote() {
        // given
        val course = DataManager.courses["android_async"]
        val noteTitle = "this is a super potato"
        val noteText = "This is a body of a test note"

        // when
        onView(withId(R.id.fab)).perform(click())

        onView(withId(R.id.spinnerCourses)).perform(click())
        onData(allOf(instanceOf(CourseInfo::class.java), equalTo(course))).perform(click())

        onView(withId(R.id.textNoteTitle)).perform(typeText(noteTitle))
        onView(withId(R.id.textNoteText)).perform(typeText(noteText), closeSoftKeyboard())

        pressBack()

        // then
        val newNote = DataManager.notes.last()
        assertThat(newNote.course).isEqualTo(course)
        assertThat(newNote.noteTitle).isEqualTo(noteTitle)
        assertThat(newNote.noteText).isEqualTo(noteText)
    }
}