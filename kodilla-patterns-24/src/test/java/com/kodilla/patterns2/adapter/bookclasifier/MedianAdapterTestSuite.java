package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.booksclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.booksclasifier.librarya.Book;
import org.junit.*;

import java.util.HashSet;
import java.util.Set;

public class MedianAdapterTestSuite {
    @Test
    public void testPublicationYearMedian() {
        //Given
        Set<Book> bookSet = new HashSet<>();
        for (int n = 1; n <= 20; n++) {
            bookSet.add(new Book("Author", "title "+n, 2000 + n, "Signature " + n));
        }
        MedianAdapter adapter = new MedianAdapter();
        //When
        int median = adapter.publicationYearMedian(bookSet);
        //Then
        Assert.assertEquals(2011, median);
    }
}
