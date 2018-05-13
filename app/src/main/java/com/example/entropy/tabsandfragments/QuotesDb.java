package com.example.entropy.tabsandfragments;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Quote.class}, version = 1)
public abstract class QuotesDb extends RoomDatabase{
    public abstract QuotesDao quotesDao();

//    @Database(entities = {BookObject.class},version = 2)
//    public abstract  class BooksDatabase extends RoomDatabase {
//        public abstract BooksDao booksDao();
//    }
}
