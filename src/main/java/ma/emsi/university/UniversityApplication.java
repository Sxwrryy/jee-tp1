package ma.emsi.university;

import ma.emsi.university.entities.Product;
import ma.emsi.university.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UniversityApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(UniversityApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product(1, "Laptop", 100, 100));
        productRepository.save(new Product(2, "Phone", 548, 800));
        productRepository.save(new Product(3, "Books", 320, 541));

        List<Product> productList= productRepository.findByNameContains("L");
        productList.forEach(p->{
            System.out.println(p);
        });
    }
}
