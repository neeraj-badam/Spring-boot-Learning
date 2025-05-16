### IOC Container

IoC stands for Inversion of Control, and the IoC Container is a core part of the Spring Framework. 
Its main responsibility is to manage the lifecycle and dependencies of objects, where we call as beans in Spring.
In a Spring Boot application, the IoC container is initialized when the application starts. It:
- Creates beans based on annotations like @Component, @Service, @Repository, or @Configuration
- Resolves and injects dependencies using mechanisms like @Autowired or constructor injection
- Manages the entire lifecycle of these beans – from instantiation to destruction
By doing this, it helps promote loose coupling and separation of concerns, making the application easier to maintain, test, and scale.
In short, instead of manually creating and wiring objects, the Spring IoC container takes over that responsibility, allowing developers to focus more on business logic.

If a bean is created by the IoC container and later not used, who handles its destruction or garbage collection?
In a Spring application, the IoC container is responsible for managing the lifecycle of beans, including their creation and wiring. However, when it comes to destruction and memory cleanup, the responsibility is shared. While Spring does allow developers to define custom destruction logic using annotations like @PreDestroy, the DisposableBean interface, or specifying a destroyMethod in a @Bean definition, the actual process of memory deallocation is handled by the JVM through garbage collection. Once a bean is no longer referenced and is eligible for cleanup, the Java Garbage Collector takes over and reclaims the memory. So essentially, Spring manages the logical lifecycle of the bean, but it’s the JVM that takes care of physical destruction when the bean is no longer needed. It's also worth noting that for prototype-scoped beans, Spring only manages creation, and the full lifecycle, including cleanup, is left to the developer and JVM.

why do we use JPARepository in spring boot 
So, instead or writing the boilerplate code when we extend JPARepository, we can perform CRUD operations by using JPARepository. Like instead of manually writing the SQL or JDBC code to perform common tasks like save, update, find, delete. The JPARepository comes with rich set of ready-to-use method as described previously.

So, If I extend a class with JPARepository, Are you using hibernate here? Or is it the native implementation? 
When we extend JPARepository, we are indirectly using hibernate. While JPARepository is part of Spring Data JPA, which is built on top of JPA specification, However Hibernate is the actual implementation of JPA implementation used by Spring Boot unless explicitly Changed.

okay so what is the difference between spring JPA and hibernate
JPA (Java Persistence API) is a specification provided by Java where Hibernate is a implementation of the JPA specification

Okay, so do you think, like, like hibernate? Do you know something else, something similar, or is it probably hibernate? 
Hibernate is the most commonly used JPA implementation especially because it's the default one and there are other JPA providers like Entity Framework, EclipseLink, OpenJPA.

