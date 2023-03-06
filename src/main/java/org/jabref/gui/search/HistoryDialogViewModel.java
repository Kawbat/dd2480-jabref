package org.jabref.gui.search;

import java.util.Objects;

import javafx.collections.ObservableList;

import org.jabref.gui.AbstractViewModel;
import org.jabref.gui.ClipBoardManager;
import org.jabref.gui.DialogService;
import org.jabref.gui.StateManager;
import org.jabref.logic.l10n.Localization;

public class HistoryDialogViewModel extends AbstractViewModel {

    private final DialogService dialogService;
    private final ClipBoardManager clipBoardManager;

    private final StateManager stateManager;

    public HistoryDialogViewModel(DialogService dialogService, ClipBoardManager clipBoardManager, StateManager stateManager) {
        this.dialogService = Objects.requireNonNull(dialogService);
        this.clipBoardManager = Objects.requireNonNull(clipBoardManager);
        this.stateManager = stateManager;
    }

    public ObservableList<SearchHistoryItem> getHistory() {
        return this.stateManager.getSearchHistory().getHistory();
    }

    public void copyHistoryToClipboard() {
        clipBoardManager.setContent("toCopy");
        dialogService.notify(Localization.lang("Copied search histories to clipboard"));
    }
}
