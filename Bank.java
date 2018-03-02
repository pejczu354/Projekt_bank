/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.time.LocalDate;
import java.util.Scanner;


public class Bank {

    public static void main(String[] args) {
        
        Client bank = new Client();
        bank.menu();
        System.out.println("xD");
    }
    
}

class Client{
    private String name,sName,password,choice,login;
    private String birth="1000-01-01";
    private int nrAcc;
    private double currAcc=0;
    private static int i;
    private LocalDate myDate= LocalDate.parse(birth);
    
    
    void menu(){
        Scanner scaner = new Scanner(System.in);
        choice = scaner.nextLine();
        System.out.println("1. Zaloguj do banku.");
        System.out.println("2. Zarejestruj się.");
        System.out.println("3. Wylacz program.");
        
        switch(choice){
            case "1": logIn();
            break;
            case "2":{
                System.out.println("Podaj imie: ");
                name = scaner.nextLine();
                System.out.println("Podaj nazwisko:");
                sName = scaner.nextLine();
                System.out.println("Podaj swoja date urodzenia w formacie yyyy-mm-dd.");
                birth = scaner.nextLine();
                System.out.println("Podaj login, ktorym bedziesz logowal sie do banku.");
                login = scaner.nextLine();
                System.out.println("Podaj haslo do konta.");
                password = scaner.nextLine();
                
                i+=1;
                nrAcc=100000000+i;
                myDate= LocalDate.parse(birth);
                getDataClients(name,sName,password,myDate,login);
            }  
            break;
            case "3": System.exit(1);
            
        }
    }
    
    private void logIn (){ 
        Scanner scaner = new Scanner(System.in);
        String login, password;
        System.out.println("Logowanie do banku.");
        System.out.println("Podaj login: ");
        login = scaner.nextLine();
        System.out.println("Podaj haslo: ");
        password = scaner.nextLine();
        
        if(login.equals(this.login)){
            if(password.equals(this.password)){
                boolean endWhile=true;
                while (endWhile){
                    System.out.println("Zostales zalogowany do banku.");
                    System.out.println("1. Stan konta.");
                    System.out.println("2. Wplac pieniadze na konto.");
                    System.out.println("3. Wyplac pieniadze z konta.");
                    System.out.println("4. Wykonaj przelew.");
                    System.out.println("5. Wyloguj sie z banku.");

                    choice = scaner.nextLine();

                    switch(choice){
                        case "1": getCurrAcc();
                        break;
                        case "2":{ 
                            double money;
                            System.out.println("Podaj ile pieniedzy chcesz wplacic na konto: ");
                            money = scaner.nextDouble();
                            setCurrAcc(money);
                        }
                        break;
                        case "3": System.out.println("Wplac pieniadze na konto.");
                        break;
                        case "4": System.out.println("Wykonaj przelew.");
                        break;
                        case "5": {
                            endWhile=false;
                            logIn();
                        }
                        break;
                        default: System.out.println("Podales nie prawidlowa wartosc.");
                    }
                }
            }
        }
    }

    
    
    private void getDataClients(String name, String sName, String password, LocalDate myDate, String login){
        this.name=name;
        this.sName=sName;
        this.myDate=myDate;
        this.login=login;
        this.password=password;
        System.out.println("Twoje dane: ");
        System.out.println("Imie: "+name);
        System.out.println("Nazwisko: "+sName);
        System.out.println("Data urodzenia: "+myDate);
        System.out.println("Login: "+login);
        System.out.println("Haslo: "+password);
        
    }
    
    private double getCurrAcc(){
        return this.currAcc;
    }
    
    private double setCurrAcc(double money){
        this.currAcc+=money;
        return getCurrAcc();
    }
    
    
}
