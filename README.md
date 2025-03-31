### Spring-boot-Learning

### IOC: Inversion of Control -> It's a principle
Controlling all the things in the back, and we just focus on writing business logic.
For Example If we create an object, we should manage the entire lifecycle of the object. We should also destroy the object.

Dependency Injection (DI) -> It's a Design Pattern
Dependency Injection is the actual implementation of IOC

To achieve IOC we use DI.

So, for example in Controller instead of creating an object for service. We just mention the service Spring Framework will give the reference, this is called DI.

Three ways to achieve Dependency Injection:
### 1. Constructor Injection
  Example:
  ```
    In the class we create a service
    class Controller{
        private Service service;
        public Controller(Service service){
          this.service = service;
        }
        public void handleRequest(){
          service.doSomething();
        }
    }
  ```
### 2. Setter Injection
  Example:
    In the class we create a setter to set the service
    ```
    class Controller{
        private Service service;
        public void setService(Service service){
          this.service = service;
        }
        public void handleRequest(){
          service.doSomething();
        }
    }
    ```
### 3. Field Injection
  Example:
  Here we have loosely coupled field where we can use that to call the service
  ```
      class Controller{
        @Autowired
        private Service service;
        public void handleRequest(){
          service.doSomething();
        }
      }
  ```


Previously If we want to run the spring application we use Tomcat to run it. Like we create war(web archive) file to run it on Tomcat.
Spring boot project comes along with Tomcat, where don't need an external server to run an application. Here it creates Jar file.

There are certain issues with Spring boot, It follows Convention over configuration, like it may create a lot of stuff that we don't need.

We need to tell Spring boot, which object to create instead of creating a whole lot of objects by using @Component on top of the class

For Field & Setter Injection @Autowired is required to initialize, but for Constructor, it defaultly use @Autowired

If we use Auto wiring where there is more than one class that implement an interface, then we can use Primary for a class to use Auto wiring or Qualifier("className"), where class name starts with lowercase letter.


In Spring Framework, we use a xml file and define the classes to create in the IOC container, and set variables if needed, autowiring.

To change port use server.port in application.properties
