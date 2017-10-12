package org.academiadecodigo.javabank.controller;

import net.bytebuddy.implementation.bytecode.Throw;
import org.academiadecodigo.javabank.services.AuthService;
import org.academiadecodigo.javabank.view.UserOptions;
import org.academiadecodigo.javabank.view.View;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

public class MainControllerTest {

    private MainController mainController;
    private View view;
    private Controller c1;
    private Controller c2;


    @Before
    public void setup() {
        mainController = new MainController();
        view = mock(View.class);
        mainController.setView(view);

         c1 = mock(Controller.class);
         c2 = mock(Controller.class);
        Map<Integer, Controller> map = new HashMap<>();
        map.put(1, c1);
        map.put(2, c2);
        mainController.setControllerMap(map);

    }

    @Test
    public void onMenuSelectionQuit() {
        UserOptions userOptions = mock(UserOptions.class);
        when(userOptions.QUIT.getOption()).thenReturn(5);

        Map<Integer,Controller> mockMap = mock(Map.class);
        mainController.setControllerMap(mockMap);

        mainController.onMenuSelection(userOptions.QUIT.getOption());

        verify(mockMap, never()).containsKey(anyInt());



    }




    }




}
