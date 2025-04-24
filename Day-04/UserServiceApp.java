package Exceptions;

import java.util.HashSet;
import java.util.Set;

public class UserServiceApp {

    public static void main(String[] args) {
        UserService service = new UserService();

        try {
            service.registerUser("john");
            service.registerUser("john"); // This will throw UserAlreadyExistsException
        } catch (UserAlreadyExistsException e) {
            System.out.println("Registration Error: " + e.getMessage());
        }

        try {
            service.checkUserExistence("alice"); // This will throw UserNotFoundException
        } catch (UserNotFoundException e) {
            System.out.println("Existence Check Error: " + e.getMessage());
        }
    }
}

class UserService {
    private Set<String> registeredUsers = new HashSet<>();

    public void registerUser(String username) throws UserAlreadyExistsException {
        if (registeredUsers.contains(username)) {
            throw new UserAlreadyExistsException("User '" + username + "' already exists.");
        }
        registeredUsers.add(username);
        System.out.println("User '" + username + "' registered successfully.");
    }

    public void checkUserExistence(String username) throws UserNotFoundException {
        if (!registeredUsers.contains(username)) {
            throw new UserNotFoundException("User '" + username + "' not found.");
        }
        System.out.println("User '" + username + "' exists.");
    }
}

class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}

class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}
