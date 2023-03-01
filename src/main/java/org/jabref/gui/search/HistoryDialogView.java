package org.jabref.gui.search;

import com.airhacks.afterburner.views.ViewLoader;
import jakarta.inject.Inject;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import org.jabref.gui.ClipBoardManager;
import org.jabref.gui.DialogService;
import org.jabref.gui.util.BaseDialog;
import org.jabref.gui.util.ControlHelper;
import org.jabref.logic.l10n.Localization;

public class HistoryDialogView extends BaseDialog<Void> {

    @FXML private ButtonType copyHistoryButton;
    @FXML private TextArea textAreaVersions;

    @Inject private DialogService dialogService;
    @Inject private ClipBoardManager clipBoardManager;

    private HistoryDialogViewModel viewModel;

    public HistoryDialogView() {
        this.setTitle(Localization.lang("Search History"));

        ViewLoader.view(this)
                .load()
                .setAsDialogPane(this);

        ControlHelper.setAction(copyHistoryButton, getDialogPane(), event -> copyHistoryToClipboard());
    }

    public HistoryDialogViewModel getViewModel() {
        return viewModel;
    }

    @FXML
    private void initialize() {
        viewModel = new HistoryDialogViewModel(dialogService, clipBoardManager);

        textAreaVersions.setText(viewModel.getSearchHistories());

        this.setResizable(false);
    }

    @FXML
    private void copyHistoryToClipboard() {
        viewModel.copyHistoryToClipboard();
    }
}
