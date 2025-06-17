package sn.lamp.dev;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import sn.lamp.dev.controller.UserController;
import sn.lamp.dev.service.TypeContratService;
import sn.lamp.dev.service.UserService;

public class UserTest {
    @InjectMocks
    private UserController userController;
    @Mock
    private UserService userService;

    @Before
    public void setup(){

    }
}
