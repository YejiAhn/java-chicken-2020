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
        OutputView.printMain();
        ChoiceInMain choiceInMain = InputView.inputChoiceInMain();

        if (choiceInMain == ChoiceInMain.ORDER) {
            final List<Table> tables = TableRepository.tables();
            OutputView.printTables(tables);

            final int tableNumber = InputView.inputTableNumber();

            final List<Menu> menus = MenuRepository.menus();
            OutputView.printMenus(menus);
        }

        if (choiceInMain == ChoiceInMain.PAY) {

        }

        if (choiceInMain == ChoiceInMain.TERMINATE) {
            OutputView.printTerminateMessage();
        }
    }
}
