package com.kodilla.patterns2.adapter.booksclasifier;

import com.kodilla.patterns2.adapter.booksclasifier.librarya.Book;
import com.kodilla.patterns2.adapter.booksclasifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.booksclasifier.libraryb.BookSignature;

import java.util.HashMap;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {
    @Override
    public int publicationYearMedian(Set<Book> bookSet) {
        HashMap<BookSignature, com.kodilla.patterns2.adapter.booksclasifier.libraryb.Book> bookMap = new HashMap<>();
        for (Book book : bookSet) {
            bookMap.put(new BookSignature(book.getSignature()),
                    new com.kodilla.patterns2.adapter.booksclasifier.libraryb.Book(book.getAuthor(),
                            book.getTitle(),
                            book.getPublicationYear()));
        }
        return medianPublicationYear(bookMap);
    }
}
