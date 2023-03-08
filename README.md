# DD2480 - Assignment 4

## Project

JabRef

<https://github.com/JabRef/jabref>

JabRef is a citation and reference management tool which allows the user to collect and organize various research papers. It has a graphical user interface and is implemented in Java.

## Onboarding experience

We chose a new project since the previous project was a collection of algorithms which was not suitable for this assignment. The onboarding process for this project was more complicated since the overall software is more advanced and the code complexity is also higher. However, the project provides detailed documentation of how to set up a local environment in order to build and work on the project. While the setup took some time to complete it was well documented and easy to follow.

## Effort spent

For each team member, how much time was spent in

1. plenary discussions/meetings;

2. discussions within parts of the group;

3. reading documentation;

4. configuration and setup;

5. analyzing code/output;

6. writing documentation;

7. writing code;

8. running code?

For setting up tools and libraries (step 4), enumerate all dependencies
you took care of and where you spent your time, if that time exceeds
30 minutes.

#### Marcus

[TODO]

#### Oscar

[TODO]

#### Pauline

[TODO]

#### Simon

[TODO]

#### Siyang

[TODO]

## Overview

### Issue #7906: Record search history

Implement recording of search history so that the user can view previous search queries in order to refine or repeat new searches and also allow the user to remove one or multiple entries in the search history.

<https://github.com/JabRef/jabref/issues/7906>

The search history management should be implemented in a separate class called `SearchHistory` where the list itself is handled by a `LinkedHashSet` data structure. This automatically avoids duplicate entries and also keeps the order that entries are saved in. When the user performs a search this query should also be forwarded from `GlobalSearchBar` to the `SearchHistory` class which validates it and then stores it in the data structure. Further `GlobalSearchBar` also needs to be modified in order to append the history button to the side of the search bar.

## Requirements

### Issue #7906: Record search history

<https://github.com/JabRef/jabref/issues/7906>

Requirements:

* `R01`: Save queries  
The queries performed by the user should be saved in a search history. Empty queries should not be saved in the search history and equal queries should only occur once in the search history. The search history should be limited to the 10 most recent queries.
* `R02`: View queries  
The user should be able to view the current search history by clicking on a button next to the search bar. When clicking on this button a window should be opened which lists all of the queries in the search history.
* `R03`: Utilize queries  
The user should be able to click on a specific entry from the search history window in order to repeat the same query again. After the click has been performed the search history window should be closed and the search bar should be filled with the query.
* `R04`: Remove queries  
The user should be able to remove entries from the search history window, either by clicking on the remove button next to each corresponding entry, or by clicking on the clear button for the entire search history list.

Tests:

* `R01`: Save queries  
[TODO]
* `R02`: View queries  
[TODO]
* `R03`: Utilize queries  
[TODO]
* `R04`: Remove queries  
[TODO]

## Code changes

### Patch

(copy your changes or the add git command to show them)

git diff ...

Optional (point 4): the patch is clean.

Optional (point 5): considered for acceptance (passes all automated checks).

## Test results

Overall results with link to a copy or excerpt of the logs (before/after
refactoring).

## UML class diagram and its description

### Key changes/classes affected

Optional (point 1): Architectural overview.

Optional (point 2): relation to design pattern(s).

## Overall experience

During this project, we experimented the difficulty to enter and participate in a large and complex project, on an issue which concerned multiple parts of the code. 
Indeed, our project entails both the logic part and the application part of the search tool, and most of us did not have a lot of experience with GUI in particular.

In the end, we managed to: 
- establish the requirements for our feature
- add a structure to keep track of the search history 
- add a button and a window to display the search history
- add tests for our feature corresponding to the established requirements
- keep the repository clean and respect the required style of the main repo
- document our work to keep track of how far we were along the way

During this project, we had some trouble being as efficient as a team as we were on the previous project, but this taught us a lot about how to handle drops in motivation or miscommunication.
According to the ESSENCE framework, we think that we have reached state Collaborating.
It took us some time to reach the Seeded state by rethinking our team dynamic at the beginning of this project, because we didn't know right away which competences were needed and how each member wanted to spend their time on the project, especially because the time constraints were not the same as with the previous projects. However, we kept the same governance rules as before.
However, we then managed to reach the Formed and Collaborating state by dividing the tasks and starting to take our individual responsibilities and communicate more openly at the end of the first week.
We feel that an item is still missing for us to reach the Performing state, because we have had a few inefficiencies during our work (hard time dividing the work, part of the work being carried out twice, etc) and we are still not active in identifying the potential for wasted work, so we should work on this as a group rather than just individually.

We did not exchange much with the community of this project, but we thought that overall the project was very well described and easy to set up, although it took us a lot of time to really understand the structure of the project.
We would have like to contribute to the project but someone else worked on our issue at the same time, so we couldn't create our own PR on top of theirs. This was disappointing for us, but we are still happy with the work we carried out. 

The main take-aways we gained from this project are:
- we improved our ability to get our bearings in a very large and complex projects, by using the documentation, sharing our knowledge between different members of the team, and learning to locate the parts of the code that we were interested in and ignore the rest even if we don't understand everything
- we gained experience in writing GUI application and learned a lot about testing it, even though testing the GUI ended up being too complicated on this particular project
- we learned a lot about each other as a team, and how to handle difficulties in communication or division of the work


Optional (point 6): How would you put your work in context with best software engineering practice?

Optional (point 7): Is there something special you want to mention here?
