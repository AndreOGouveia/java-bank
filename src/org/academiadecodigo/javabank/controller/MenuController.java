package org.academiadecodigo.javabank.controller;
import org.academiadecodigo.javabank.model.Bank;
import org.academiadecodigo.javabank.view.MenuView;

import java.util.HashMap;
import java.util.Map;

public class MenuController extends AbstractController {

    private Map<Integer,Controller> controllerHashMap = new HashMap<Integer, Controller>();
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

        setNextController(controllerHashMap.get(controllerHashMapId));
        nextController.init();
    }

    public void setControllerHashMap(Map<Integer, Controller> controllerHashMap) {
        this.controllerHashMap = controllerHashMap;
    }
}
