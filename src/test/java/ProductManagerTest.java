import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    Book firstBook = new Book(1, "firstBook", 100, "FirstAuthor");
    Book secondBook = new Book(2, "secondBook", 150, "SecondAuthor");
    Book thirdBook = new Book(3, "bestProduct", 200, "ThirdAuthor");
    Smartphone firstPhone = new Smartphone(4, "firstPhone", 1000, "FirstCompany");
    Smartphone secondPhone = new Smartphone(5, "bestProduct", 1500, "SecondPhone");
    Smartphone thirdPhone = new Smartphone(6, "thirdPhone", 2000, "ThirdPhone");
    private Product food = new Product(7, "Молоко", 30);

    @Test
    void searchBookByName() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);

        Product[] actual = manager.searchBy("secondBook");
        Product[] expected = {secondBook};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBookByAuthor() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);

        Product[] actual = manager.searchBy("ThirdAuthor");
        Product[] expected = {thirdBook};

        assertArrayEquals(expected, actual);
    }


    @Test
    void searchPhoneByName() {
        manager.add(firstPhone);
        manager.add(secondPhone);
        manager.add(thirdPhone);

        Product[] actual = manager.searchBy("thirdPhone");
        Product[] expected = {thirdPhone};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchPhoneByCompany() {
        manager.add(firstPhone);
        manager.add(secondPhone);
        manager.add(thirdPhone);

        Product[] actual = manager.searchBy("SecondPhone");
        Product[] expected = {secondPhone};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchWhenBookAndPhoneSomeDate() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);
        manager.add(firstPhone);
        manager.add(secondPhone);
        manager.add(thirdPhone);

        Product[] actual = manager.searchBy("bestProduct");
        Product[] expected = {thirdBook, secondPhone};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchWhenNoMatch() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);
        manager.add(firstPhone);
        manager.add(secondPhone);
        manager.add(thirdPhone);

        Product[] actual = manager.searchBy("fourth");
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchWithoutValue() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);
        manager.add(firstPhone);
        manager.add(secondPhone);
        manager.add(thirdPhone);

        Product[] actual = manager.searchBy("");
        Product[] expected = {firstBook, secondBook, thirdBook, firstPhone, secondPhone, thirdPhone};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchNoBookNoPhone() {

        Product[] actual = manager.searchBy("wood");
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }


    @Test
    void noSearchByObject() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);
        manager.add(firstPhone);
        manager.add(secondPhone);
        manager.add(thirdPhone);
        manager.add(food);

        Product[] actual = manager.searchBy("milk");
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }
}