# DD2480 - Assignment 4

## Project

JabRef

<https://github.com/JabRef/jabref>

JabRef is a citation and reference management tool which allows the user to collect and organize various research papers. It has a graphical user interface and is implemented in Java.

## Onboarding experience

We chose a new project since the previous project was a collection of algorithms which was not suitable for this assignment. The onboarding process for this project was more complicated since the overall software is more advanced and the code complexity is also higher. However, the project provides detailed documentation of how to set up a local environment in order to build and work on the project. While the setup took some time to complete it was well documented and easy to follow.

## Effort spent

The amount of time in hours on different tasks for each group member is listed below:

|                          | Marcus  | Oscar   | Pauline | Simon   | Siyang  |
| :---                     | :---:   | :---:   | :---:   | :---:   | :---:   |
| Discussions and meetings |         |         |         | 9       |         |
| Configuration and setup  |         |         |         | 2       |         |
| Reading documentation    |         |         |         | 2       |         |
| Writing documentation    |         |         |         | 8       |         |
| Programming together     |         |         |         | 4       |         |
| Programming individually |         |         |         | 0       |         |

The configuration and setup was quite simple where most of the time was spent on installing JDK 19, IntelliJ IDEA and Gradle.

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

What are your main take-aways from this project? What did you learn?

How did you grow as a team, using the Essence standard to evaluate yourself?

Optional (point 6): How would you put your work in context with best software engineering practice?

Optional (point 7): Is there something special you want to mention here?
