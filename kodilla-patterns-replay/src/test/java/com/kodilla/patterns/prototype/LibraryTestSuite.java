package com.kodilla.patterns.prototype;

import com.kodilla.patterns.prototype.library.Book;
import com.kodilla.patterns.prototype.library.Library;
import org.junit.*;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {
    @Test
    public void testGetBooks() {
        //Given
        Book book = new Book("111", "222", LocalDate.of(200, 5, 10));
        Library library = new Library("Library 1");
        library.getBooks().add(book);
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> library.getBooks().add(new Book("Title " + n, "author", LocalDate.of(1996, 5, 20))));

        //When
        Library shallowCopied = null;
        Library deepCopied = null;
        try {
            shallowCopied = library.shallowCopy();
            deepCopied = library.deepCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        library.getBooks().remove(library.getBooks().remove(book));
        //Then
        Assert.assertEquals(10, library.getBooks().size());
        Assert.assertEquals(10, shallowCopied.getBooks().size());
        Assert.assertEquals(11, deepCopied.getBooks().size());
    }

}
