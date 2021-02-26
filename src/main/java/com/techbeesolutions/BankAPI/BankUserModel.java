package com.techbeesolutions.BankAPI;

import java.util.Scanner;

public class BankUserModel {


    public BankUserModel(int accNumber, String fName, String lName) {
        this.accNumber = accNumber;
        this.fName = fName;
        this.lName = lName;
    }

    public BankUserModel() {
        this.accNumber = accNumber;
        this.balance = balance;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phoneNum = phoneNum;
    }

    Scanner input = new Scanner(System.in);

    private int accNumber;
    private float balance;
    private String fName;
    private String lName;
    private String email;
    private String phoneNum;
    private float depositAmount;
    private float withdrawAmount;

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {

        this.phoneNum = phoneNum;
        while (this.phoneNum.length() != 10) {
            System.out.println("Invalid Phone Number");
            this.phoneNum = input.nextLine();
        }
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {

        this.accNumber = accNumber;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {

        this.balance = balance;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
        while (this.fName.length() <= 1) {
            System.out.println("Invalid First Name: ");
            this.fName = input.nextLine();
        }
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
        while (this.lName.length() <= 1) {
            System.out.println("Invalid Last Name: ");
            this.lName = input.nextLine();
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getWithdrawAmount() { //i created getters for these but these aren't being used.
        return withdrawAmount;
    }

    public void setWithdrawAmount(float withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
        if (withdrawAmount > this.getBalance()) {
            System.out.println("Insufficient Funds");
        }
        else {
            this.setBalance(this.getBalance() - withdrawAmount);
        }
    }

    public float getDepositAmount() {   //Maybe it can be used to show the history of deposits and withdrawals
        return depositAmount;
    }

    public void setDepositAmount(float depositAmount) {
        this.depositAmount = depositAmount;
        this.setBalance(depositAmount+this.getBalance());
    }
}
