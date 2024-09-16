In this project, you must implement a simplified version of the student registration system. In particular, your system must present a student with a set of courses, with all their relevant information, and allow the student to select five courses, one at a time, that do not conflict in day or time.

If we restate the requirements for this assignment in a single sentence, we might say the following:
"The user selects courses from a set of offerings such that the day and time ranges of each course do not conflict with the day and time ranges of the other selected courses." With that restatement, we can pick out the nouns to begin our object-oriented design. Here, the nouns are "user," "course," "offering," "day," "time," and "range." In this case, the user should probably not be a class itself, but the others (excepting "day") make a lot of sense. So we'll use those four classes for the solution.

The specific requirements for each class are presented in the code.

I would recommend that you work on the classes in the following order: Time, TimeRange, Course, and CourseOfferings.

A sample input file for the main function is given here: input.txt