package com.cs250.joanne.bookshare;

import java.lang.String;

/**
 * Holds data for one item
 */
public class Book {
    private String what;
    private String title;
    private String author;
    private boolean avail;

    Book(String t, String a) {
        this.title = t;
        this.author = a;
        this.avail = true;
    }

    @Override
    public String toString() {
        return "\"" + this.title + "\"\n" + this.author;
    }

   public void setWhat(String w) {
        this.what = what;
    }

    public String getWhat() { return what; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    public boolean isAvail() { return avail; }
    public void setAvail(int a) { avail = a == 1; }

}
