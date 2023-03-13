package test.com.clp.services;


import com.clp.data.DataStorage;
import com.clp.data.InMemoryDataStorage;
import com.clp.entity.User;
import com.clp.services.UserService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions; 

public class UserServiceTest {
	@org.junit.jupiter.api.BeforeEach
    void setUp() {
        DataStorage storage = InMemoryDataStorage.getInstance();
        storage.getUsers().insert(new User("phat", "1234"));
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        DataStorage storage = InMemoryDataStorage.getInstance();
        storage.getUsers().deleteAll();
    }

    @org.junit.jupiter.api.Test
    void login() {
        DataStorage storage = InMemoryDataStorage.getInstance();
        UserService service = new UserService(storage);
//        Assertions.assertFalse(service.login("phat", "143544"));
    }

    @org.junit.jupiter.api.Test
    void loginSuccessfull() {
        DataStorage storage = InMemoryDataStorage.getInstance();
        UserService service = new UserService(storage);
        Assertions.assertTrue(service.login("phat", "1234"));
    }
    
    @org.junit.jupiter.api.Test
    void addUser() {
        DataStorage storage = InMemoryDataStorage.getInstance();
        boolean result = storage.getUsers().insert(new User("phat", "1234"));
        Assertions.assertTrue(result);
        Assertions.assertNotNull(storage.getUsers().getFirst(u -> u.getUserName().equals("phat")));
    }
}
