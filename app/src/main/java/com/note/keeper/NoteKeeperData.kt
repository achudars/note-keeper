package com.note.keeper

data class CourseInfo(val courseId: String, val courseTitle: String) {
    override fun toString(): String {
        return courseTitle
    }
}

data class NoteInfo(var course: CourseInfo, var noteTitle: String, var noteText: String)