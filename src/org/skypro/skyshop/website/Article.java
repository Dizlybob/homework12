package org.skypro.skyshop.website;
import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable{
    private final String articleName;
    private final String articleText;

    public Article(String articleName, String articleText) {
        this.articleName = articleName;
        this.articleText = articleText;
    }

    @Override
    public String toString() {
        return articleName + " " + articleText;
    }

    @Override
    public String searchTerm() {
        return this.toString();
    }

    @Override
    public String searchTypeContent() {
        return "ARTICLE";
    }

    @Override
    public String searchNameContent() {
        return articleName;
    }
}
