package com.example.entropy.tabsandfragments;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface QuotesDao {

    @Insert
    public void addQuote(Quote quote);

    @Query("select * from quotes")
    public List<Quote> getQuotes();

//fix this
//    @Query("select * from books  WHERE title LIKE 'userQuery' OR author LIKE 'userQuery' OR keywords LIKE 'userQuery' OR year LIKE 'userQuery' ")
//    public List <BookObject> searchBooks(String userQuery);

    @Query ("delete from quotes where id ==:thisId")
    void deleteQuote(int thisId);

}
