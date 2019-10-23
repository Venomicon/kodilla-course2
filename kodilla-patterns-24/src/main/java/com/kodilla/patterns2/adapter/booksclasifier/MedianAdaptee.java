package com.kodilla.patterns2.adapter.booksclasifier;

import com.kodilla.patterns2.adapter.booksclasifier.libraryb.Book;
import com.kodilla.patterns2.adapter.booksclasifier.libraryb.BookSignature;
import com.kodilla.patterns2.adapter.booksclasifier.libraryb.BookStatistics;
import com.kodilla.patterns2.adapter.booksclasifier.libraryb.Statistics;

import java.util.Map;

public class MedianAdaptee implements BookStatistics {
    @Override
    public int averagePublicationYear(Map<BookSignature, Book> books) {
        Statistics statistics = new Statistics();
        return statistics.averagePublicationYear(books);
    }

    @Override
    public int medianPublicationYear(Map<BookSignature, Book> books) {
        Statistics statistics = new Statistics();
        return statistics.medianPublicationYear(books);
    }
}
