package com.techbeesolutions.BankAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Scanner;

@RestController
public class AccountController {

    @GetMapping ("/Test")
    public ArrayList<String> Hello()
        {
            ArrayList<String> list = new ArrayList<String>();
            list.add("Hello");
            list.add("Hello");
            list.add("Hello");
            list.add("Hello");
            return list;
        }

    Scanner input = new Scanner(System.in);
    BankUserDB userList = new BankUserDB();

    @GetMapping("/AllUsers")
    public ArrayList<BankUserModel> displayUsers() {
        return userList.displayUserDB();

    }

    @PutMapping("/AddUser")
    public void addUser(@RequestBody BankUserModel user) {
        userList.addUserDB(user);
    }

    @PostMapping("/UpdateUser")
    public void updateUser(String x) {
        userList.updateUserInfoDB(x);
    }

    @DeleteMapping("/RemoveUser")
    public void removeUser(String x) {
        userList.deleteUserDB(x);
    }

}
