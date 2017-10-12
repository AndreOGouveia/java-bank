package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.services.AuthService;
import org.academiadecodigo.javabank.view.View;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class LoginControllerTest {

    private LoginController loginController;
    private View view;

    @Before
    public void setup(){
        loginController = new LoginController();
        view = mock(View.class);
        loginController.setView(view);
    }

    @Test // tests if init is working
    public void initTest(){

        loginController.init();

        verify(view).show();

    }

    @Test
    public void onLoginSuccessTest(){

        Controller mockController = mock(Controller.class);
        loginController.setNextController(mockController);
        AuthService mockAuth = mock(AuthService.class);
        loginController.setAuthService(mockAuth);

        when(mockAuth.authenticate(5)).thenReturn(true);
        loginController.onLogin(5);

        verify(mockController).init();
        verify(view,never()).show();

    }

    @Test
    public void onLoginFailTest(){

        Controller mockController = mock(Controller.class);
        loginController.setNextController(mockController);
        AuthService mockAuth = mock(AuthService.class);
        loginController.setAuthService(mockAuth);

        when(mockAuth.authenticate(anyInt())).thenReturn(false);
        loginController.onLogin(6);

        verify(mockController,never()).init();
        verify(view).show();



    }






}
