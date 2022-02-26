package org.springframework.test.bean;

import org.springframework.stereotype.Component;

/**
 * @author cuzz
 * @date 2022/2/25 20:37
 */
@Component
public class Book {


    private String title;

    public Book() {
    }
    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                '}';
    }
}
