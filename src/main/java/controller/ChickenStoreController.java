package controller;

import java.util.List;

import domain.ChoiceInMain;
import domain.Menu;
import domain.MenuRepository;
import domain.State;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

public class ChickenStoreController {
    private State state;

    public void run() {
        ChoiceInMain choiceInMain = InputView.inputChoiceInMain();
        final List<Table> tables = TableRepository.tables();
        final List<Menu> menus = MenuRepository.menus();

        if (choiceInMain == ChoiceInMain.ORDER) {
            processOrdering(tables, menus);
        }

        if (choiceInMain == ChoiceInMain.PAY) {
            OutputView.printTables(tables);
        }

        if (choiceInMain == ChoiceInMain.TERMINATE) {
            OutputView.printTerminateMessage();
        }
    }

    private void processOrdering(List<Table> tables, List<Menu> menus) {
        OutputView.printTables(tables);
        final Table tableOrdering = InputView.inputTableNumber(tables);
        OutputView.printMenus(menus);
        final Menu menu = InputView.inputMenuNumber(menus);
        final int menuQuantity = InputView.inputMenuQuantity();
        try {
            tableOrdering.order(menu, menuQuantity);
        } catch (Exception e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }
}
