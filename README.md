7NUS Orbital 2020 - Milestone 1 
### Proposed Level of Achievement: 
Project Gemini 

# Motivation

Many students struggle with time management. It is common for students to use to-do lists as a way to keep track of their work in order to make better use of their time. However, we find that the to-do lists apps available to students can be improved to better aid students in other aspects that they struggle with such as finding motivation and maintaining focus. 

Students struggle with building up the motivation to get a task done before they even start. This is because students see tasks as these time-consuming, complex and daunting projects. Students feel demoralised before they even start. Furthermore, we are all familiar with the struggle for motivation in the middle of the long hard day of work. Wouldn't it be nice to have tools to make this struggle for motivation just a little bit easier? 

Another struggle for students is staying focused in a world full of distractions. From gaming to social media there are so many things that can distract you from your work. Students find it very hard to resist the temptations of a distraction and feel as though we cannot rely on our own self-discipline. 

# Aim 
We aim to make a todo list app that is simple, fun and flexible which will also encourage students who are easily distracted to be more productive and motivated with the help of a little companion. 

# Scope of Project
The *desktop app* provides a UI interface for users to plan out their tasks and subtasks. 

Features to be completed by mid June:
TodoList components
Adding, removing, editing tasks and subtasks
Setting deadlines for each task (main and subtask)
Setting priority for each main task
Timer component 
Pomodoro timer with 2 different time phases, work and rest (adjustable time periods)
Reminder component 
Reminder alerts will pop up on screen before different phases (from the timer component)
Calendar feature 
Show tasks with deadlines in calendar format, and workload intensity visualisation for each week. 
JSON implementation 
Store all tasks and subtasks that user created and the user settings 

Features to be completed by mid July:
Progress tracking component
Progress bar
Progress graph
Auto generated subtasks
The app generates a list of possible subtasks given a main task 
Animation
Reminder alerts will be shown through animations of Cleo walking around the user’s screen
Game detection
Detects if a game executable is running for a specific period of time
Close app feature
Close a specific app
# Features

## TodoList
This feature allows students to list down their tasks such as upcoming assignments, this list can be displayed on user’s screens for easy access. 

## Subtasks
This feature allows users to break down large tasks into more manageable tasks. 

## Timer
This study timer records cycles of studying and resting. The duration of these cycles can be specified by the user or commonly used intervals are also available ( For example Pomodoro setting is 25 minutes of work followed by 5 minutes of rest).

## Extension of Interval
This feature gives users some flexibility for the duration of the rest and study intervals, at any point during either the rest or study period, students can choose to extend this session by. However, during rest sessions if students choose to extend repeatedly beyond 15 minutes, the study session will be terminated.

## Reminders (Game detection) 
Once the interval for study or break is over, there will be a reminder for students to move onto the next part of their cycle. For students who are playing video games on their devices, this feature detects if students are playing when they are not supposed to (during work phase) and gives a warning to the user, before eventually closing the game. 

## Progress tracking
This feature consists of 2 components. Firstly,  a progress bar that visualises the number of tasks completed with respect to the total number of tasks to be completed. Secondly, a graph to illustrate the student’s number of hours spent working compared to resting. 

#Calendar 
Once a task has been created with deadlines, they can be viewed  in a calendar format. Weeks are colour coded to show how much workload there is in each week (red - heavy workload, blue - light workload). This encourages users to distribute their workload evenly throughout the months, and not have too much workload in just one week. 

## Cleo the Cat
Cleo the cat is the character integrated throughout the app in illustrations and animations. For example the reminder feature mentioned earlier will have an animation of Cleo to indicate that the study or rest period is over. 

# User Stories

TodoList
As a student with many tasks and assignments so it is important to stay organised and on track so they may use a to-do list to aid them.
Subtasks 
As a student who might have difficulty starting on a task that may feel daunting, having subtasks that they created will help make the task itself feel more manageable, and have a more detailed plan on what they want to work on first. 
As a student who is not sure how to start breaking down their main task into smaller sub tasks, the app will suggest the subtasks required for each app 
Timer
As a student working for long periods of time, it's important to maintain focus throughout. This can be done with the use of timers that follow a study-rest cycle that allows for sufficient break which can help prevent fatigue.

As a student who is studying who is focused on their current task, it might be counterintuitive to force the student to take a break when the study portion of the cycle is up so they may want an extension. 
Progress bar
Similarly,  as a student who is resting and the period for rest is over yet they feel like additional break is needed, they can extend their break session.
As a student that procrastinates on work by gaming, as their rest period comes to an end, there will be a reminder for the student to go back to work. After 15-30 seconds, if the student ignores the reminder, it will force close the game (will visually show through cat animation), so that the user will be snapped out of the “in game trance” and will be more likely to go back to work. The same applies for students who get distracted while they are supposed to be working.

Reminding cat feature
As a student who may start to lose motivation while doing work, being able to see how much work you have achieved or how long you have been working for could motivate them to keep working, they can see this via the progress visualisation feature.
As a student that thinks that to-do list apps are generally boring, this  app can be made more interactive and attractive with the use of a character.
Calendar Feature
As a student who struggles with time management and planning, it might be easier to visualise tasks through the calendar feature to see how current tasks are distributed visually. 

Customizability
As a student who might have differing wants and needs, being able to customise (like which timer they prefer on using, or whether to show notification when work/break time is over) will help suit the student’s needs in the way that they see fit.

# Development Plan 

*3rd week of May:* Finalised pitch for Orbital Lift-off
*4th week of May:* Finish Milestone 1 submissions - README, Log, Poster and Video
*5th week of May:* Pick up necessary technologies - Java Swing, 
*1st week of June:* Start building todolist (Todolist components,  timer component,  and reminder component), start working on animations
*2nd week of June:* Continue building todolist (Calendar feature, JSON Implementation), 
*3rd week of June:* Build Progress Tracking component and auto generated subtasks
*4th week of June:* Testing & Debugging + implement game detection
*1st week of July:* Implementation of peer teams’ suggestions, finish animations
*2nd week of July:* Implement 
*3rd week of July:* Testing & Debugging



# Mockup
## Summary

## Adding task

## Progress Tracker

## Timer Settings

## Calendar 

## Reminders

## Game Detection


# Proof of Concept 
