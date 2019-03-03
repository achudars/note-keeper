package com.note.keeper

class CourseInfo(val courseId: String, val courseTitle: String)

class NoteInfo(var course: CourseInfo, var noteTitle: String, var noteText: String)