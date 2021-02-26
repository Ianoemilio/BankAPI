package com.techbeesolutions.BankAPI;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class BankUserDao {

    Scanner input = new Scanner(System.in);

    ArrayList<BankUserModel> UserAccounts = new ArrayList<>();

    public void addUser(BankUserModel user) {             //create

        UserAccounts.add(user);
        BankUserModel userAcc = UserAccounts.get(UserAccounts.indexOf(user));
        System.out.println("ADDED: " + userAcc.getfName() + "\n\n");
        //for (int i = 0; i < UserAccounts.size(); i++) {
        //    System.out.println(Arrays.toString(UserAccounts.toArray()));
        //}

    }


    public void deleteUser(BankUserModel user) {       //Remove
        System.out.println(UserAccounts.indexOf(user));
        BankUserModel userAcc = UserAccounts.get(UserAccounts.indexOf(user));
        UserAccounts.remove(userAcc);
        System.out.println("DELETE: " + UserAccounts.indexOf(user) + "\n\n");

    }


    public void updateUserInfo(BankUserModel user, String[] params) {          //Update
        BankUserModel userAcc = UserAccounts.get(UserAccounts.indexOf(user));
        userAcc.setfName(Objects.requireNonNull(params[0], "First Name cannot be null"));
        System.out.println("UPDATE: " + userAcc.getfName() + "\n\n");

    }

    public void updateFundWithdraw(BankUserModel user, float withdrawal) {          //Update
        BankUserModel userAcc = UserAccounts.get(UserAccounts.indexOf(user));
        if (userAcc.getBalance() < withdrawal) {
            System.out.println("Insufficient funds.");
        } else {
            userAcc.setBalance(user.getBalance() - withdrawal);
        }
        System.out.println("Balance: " + userAcc.getBalance() + "\n\n");


    }
    public void updateFundDeposit(BankUserModel user, float deposit) {          //Update
        BankUserModel userAcc = UserAccounts.get(UserAccounts.indexOf(user));
        userAcc.setBalance(user.getBalance() + deposit);
        System.out.println("Balance: " + userAcc.getBalance() + "\n\n");

    }


    public void displayUser() {                         //Display
        for (BankUserModel user : UserAccounts) {          //this is the getAll()
            BankUserModel userAcc = UserAccounts.get(UserAccounts.indexOf(user));
            System.out.println("DISPLAY: " + userAcc.getfName() + "\n\n");
            System.out.println("DISPLAY: " + userAcc.getlName() + "\n\n");
            System.out.println("DISPLAY: " + userAcc.getEmail() + "\n\n");
            System.out.println("DISPLAY: " + userAcc.getAccNumber() + "\n\n");
            System.out.println("DISPLAY: " + userAcc.getPhoneNum() + "\n\n");
        }
    }

}
