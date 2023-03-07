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

What are your main take-aways from this project? What did you learn?

How did you grow as a team, using the Essence standard to evaluate yourself?

Optional (point 6): How would you put your work in context with best software engineering practice?

Optional (point 7): Is there something special you want to mention here?

## Purpose and structure of the project
### Purpose of JabRef
JabRef is an open-source, cross-platform citation and reference management tool. It helps to collect and organize sources, find the paper and discover the latest research.

JabRef has four key features:

#### 1. Collect:
- Search across many online scientific catalogues like CiteSeer, CrossRef, Google Scholar, IEEEXplore, INSPIRE-HEP, Medline PubMed, MathSciNet, Springer, arXiv, and zbMATH
- Import options for over 15 reference formats
- Easily retrieve and link full-text articles
- Fetch complete bibliographic information based on ISBN, DOI, PubMed-ID and arXiv-ID
- Extract metadata from PDFs
- Import new references directly from the browser with one click using the official browser extension for Firefox, Chrome, Edge and Vivaldi

#### 2. Organize:
- Group your research into hierarchical collections and organize research items based on keywords/tags, search terms or your manual assignments
- Advanced search and filter features
- Complete and fix bibliographic data by comparing with curated online catalogues such as Google Scholar, Springer or MathSciNet
- Customizable citation key generator
- Customize and add new metadata fields or reference types
- Find and merge duplicates
- Attach related documents: 20 different kinds of documents supported out of the box, completely customizable and extendable
- Automatically rename and move associated documents according to customizable rules
- Keep track of what you read: ranking, priority, printed, quality-assured

#### 3. Cite:
- Native BibTeX and Biblatex support
- Cite-as-you-write functionality for external applications such as Emacs, Kile, LyX, Texmaker, TeXstudio, Vim and WinEdt.
- Format references in one of the many thousand built-in citation styles or create your style
- Support for Word and LibreOffice/OpenOffice for inserting and formatting citations

#### 4. Share:
- Many built-in export options or create your export format
- Library is saved as a simple text file and thus it is easy to share with others via Dropbox and is version-control friendly
- Work in a team: sync the contents of your library via a SQL database

### Architecture of JabRef
JabRef has a structured architecture with the`model`in the center, and the`logic`
as an intermediate layer towards the`gui`which is the outer shell. There are additional utility packages for`preferences`and the`cli`. The dependencies are only directed towards the center. We have JUnit tests to detect violations of the most crucial dependencies (between`logic`,`model`, and`gui`), and the build will fail automatically in these cases.

The`model`represents the most important data structures (`BibDatases`,`BibEntries`,`Events`, and related aspects) and has only a little bit of logic attached. The`logic`is responsible for reading/writing/importing/exporting and manipulating the`model`, and it is structured often as an API the`gui`can call and use. Only the`gui`knows the user and their preferences and can interact with them to help them solving tasks. For each layer, we form packages according to their responsibility, i.e., vertical structuring. The`model`should have no dependencies to other classes of JabRef and the`logic`should only depend on`model`classes. The`cli`package bundles classes that are responsible for JabRef’s command line interface. The`preferences`package represents all information customizable by a user for her personal needs.

We use an event bus to publish events from the`model`to the other layers. This allows us to keep the architecture but still react upon changes within the core in the outer layers.

Both GUI and CLI are started via the`JabRefMain`which will in turn call`JabRef`
which then decides whether the GUI (`JabRefFrame`) or the CLI (`JabRefCLI`
and a lot of code in`JabRef`) will be started. The`JabRefFrame`represents the Window which contains a`SidePane`on the left used for the fetchers/groups Each tab is a`BasePanel`which has a`SearchBar`at the top, a`MainTable`at the center and a`PreviewPanel`or an`EntryEditor`at the bottom. Any right click on the`MainTable`
is handled by the`RightClickMenu`. Each`BasePanel`holds a`BibDatabaseContext`
consisting of a`BibDatabase`and the`MetaData`, which are the only relevant data of the currently shown database. A`BibDatabase`has a list of`BibEntries`. Each`BibEntry`
has an ID, a citation key and a key/value store for the fields with their values. Interpreted data (such as the type or the file field) is stored in the`TypedBibentry`type. The user can change the`JabRefPreferences`through the`PreferencesDialog`.
