package demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 扫描类似 UserMapper这些接口所在的包名
@MapperScan("demo")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}
