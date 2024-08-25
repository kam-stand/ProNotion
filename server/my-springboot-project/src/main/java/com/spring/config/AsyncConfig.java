// package com.spring.config;

// import java.util.concurrent.Executor;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.scheduling.annotation.AsyncConfigurer;
// import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
// import org.springframework.security.task.DelegatingSecurityContextAsyncTaskExecutor;

// @Configuration
// public class AsyncConfig implements AsyncConfigurer {

//     @Override
//     public Executor getAsyncExecutor() {
//         ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//         executor.setCorePoolSize(5);
//         executor.setMaxPoolSize(10);
//         executor.setQueueCapacity(25);
//         executor.initialize();
//         return new DelegatingSecurityContextAsyncTaskExecutor(executor);
//     }
// }
