package org.jabref.logic.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SearchHistoryTest {

    @Test
    public void testItemsAdded() {
       SearchHistory searchHistory = new SearchHistory();
       searchHistory.addSearch("abc");
       assertEquals("abc", searchHistory.getHistory().get(0).searchStringProperty().get());
    }

    @Test
    public void testItemsRemoved() {
        SearchHistory searchHistory = new SearchHistory();
        searchHistory.addSearch("abc");
        searchHistory.remove("abc");
        assertEquals(0, searchHistory.getHistory().size());
    }

    @Test
    public void testTimeUpdated() throws InterruptedException {
        SearchHistory searchHistory = new SearchHistory();
        searchHistory.addSearch("abc");
        String firstDate = searchHistory.getHistory().get(0).lastSearchedProperty().get();
        Thread.sleep(2000);
        searchHistory.addSearch("abc");
        String secondDate = searchHistory.getHistory().get(0).lastSearchedProperty().get();
        assertNotEquals(firstDate, secondDate);
    }

    @Test
    public void testEmptyString() {
        SearchHistory searchHistory = new SearchHistory();
        searchHistory.addSearch("");
        assertEquals(0, searchHistory.getHistory().size());
    }
}
