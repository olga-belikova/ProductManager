package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    Product book1 = new Book(1, "Идиот", 100, "Достоевский");
    Product book2 = new Book(2, "Горе от ума", 200, "Грибоедов");
    Product book3 = new Book(3, "Евгений Онегин", 300, "Пушкин");
    Product smartphone1 = new Smartphone(4, "Iphone", 400, "Apple");
    Product smartphone2 = new Smartphone(5, "Galaxy", 500, "Samsung");

    @Test
    public void shouldSaveRemoveReturn() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.removeById(book3.getId());

        Product[] expected = {book1, book2, smartphone1, smartphone2};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }
}
