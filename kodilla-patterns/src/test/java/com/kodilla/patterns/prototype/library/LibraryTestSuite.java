package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {
    @Test
    public void testGetBooks() {
        //Given
        Library library = new Library("Library 1");
        Book book1 = new Book("SPECIAL BOOK", "John Kowalski", LocalDate.of(1990, 6, 25));
        library.getBooks().add(book1);
        IntStream.iterate(2, n -> n + 1)
                .limit(4)
                .forEach(n -> library.getBooks().add(new Book("Book " + n, "John Kowalski", LocalDate.of(1990, 5, 25))));

        Library library2 = null;
        try {
            library2 = library.shallowCopy();
            library2.setName("Library 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library library3 = null;
        try {
            library3 = library.deepCopy();
            library3.setName("Library 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        library.getBooks().remove(book1);
        //Then
        Assert.assertEquals(4, library.getBooks().size());
        Assert.assertEquals(4, library2.getBooks().size());
        Assert.assertEquals(5, library3.getBooks().size());
    }
}
