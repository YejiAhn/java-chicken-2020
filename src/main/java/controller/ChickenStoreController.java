package controller;

import java.util.List;

import domain.ChoiceInMain;
import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

public class ChickenStoreController {
    public static void run() {
        ChoiceInMain choiceInMain = InputView.inputChoiceInMain();
        final List<Table> tables = TableRepository.tables();
        final List<Menu> menus = MenuRepository.menus();

        if (choiceInMain == ChoiceInMain.ORDER) {
            OutputView.printTables(tables);
            final Table tableOrdering = InputView.inputTableNumber(tables);
            OutputView.printMenus(menus);
            final Menu menu = InputView.inputMenuNumber(menus);
            final int menuQuantity = InputView.inputMenuQuantity();
        }

        if (choiceInMain == ChoiceInMain.PAY) {

        }

        if (choiceInMain == ChoiceInMain.TERMINATE) {
            OutputView.printTerminateMessage();
        }
    }
}
