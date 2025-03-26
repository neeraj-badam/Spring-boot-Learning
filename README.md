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
    class Controller{
        private Service service;
        public void setService(Service service){
          this.service = service;
        }
        public void handleRequest(){
          service.doSomething();
        }
    }
