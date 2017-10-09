package org.academiadecodigo.javabank.controller;
import org.academiadecodigo.javabank.application.UserOptions;
import org.academiadecodigo.javabank.model.Bank;
import org.academiadecodigo.javabank.view.MenuView;

import java.util.HashMap;

public class MenuController extends AbstractController {

    private HashMap<Integer,Controller> controllerHashMap = new HashMap<>();
    private MenuView menuView;

    public MenuController(Bank bank) {
        super(bank);
    }


    public void init(){
        menuView.show();
    }



    public void setMenuView(MenuView menuView) {
        this.menuView = menuView;
    }

    public void chooseNextController(int controllerHashMapId){

        if(controllerHashMapId == UserOptions.QUIT.getOption()){
            return;
        }
        setNextController(controllerHashMap.get(controllerHashMapId));
        nextController.init();
    }

    public void setControllerHashMap(HashMap<Integer, Controller> controllerHashMap) {
        this.controllerHashMap = controllerHashMap;
    }
}
