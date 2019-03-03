package com.note.keeper

data class CourseInfo(val courseId: String, val courseTitle: String) {
    override fun toString(): String {
        return courseTitle
    }
}

data class NoteInfo(var course: CourseInfo? = null, var noteTitle: String? = null, var noteText: String? = null)