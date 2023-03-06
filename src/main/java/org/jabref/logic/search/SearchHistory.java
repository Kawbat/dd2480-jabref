package org.jabref.logic.search;

import java.util.LinkedList;

public class SearchHistory {

    private LinkedList<SearchQuery> history = new LinkedList<>();
    private final int memoryLength = 100;
    private final int displayLength = 10;

    /**
     * Gets the last searches performed by the user.
     * The number of searches returned is given by attribute `displayLength`.
     * @return array of strings representing the researchs in decreasing order
     */
    public String[] getSearches () {
        return new String[] {"None"};
    }

    /**
     * Adds the given search to history.
     * If the history is full, removes the oldest search.
     * If the search is invalid or was already in the history, does not add it.
     * @param search
     */
    public void addSearch (SearchQuery search) {

    }

    /**
     * Removes the given search from the history.
     * If the search wasn't there, does not do anything.
     * @param search
     */
    public void removeSearch (SearchQuery search){

    }

}
