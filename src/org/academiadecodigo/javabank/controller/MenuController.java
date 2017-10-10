package org.academiadecodigo.javabank.controller;
import org.academiadecodigo.javabank.services.CustomerService;
import org.academiadecodigo.javabank.view.MenuView;

import java.util.HashMap;
import java.util.Map;

public class MenuController extends AbstractController {

    private Map<Integer,Controller> controllerHashMap = new HashMap<Integer, Controller>();
    private MenuView menuView;

    public MenuController(CustomerService customerService) {
        super(customerService);
    }


    public void init(){
        menuView.show();
        nextController.init();
    }



    public void setMenuView(MenuView menuView) {
        this.menuView = menuView;
    }

    public void chosenOption(int option){

        setNextController(controllerHashMap.get(option));


    }

    public void setControllerHashMap(Map<Integer, Controller> controllerHashMap) {
        this.controllerHashMap = controllerHashMap;
    }
}
