package org.skypro.skyshop.search;

public interface Searchable {
    String searchTerm();

    String searchTypeContent();

    String searchNameContent();

    default String getStringRepresentation(){
        return "Имя: " + searchNameContent() + " Тип: " + searchTypeContent();
    }
}
