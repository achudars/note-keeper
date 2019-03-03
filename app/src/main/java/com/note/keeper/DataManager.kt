package com.note.keeper

/**
 * By making DataManager an object and not a class we can enforce Singleton pattern
 */
object DataManager {
    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()

    init {
        initialiseCourses()
        initialiseNotes()
    }

    private fun initialiseCourses() {
        var course = CourseInfo("android_intents", "Android Programming with Intents")
        courses[course.courseId] = course

        course = CourseInfo("android_async", courseTitle = "Android Async Programming and Services")
        courses[course.courseId] = course

        course = CourseInfo(courseTitle = "Java Fundamentals: The Java Language", courseId = "java_lang")
        courses[course.courseId] = course

        course = CourseInfo(courseTitle = "Java Fundamentals: The Core Platform", courseId = "java_core")
        courses[course.courseId] = course
    }

    private fun initialiseNotes() {
    }
}