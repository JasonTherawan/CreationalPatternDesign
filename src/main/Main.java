package main;

import creationalPattern.ConfigBuilder;
import creationalPattern.ConfigFactory;
import creationalPattern.ConfigManager;
import creationalPattern.ConfigRegistry;
import creationalPattern.HttpServiceFactory;
import creationalPattern.ServiceFactory;
import model.ServerConfig;

public class Main {
	
	private static final int ITERATIONS = 1_000_000;
    private static final double BYTES_TO_MB = 1024 * 1024;

	public static void main(String[] args) {
        System.out.println("Running Creational Pattern Analysis for " + ITERATIONS + " iterations...\n");

        // --- Naive Test ---
        System.gc(); // Suggest garbage collection
        long memoryBeforeNaive = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long startTimeNaive = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            new ServerConfig("HTTP", 8080, "localhost", 100);
        }
        long endTimeNaive = System.nanoTime();
        long memoryAfterNaive = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.printf("Naive (`new`): \tTime: %d ms, \tMemory: %.2f MB%n", 
            (endTimeNaive - startTimeNaive) / 1_000_000, (double)(memoryAfterNaive - memoryBeforeNaive) / BYTES_TO_MB);

        // --- Singleton Test ---
        System.gc();
        long memoryBeforeSingleton = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long startTimeSingleton = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            ConfigManager.getInstance();
        }
        long endTimeSingleton = System.nanoTime();
        long memoryAfterSingleton = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.printf("Singleton: \t\tTime: %d ms, \tMemory: %.2f MB%n", 
            (endTimeSingleton - startTimeSingleton) / 1_000_000, (double)(memoryAfterSingleton - memoryBeforeSingleton) / BYTES_TO_MB);

        // --- Factory Method Test ---
        System.gc();
        long memoryBeforeFactory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long startTimeFactory = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            ConfigFactory.createConfig("HTTP");
        }
        long endTimeFactory = System.nanoTime();
        long memoryAfterFactory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.printf("Factory Method: \tTime: %d ms, \tMemory: %.2f MB%n", 
            (endTimeFactory - startTimeFactory) / 1_000_000, (double)(memoryAfterFactory - memoryBeforeFactory) / BYTES_TO_MB);

        // --- Abstract Factory Test ---
        System.gc();
        ServiceFactory httpFactory = new HttpServiceFactory();
        long memoryBeforeAbstractFactory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long startTimeAbstractFactory = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            httpFactory.createConfig();
        }
        long endTimeAbstractFactory = System.nanoTime();
        long memoryAfterAbstractFactory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.printf("Abstract Factory: \tTime: %d ms, \tMemory: %.2f MB%n", 
            (endTimeAbstractFactory - startTimeAbstractFactory) / 1_000_000, (double)(memoryAfterAbstractFactory - memoryBeforeAbstractFactory) / BYTES_TO_MB);

        // --- Builder Test ---
        System.gc();
        long memoryBeforeBuilder = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long startTimeBuilder = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            new ConfigBuilder()
                .setHost("localhost")
                .setPort(8080)
                .build();
        }
        long endTimeBuilder = System.nanoTime();
        long memoryAfterBuilder = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.printf("Builder: \t\tTime: %d ms, \tMemory: %.2f MB%n", 
            (endTimeBuilder - startTimeBuilder) / 1_000_000, (double)(memoryAfterBuilder - memoryBeforeBuilder) / BYTES_TO_MB);

        // --- Prototype Test ---
        System.gc();
        ConfigRegistry registry = new ConfigRegistry();
        long memoryBeforePrototype = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long startTimePrototype = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            try {
				registry.createByClone("DEFAULT_HTTP");
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        long endTimePrototype = System.nanoTime();
        long memoryAfterPrototype = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.printf("Prototype (`clone`): \tTime: %d ms, \tMemory: %.2f MB%n", 
            (endTimePrototype - startTimePrototype) / 1_000_000, (double)(memoryAfterPrototype - memoryBeforePrototype) / BYTES_TO_MB);
    }

}
