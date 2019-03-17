package com.note.keeper

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class DataManagerTest {

    @Before
    fun setUp() {
        DataManager.notes.clear()
    }

    @Test
    fun `should add note`() {
        // given
        val course = DataManager.courses.get("android_async")!!
        val noteTitle = "This is a test note"
        val noteText = "This is a body of a test note"

        // when
        val index = DataManager.addNote(course, noteTitle, noteText)
        val note = DataManager.notes[index]

        // then
        assertThat(note.course).isEqualTo(course)
        assertThat(note.noteTitle).isEqualTo(noteTitle)
        assertThat(note.noteText).isEqualTo(noteText)
    }

    @Test
    fun `should find similar notes`() {
        // given
        val course = DataManager.courses.get("android_async")!!
        val noteTitle = "This is a test note"
        val noteText1 = "This is a body of a test note 1"
        val noteText2 = "This is a body of a test note 2"

        // when
        val index1 = DataManager.addNote(course, noteTitle, noteText1)
        val index2 = DataManager.addNote(course, noteTitle, noteText2)
        val note1 = DataManager.findNote(course, noteTitle, noteText1)
        val note2 = DataManager.findNote(course, noteTitle, noteText2)
        val foundIndex1 = DataManager.notes.indexOf(note1)
        val foundIndex2 = DataManager.notes.indexOf(note2)

        // then
        assertThat(foundIndex1).isEqualTo(index1)
        assertThat(foundIndex2).isEqualTo(index2)
    }
}