package org.jabref.gui.search;

import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;

import org.jabref.gui.ClipBoardManager;
import org.jabref.gui.DialogService;
import org.jabref.gui.StateManager;
import org.jabref.gui.util.BaseDialog;
import org.jabref.gui.util.ControlHelper;
import org.jabref.logic.l10n.Localization;

import com.airhacks.afterburner.views.ViewLoader;
import jakarta.inject.Inject;

public class HistoryDialogView extends BaseDialog<Void> {

    @FXML private ButtonType copyHistoryButton;
    @FXML private TableView<SearchHistoryItem> searchHistoryTable;
    @FXML private TableColumn<SearchHistoryItem, String> searchHistoryStringColumn;
    @FXML private TableColumn<SearchHistoryItem, String> searchHistoryDateColumn;

    @Inject private DialogService dialogService;
    @Inject private ClipBoardManager clipBoardManager;

    private final StateManager stateManager;
    private HistoryDialogViewModel viewModel;

    public HistoryDialogView(StateManager stateManager) {
        this.setTitle(Localization.lang("Search History"));
        this.stateManager = stateManager;

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
        viewModel = new HistoryDialogViewModel(dialogService, clipBoardManager, stateManager);

        searchHistoryStringColumn.setEditable(false);
        searchHistoryStringColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        searchHistoryStringColumn.setCellValueFactory(param -> param.getValue().searchStringProperty());

        searchHistoryDateColumn.setEditable(false);
        searchHistoryDateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        searchHistoryDateColumn.setCellValueFactory(param -> param.getValue().lastSearchedProperty());

        searchHistoryTable.setItems(viewModel.getHistory());

        this.setResizable(false);
    }

    @FXML
    private void copyHistoryToClipboard() {
        viewModel.copyHistoryToClipboard();
    }
}
