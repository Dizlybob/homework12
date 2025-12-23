package org.skypro.skyshop.search;

public class SearchEngine {
    public Searchable[] searchablesObjects;

    public SearchEngine(int n) {
        this.searchablesObjects = new Searchable[n];
    }

    public void search(String target) {
        Searchable[] searchables = new Searchable[5];
        byte a = 0;
        for (int i=0; i< searchablesObjects.length; i++) {
            if (searchablesObjects[i] != null && searchablesObjects[i].searchTerm().contains(target)) {
                searchables[a] = searchablesObjects[i];
                a++;
            }
            if (a > 4) {
                break;
            }
        }
        if (searchables[0] != null) {
            System.out.println(searchables[0].toString());
        }
        if (searchables[1] != null) {
            System.out.println(searchables[1].toString());
        }
        if (searchables[2] != null) {
            System.out.println(searchables[2].toString());
        }
        if (searchables[3] != null) {
            System.out.println(searchables[3].toString());
        }
        if (searchables[4] != null) {
            System.out.println(searchables[4].toString());
        }
    }

    public void add(Searchable obj) {
        for (int i = 0; i < searchablesObjects.length; i++) {
            if (searchablesObjects[i] == null) {
                searchablesObjects[i] = obj;
                System.out.println("Добавлено");
                return;
            }
        }
        System.out.println("Нет мест");
    }
}
