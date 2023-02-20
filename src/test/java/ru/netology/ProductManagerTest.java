package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product book1 = new Book(1, "Идиот", 100, "Достоевский" );
    Product book2 = new Book(2, "Горе от ума", 200, "Грибоедов" );
    Product book3 = new Book(3, "Евгений Онегин", 300, "Пушкин" );
    Product smartphone1 = new Smartphone(4, "Iphone", 400, "Apple" );
    Product smartphone2 = new Smartphone(5, "Galaxy", 500, "Samsung" );

    @Test
    public void shouldSearchOneResult() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] expected = {book3};
        Product[] actual = manager.searchBy("Онегин");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSeveralResults() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] expected = {book1, book2};
        Product[] actual = manager.searchBy("от");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNoResult() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Счастье");

        Assertions.assertArrayEquals(expected, actual);
    }
}
