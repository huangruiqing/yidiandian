### Boot
- 1、搭建Web  
- 2、RESTful  
- 3、thymeleaf  
idea 遇到html修改 关闭缓存不生效，加入boot-devps-tool  
 需要Bulid xxx.html    
- 4、swagger  在启动类同等级目录下建Swagger  
访问 localhost/swagger-ui.html
```java
@Configuration
@EnableSwagger2
class Swagger2{
 @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
             .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("向 DD 学习：http://blog.didispace.com/")
            //    .termsOfServiceUrl("https://github.com/huangruiqing/yidiandian")
                .contact(new Contact("huangruiqing","https://github.com/huangruiqing/yidiandian","email"))
                .version("1.0")
                .build();
    }
  }  
```
- 5、freemaker 作为模板
- 6、 boot 测试 
 @Before setUp() 新建MockMvc 通过 MockMvcBulifer.  
 mvc.perfom(创建请求路径可以指定请求方式 get post...)
- 7、内存数据库 H2 依赖 jpa h2 
```java
public interface DemoInfoRepository extends CrudRepository<DemoInfo, Long>{}
@Entity
public class DemoInfo {
    @Id@GeneratedValue
    private Long id;
}
```
 

[JdcbTemplate Api](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/jdbc/core/JdbcTemplate.html)
````
 注：如果在docker里面运行在jar同目录下放config目录也是读取不到的，Dockerfile里需要加上一句：ADD config/ /config/
然后读出来的路径是：//config/application.properties
//config/application.properties
/config/application.properties (No such file or directory)
docker config里面的配置文件优先级比jar包的高，会覆盖jar包里默认的配置，部署到其他服务器环境只需要修改对应配置就可以了
Dockerfile配置里需要加上：ADD config/ /config/
springboot读取外部配置文件的方法，如下优先级：
第一种是在执行命令的目录下建config文件夹。（在jar包的同一目录下建config文件夹，执行命令需要在jar包目录下才行），然后把配置文件放到这个文件夹下。
第二种是直接把配置文件放到jar包的同级目录。
第三种在classpath下建一个config文件夹，然后把配置文件放进去。
第四种是在classpath下直接放配置文件。
springboot默认是优先读取它本身同级目录下的一个config/application.properties 文件的。
在src/main/resources 文件夹下创建的application.properties 文件的优先级是最低的
所以springboot启动读取外部配置文件，只需要在外面加一层配置文件覆盖默认的即可，不用修改代码。
````
