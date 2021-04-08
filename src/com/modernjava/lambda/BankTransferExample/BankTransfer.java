package com.modernjava.lambda.BankTransferExample;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

public class BankTransfer {
    public static void main(String[] args) {
        //1/ created an Account Factory interface and bank account class
        //2/ Below, we used the Accunt factory to created an accountFactory
        AccountFactory accountFactory = BankAccount::new;
        //3/ from account factory, created two new bank accounts
        BankAccount studentBankAccount = accountFactory.getBankAccount(1, 50000, "StudentA");
        BankAccount universityBankAccount = accountFactory.getBankAccount(2, 100000, "University");

        //4/ is balance greater than amount we are withdrawing
        BiPredicate<Double, Double> p1 = (balance, amount) -> balance > amount;

        //5/ Biconsumers are used as printers
        BiConsumer<String, Double> printer = (x, y) -> System.out.println(x + y);
        BiConsumer<BankAccount, BankAccount> printer2 = (student, university) ->
                System.out.println("Ending balance of student account " + studentBankAccount.getBalance() +
                        " University account " + universityBankAccount.getBalance());



        // Start the thread
        ExecutorService service = Executors.newFixedThreadPool(10);

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " says :: Executing Transfer");
            try {
                double amount = 1000;

                //6/ check if student account has 1k or more
                if (!p1.test(studentBankAccount.getBalance(), amount)) {
                    printer.accept(Thread.currentThread().getName() + "says :: balance insufficient ", amount);
                    return;
                }

                // while unable to transfer
                while (!studentBankAccount.transfer(universityBankAccount, amount)) {
                    TimeUnit.MILLISECONDS.sleep(100);
                    continue;
                }
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            //7/ if balance sufficient, you can transfer
            printer.accept(Thread.currentThread().getName() + " says transfer is successful: Balance in account  ",
                    universityBankAccount.getBalance());
        });


        for (int i = 0; i < 20; i++) {
            service.submit(t1);
        }
        service.shutdown();

        try {
            while (!service.awaitTermination(24l, TimeUnit.HOURS)) {
                System.out.println("Not Yet. Still waiting for termination");
            }
        } catch (InterruptedException iee) {
            iee.printStackTrace();
        }
        printer2.accept(studentBankAccount, universityBankAccount);
    }
}