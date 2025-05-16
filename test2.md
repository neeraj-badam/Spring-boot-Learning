### Communication between two Microservices
There are a couple of ways to communicate between the microservices where we can use Kafka, RabbitMQ, Amazon SQS, Google Pub/Sub.
We can also use restTemplate, WebClient
Department department = restTemplate.getForObject("http://department-service/departments/" + deptId, Department.class);
WebClient.create()
    .get()
    .uri("http://department-service/departments/" + deptId)
    .retrieve()
    .bodyToMono(Department.class);
We can also handle this using reactive programming — by using Spring WebFlux or WebClient.

### Have you used a Zoo keeper with the Kafka
Yes, I’ve used Kafka with ZooKeeper, especially in older versions where it was required for broker coordination and leader election. ZooKeeper managed metadata and kept the Kafka cluster in sync. But with newer Kafka versions (2.8+), Kafka supports KRaft mode, which removes the need for ZooKeeper. So I'm familiar with both setups.

### What is saga design pattern?
The Saga pattern is used to maintain data consistency across distributed microservices without using traditional transactions. It breaks a big transaction into smaller local transactions, and if any step fails, it triggers compensating actions to roll back.
Primarily, I have worked with choreography not with the orchestration

### Can you tell me what is string Constant pool.
The String Constant Pool is a special memory area in Java inside the heap, where all string literals are stored. When you create a string like "Hello", Java checks the pool first — if the string already exists, it reuses the same object instead of creating a new one. This improves memory efficiency and performance since strings are immutable and used frequently.

### what are different, you know, memory types, or memories in which Java support,
So, there are different memories like
Heap Memory, where it Stores all objects and class instances
Stack Memory, which Stores method calls, local variables, and reference pointers
Method Area is used to Store class metadata, static variables
Program Counter (PC) Register, which Keeps track of the current executing instruction in each thread
Native Method Stack

### Have you heard about CopyOnWriteArrayList?
Yes, I’m familiar with CopyOnWriteArrayList. It’s a thread-safe version of ArrayList that’s optimized for read-heavy, write-light scenarios. When a modification happens — like add or remove — it creates a new copy of the entire array, so readers always work with a stable, consistent snapshot without needing to block.
It’s ideal in cases where reads are frequent and writes are rare, like in caching, observer lists, or configuration settings. However, because of the cost of copying on every write, it's not recommended for high-write scenarios.

### list annotations in spring
@Component, @Service, @Repository, @Controller, @RestController, @Controller @Autowired, @Qualifier, @Autowired, @Value, @Bean, @RequestMapping, @GetMapping, @PostMapping, @PathVariable, @RequestParam, @RequestBody, @ResponseBody

### So if I want to use basically spring boot, by default, it comes it generates the job site, right output, okay, yes. So if I create a WAR file, what are the steps I need to follow?
Okay, so by default Spring Boot creates a JAR file with an embedded Tomcat server. First I would change packaging in pom.xml from jar to war, then I Exclude the embedded Tomcat, then I will add scope as provided.
Then Extend SpringBootServletInitializer in your main application class and override the configure method and Finally, build the WAR using mvn clean install
