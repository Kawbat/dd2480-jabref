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
| Discussions and meetings | 9       | 9       | 9       | 9       | 8       |
| Configuration and setup  | 1       | 2       | 1       | 2       | 2       |
| Reading documentation    | 1       | 2       | 3       | 2       | 2       |
| Writing documentation    | 2       | 2       | 3       | 8       | 5       |
| Programming together     | 5       | 5       | 5       | 4       | 4       |
| Programming individually | 7       | 3       | 3       | 0       | 4       |

The configuration and setup was quite simple where most of the time was spent on installing JDK 19, IntelliJ IDEA and Gradle.

## Overview

### Issue #7906: Record search history

Implement recording of search history so that the user can view previous search queries in order to refine or repeat new searches and also allow the user to remove one or multiple entries in the search history.

<https://github.com/JabRef/jabref/issues/7906>

The search history management should be implemented in a separate class called `SearchHistory` where the list itself is handled by a `LinkedHashSet` data structure. This automatically avoids duplicate entries and also keeps the order that entries are saved in. When the user performs a search this query should also be forwarded from `GlobalSearchBar` to the `SearchHistory` class which validates it and then stores it in the data structure. Further `GlobalSearchBar` also needs to be modified in order to append the history button to the side of the search bar.

#### Requirements

* `R01`: Save queries  
The queries performed by the user should be saved in a search history. Empty queries should not be saved in the search history and equal queries should only occur once in the search history. The search history should be limited to the 10 most recent queries.
* `R02`: View queries  
The user should be able to view the current search history by clicking on a button next to the search bar. When clicking on this button a window should be opened which lists all of the queries in the search history.
* `R03`: Utilize queries  
The user should be able to click on a specific entry from the search history window in order to repeat the same query again. After the click has been performed the search history window should be closed and the search bar should be filled with the query.
* `R04`: Remove queries  
The user should be able to remove entries from the search history window, either by clicking on the remove button next to each corresponding entry, or by clicking on the clear button for the entire search history list.

#### Tests

We implemented tests directly for the logical structure containing the SearchHistory, and the application part of the requirements was tested manually because we did not manage to find a suitable testing technique for the GUI on this project. All test can be found in [SearchHistoryTest.java](https://github.com/Kawbat/dd2480-jabref/blob/d16e1e551c4ba6e62b0cc50b0f4261148596078a/src/test/java/org/jabref/logic/search/SearchHistoryTest.java)

* `R01`: Save queries  
Adding queries is checked by `testItemsAdded` and limited size of the history is checked by `testMaxSizeHistory`.
* `R02`: View queries  
This requirement was tested manually.
* `R03`: Utilize queries  
This requirement was tested manually, and `testTimeUpdated` tests that when a search is performed a second time, its date is updated.
* `R04`: Remove queries  
Removing a query is checked by `testItemsRemoved`.

## Code changes

### Patch

#### How to get the patch file

Simply use **`git log -1`** to display the most recent commit.

To find the **`first_commit_id`**, you can either use **`git log`** to view the entire commit history and find the first commit, or use **`git log --reverse`** to reverse the order of the commit history and show the oldest commit first.

Then run

```bash
git diff first_commit_id last_commit_id > diff
```

to generate the difference file.

Notice that we replace the original README.md with our report, and the patch will include this modification.

#### Patch Summary

Files modified:

* StateManager.java
* IconTheme.java
* GlobalSearchBar.java
* JabRef_en.properties

New files:

* HistoryDialog.css
* HistoryDialog.fxml
* HistoryDialogView.java
* HistoryDialogViewModel.java
* SearchHistoryItem.java
* SearchHistory.java
* SearchHistoryTest.java

For more details, we uploaded the patch file `diff` to the repository.

## Test results

After implementing our new feature we wrote tests to make all the functions work and behave properly. Ultimately we decided to write tests for the GUI implementation and found a testing framework called TestFX. Although it was a lot harder than we initially thought. After spending a rather large amount of time on trying to figure out TestFX we had to scrap the idea due to the fact that JabRef didn’t seem to integrate well with TestFX. Although we did manual tests of the GUI to make sure all the functionality of the GUI worked as intended.  Instead we decided to just make tests for the logical aspects of our implementation. We created a test class called `SearchHistoryTest` for the tests.

The tests created can be seen on the following link: <https://github.com/Kawbat/dd2480-jabref/blob/main/src/test/java/org/jabref/logic/search/SearchHistoryTest.java>

For our test log we decided to use the Automated Github Actions as reference.

To run the test log you can navigate to the following link: <https://github.com/Kawbat/dd2480-jabref/actions/runs/4364677845/jobs/7632289433>

Then simply click run "Run Tests" to get the test log.

## UML class diagram and its description

The UML Diagram which shows all the classes and changes we've done is located as a PDF in the root folder and is called UML_Diagram.pdf

### Key changes/classes affected

While implementing the new features, we tried to stick to the existing software architecture, as closely as possible. This was partly due to us wanting to keep a consistent structure throughout the application, as it improves readability and makes it easier for others to review, understand and expand upon our additions to the source code. The other reason for this was simply that by closely studying the already existing features of the project, we were able to learn how to implement the new features. Then it followed naturally that our code stayed close to the original project structure. We were also introduced to a new design pattern, with which we were not that familiar. This pattern was the observer pattern. While we were not deeply exposed to the underlying implementation of the observers, we understood that JavaFX used observers in order to determine when data relevant to tables was updated, and the GUI could be redrawn. By keeping an ObservableList in our SearchHistory class, we could use this list to set the items of a JavaFX TableView. This caused JavaFX to automatically refresh the GUI whenever the ObservableList was modified.

In terms of refactoring, we have also implemented the new feature in its own class instead of just appending it to previous classes. This could be linked to the extract class refactoring method which moves functionality out of one large class into smaller classes in order to reduce the complexity of the class.

## Overall experience

During this project, we experimented the difficulty to enter and participate in a large and complex project, on an issue which concerned multiple parts of the code. Indeed, our project entails both the logic part and the application part of the search tool, and most of us did not have a lot of experience with GUI in particular.

In the end, we managed to:

* establish the requirements for our feature
* add a structure to keep track of the search history
* add a button and a window to display the search history
* add tests for our feature corresponding to the established requirements
* keep the repository clean and respect the required style of the main repo
* document our work to keep track of how far we were along the way

During this project, we had some trouble being as efficient as a team as we were on the previous project, but this taught us a lot about how to handle drops in motivation or miscommunication. According to the ESSENCE framework, we think that we have reached state Collaborating. It took us some time to reach the Seeded state by rethinking our team dynamic at the beginning of this project, because we didn't know right away which competences were needed and how each member wanted to spend their time on the project, especially because the time constraints were not the same as with the previous projects. However, we kept the same governance rules as before. However, we then managed to reach the Formed and Collaborating state by dividing the tasks and starting to take our individual responsibilities and communicate more openly at the end of the first week. We feel that an item is still missing for us to reach the Performing state, because we have had a few inefficiencies during our work (hard time dividing the work, part of the work being carried out twice, etc) and we are still not active in identifying the potential for wasted work, so we should work on this as a group rather than just individually.

We did not exchange much with the community of this project, but we thought that overall the project was very well described and easy to set up, although it took us a lot of time to really understand the structure of the project. We would have like to contribute to the project but someone else worked on our issue at the same time, so we couldn't create our own PR on top of theirs. This was disappointing for us, but we are still happy with the work we carried out.

The main take-aways we gained from this project are:

* we improved our ability to get our bearings in a very large and complex projects, by using the documentation, sharing our knowledge between different members of the team, and learning to locate the parts of the code that we were interested in and ignore the rest even if we don't understand everything
* we gained experience in writing GUI application and learned a lot about testing it, even though testing the GUI ended up being too complicated on this particular project
* we learned a lot about each other as a team, and how to handle difficulties in communication or division of the work

## Analyse our project with the SEMAT kernel (covering alphas other than Team/Way of Working)
- Requirements: The requirements for the software system are clearly defined and documented, and they are complete, accurate, and unambiguous.
- Software System: The system is well designed and implemented to meet the requirements and provides the desired functionality.
- Work:  Out team is effectively managing and executing the software development process. Holding regular meetings is a key component of effective project management and helps to ensure that everyone is on the same page and working towards the same goals. By doing so, our team is able to identify and prioritize the necessary tasks and activities and ensure that they are being performed efficiently and effectively.
- Stakeholders:  Without external feedback from stakeholders, it is difficult to determine how well their needs and expectations are being met and whether their concerns and feedback are being addressed appropriately. However, our team has a clear understanding of the stakeholder requirements and expectations and that they are being taken into consideration during the development process. We are planning to get feedback from stakeholders once we deliver the patch to the project. This will provide valuable information on how well their needs and expectations have been met, and whether any additional changes or improvements are needed.
- Opportunity: The project is an open-source, cross-platform citation and reference management tool. It helps to collect and organize sources, find the paper and discover the latest research. The project is open source and free, so the goals and objectives are focused on providing a valuable service to users, rather than on generating revenue. And there are definitely clear benefits to developing the system. The program can be used by researchers to improve their work and allow them to work more effectively. This means that developing this program could actually indirectly benefit the entire field of research and science, and allow for more progress being made across the entire field. As far as business goals go, the program is entirely free, but accepts donations. So a more successful program should entail more donations, which is an obvious goal of most software system projects.
- Development Environment: Testing is a large and important part of software engineering. During our development, we spent a considerable amount of time trying to implement GUI tests in order to automatically test our GUI features. After many trials and errors we remained unsuccessful in implementing these tests. We attempted to use a library called TestFX, but we were having difficulties integrating it with the JabRef project and source code. We are still uncertain of the reasons for this, as we are still quite inexperienced with both JavaFX and TestFX. It seemed to us, however, that JabRef had strayed from the JavaFX patterns, and came up with their own solutions, and that this was the root of our issues with integrating TestFX with the project. Neither of the examples provided by TestFX seemed to be applicable to our project at hand. But as mentioned, this could also simply be a result of our inexperience. However, to bolster our hypothesis, we also noticed that there was very little, if any, GUI testing going on in the project. We extensively searched for it, with the goal of studying the already existing GUI tests to learn from them. We were, however, unsuccessful in our pursuit of finding any. This experience made us reflect on the importance of trying to stick to already tested and proven development and design patterns, as it may not only make it easier for newcomers to understand and expand upon your code, but it could also be easier to integrate already existing solutions and libraries into your projects.
## Purpose and structure of the project

### Purpose of JabRef

JabRef is an open-source, cross-platform citation and reference management tool. It helps to collect and organize sources, find the paper and discover the latest research.

JabRef has four key features:

#### 1. Collect

* Search across many online scientific catalogues like CiteSeer, CrossRef, Google Scholar, IEEEXplore, INSPIRE-HEP, Medline PubMed, MathSciNet, Springer, arXiv, and zbMATH
* Import options for over 15 reference formats
* Easily retrieve and link full-text articles
* Fetch complete bibliographic information based on ISBN, DOI, PubMed-ID and arXiv-ID
* Extract metadata from PDFs
* Import new references directly from the browser with one click using the official browser extension for Firefox, Chrome, Edge and Vivaldi

#### 2. Organize

* Group your research into hierarchical collections and organize research items based on keywords/tags, search terms or your manual assignments
* Advanced search and filter features
* Complete and fix bibliographic data by comparing with curated online catalogues such as Google Scholar, Springer or MathSciNet
* Customizable citation key generator
* Customize and add new metadata fields or reference types
* Find and merge duplicates
* Attach related documents: 20 different kinds of documents supported out of the box, completely customizable and extendable
* Automatically rename and move associated documents according to customizable rules
* Keep track of what you read: ranking, priority, printed, quality-assured

#### 3. Cite

* Native BibTeX and Biblatex support
* Cite-as-you-write functionality for external applications such as Emacs, Kile, LyX, Texmaker, TeXstudio, Vim and WinEdt
* Format references in one of the many thousand built-in citation styles or create your style
* Support for Word and LibreOffice/OpenOffice for inserting and formatting citations

#### 4. Share

* Many built-in export options or create your export format
* Library is saved as a simple text file and thus it is easy to share with others via Dropbox and is version-control friendly
* Work in a team: sync the contents of your library via a SQL database

### Architecture of JabRef

JabRef has a structured architecture with the`model`in the center, and the`logic` as an intermediate layer towards the`gui`which is the outer shell. There are additional utility packages for`preferences`and the`cli`. The dependencies are only directed towards the center. We have JUnit tests to detect violations of the most crucial dependencies (between`logic`,`model`, and`gui`), and the build will fail automatically in these cases.

The`model`represents the most important data structures (`BibDatases`,`BibEntries`,`Events`, and related aspects) and has only a little bit of logic attached. The`logic`is responsible for reading/writing/importing/exporting and manipulating the`model`, and it is structured often as an API the`gui`can call and use. Only the`gui`knows the user and their preferences and can interact with them to help them solving tasks. For each layer, we form packages according to their responsibility, i.e., vertical structuring. The`model`should have no dependencies to other classes of JabRef and the`logic`should only depend on`model`classes. The`cli`package bundles classes that are responsible for JabRef’s command line interface. The`preferences`package represents all information customizable by a user for her personal needs.

We use an event bus to publish events from the`model`to the other layers. This allows us to keep the architecture but still react upon changes within the core in the outer layers.

Both GUI and CLI are started via the`JabRefMain`which will in turn call`JabRef` which then decides whether the GUI (`JabRefFrame`) or the CLI (`JabRefCLI` and a lot of code in`JabRef`) will be started. The`JabRefFrame`represents the Window which contains a`SidePane`on the left used for the fetchers/groups Each tab is a`BasePanel`which has a`SearchBar`at the top, a`MainTable`at the center and a`PreviewPanel`or an`EntryEditor`at the bottom. Any right click on the`MainTable` is handled by the`RightClickMenu`. Each`BasePanel`holds a`BibDatabaseContext` consisting of a`BibDatabase`and the`MetaData`, which are the only relevant data of the currently shown database. A`BibDatabase`has a list of`BibEntries`. Each`BibEntry` has an ID, a citation key and a key/value store for the fields with their values. Interpreted data (such as the type or the file field) is stored in the`TypedBibentry`type. The user can change the`JabRefPreferences`through the`PreferencesDialog`.
