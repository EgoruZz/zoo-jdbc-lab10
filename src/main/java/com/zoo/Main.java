package com.zoo;

import com.zoo.config.ConnectionManager;
import com.zoo.service.BatchInsertService;
import com.zoo.service.BusinessQueryService;
import com.zoo.service.CrudDemoService;
import com.zoo.service.TransactionService;

public class Main {

    public static void main(String[] args) {

        System.out.println(
                "=== ZOO JDBC LAB10 FULL RUN ==="
        );

        try {

            new CrudDemoService().run();

            BatchInsertService.run();

            TransactionService.run();

            BusinessQueryService.run();

            System.out.println(
                    "=== ALL TASKS COMPLETED ==="
            );

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            ConnectionManager.shutdown();

            System.out.println(
                    "Datasource closed"
            );
        }
    }
}