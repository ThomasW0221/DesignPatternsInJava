package io.twinterf;

public class DbSingleton {

    private static volatile DbSingleton instance = null;

    private DbSingleton() {
        // helps guard against reflection / jvm stuff
        if(instance != null) {
            throw new RuntimeException("Use getInstance() method to create");
        }
    }

    public static DbSingleton getInstance() {
        // lazy loading
        if (instance == null) {
            synchronized (DbSingleton.class) {
                if (instance == null) {
                    instance = new DbSingleton();
                }
            }

        }

        return instance;
    }
}
