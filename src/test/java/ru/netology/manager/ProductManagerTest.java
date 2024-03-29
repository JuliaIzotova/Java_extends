package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.data.Book;
import ru.netology.data.Product;
import ru.netology.data.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private final ProductRepository repository = new ProductRepository();
    private final ProductManager manager = new ProductManager(repository);


    Book book1 = new Book(1, "Бэтмен.Темный рыцарь", 700, "Человек-паук");
    Book book2 = new Book(2, "Бэтмен. Долгий Хэллуин", 800, "Человек-паук");
    Book book3 = new Book(3, "Бэтмэн. Бэтмэн возвращается", 900, "Человек-паук");
    Smartphone phone1 = new Smartphone(11, "Iphone 12", 100_000, "Apple");
    Smartphone phone2 = new Smartphone(22, "Iphone 13", 150_000, "Apple");
    Smartphone phone3 = new Smartphone(33, "Iphone 14", 200_000, "Apple");


    @Test
        //  добавить  товары
    void addProducts() {
        manager.add(book1);
        manager.add(book2);
        repository.save(phone1);
        repository.save(phone2);
        manager.add(phone3);

        Product[] expected = {book1, book2, phone1, phone2, phone3};
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);

    }

    @Test
        // найти книгу по айди
    void findById() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);

        Product expected = book3;
        Product actual = manager.findById(3);
        assertEquals(expected, actual);
    }


    @Test
        // удалить по айди
    void removeById() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);

        manager.removeById(2);
        manager.removeById(33);

        Product[] expected = {book1, book3, phone1, phone2};
        Product[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
        //найти все товары
    void findAll() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);

        Product[] expected = {book1, book2, book3, phone1, phone2, phone3};
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);

    }

    @Test
        // найти по названию книгу
    void findByNameBook() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);

        Product[] expected = {book3};
        Product[] actual = manager.searchBy("Бэтмэн. Бэтмэн возвращается");

        assertArrayEquals(expected, actual);

    }


    @Test
        // удалить по айди через репо
    void removeById2() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);

        repository.removeById(33);


        Product[] expected = {book1, book2, book3, phone1, phone2};
        Product[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
        // найти определенную модель
    void findByName() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);

        Product[] expected = {phone2};
        Product[] actual = manager.searchBy("Iphone 13");
        assertArrayEquals(expected, actual);
    }


    @Test
        // найти книгу которой нет в списке
    void findBookOutOfList() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);

        Product[] expected = {};
        Product[] actual = manager.searchBy("book4");
        assertArrayEquals(expected, actual);
    }

    @Test
        // найти по несуществующему айди
    void findByUnCorrectId() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);

        Product actual = manager.findById(333);
        assertNull(actual);

    }

    @Test
    void findAllSmartphones() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);

        Product[] expected = {phone1, phone2, phone3};
        Product[] actual = manager.searchBy("phone");
        assertArrayEquals(expected, actual);
    }

    @Test
    void findByIdPhone() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);

        Product expected = phone3;
        Product actual = repository.findById(33);
        assertEquals(expected, actual);
    }

    @Test
    void findSamsung() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }

}