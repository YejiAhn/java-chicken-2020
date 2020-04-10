package controller;

import java.util.List;

import domain.ChoiceInMain;
import domain.Menu;
import domain.MenuRepository;
import domain.PaymentMethod;
import domain.State;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

public class ChickenStoreController {
    private State state = State.BEFORE_RUNNING;

    public void run() {
        state = State.RUNNING;
        final List<Table> tables = TableRepository.tables();
        final List<Menu> menus = MenuRepository.menus();

        while (state != State.END) {
            processCommand(tables, menus);
        }
    }

    private void processCommand(List<Table> tables, List<Menu> menus) {
        ChoiceInMain choiceInMain = InputView.inputChoiceInMain();
        if (choiceInMain == ChoiceInMain.ORDER) {
            processOrdering(tables, menus);
        }

        if (choiceInMain == ChoiceInMain.PAY) {
            OutputView.printTables(tables);
            final Table tablePaying = InputView.inputTableNumber(tables);
            OutputView.printOrders(tablePaying);
            final PaymentMethod paymentMethod = InputView.inputPaymentMethod(tablePaying);
            double finalAmountDue = paymentMethod.handleCashDiscount(tablePaying.calculateAmountDue());
            OutputView.printFinalAmountDue(finalAmountDue);
        }

        if (choiceInMain == ChoiceInMain.TERMINATE) {
            OutputView.printTerminateMessage();
            state = State.END;
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
