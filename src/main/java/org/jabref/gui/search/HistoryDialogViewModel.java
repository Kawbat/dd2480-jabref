package org.jabref.gui.search;

import java.util.Objects;

import org.jabref.gui.AbstractViewModel;
import org.jabref.gui.ClipBoardManager;
import org.jabref.gui.DialogService;
import org.jabref.logic.l10n.Localization;

public class HistoryDialogViewModel extends AbstractViewModel {

    private final String searchHistories;
    private final DialogService dialogService;
    private final ClipBoardManager clipBoardManager;

    public HistoryDialogViewModel(DialogService dialogService, ClipBoardManager clipBoardManager) {
        this.dialogService = Objects.requireNonNull(dialogService);
        this.clipBoardManager = Objects.requireNonNull(clipBoardManager);

        String histories = "history0\n";
        String history1 = "history1";
        String history2 = "history2";
        histories = histories.concat(history1);
        histories = histories.concat("\n");
        histories = histories.concat(history2);
        histories = histories.concat("\n");
        searchHistories = histories;
    }

    public String getSearchHistories() {
        return searchHistories;
    }

    public void copyHistoryToClipboard() {
        clipBoardManager.setContent(searchHistories);
        dialogService.notify(Localization.lang("Copied search histories to clipboard"));
    }
}
