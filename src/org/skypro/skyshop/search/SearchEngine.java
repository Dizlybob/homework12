package org.skypro.skyshop.search;

public class SearchEngine {
    public Searchable[] searchablesObjects;

    public SearchEngine(int n) {
        this.searchablesObjects = new Searchable[n];
    }

    public void search(String target) {
        Searchable[] similarObjects = new Searchable[5];
        byte a = 0;
        for (int i=0; i< searchablesObjects.length; i++) {
            if (searchablesObjects[i] != null && searchablesObjects[i].searchTerm().contains(target)) {
                similarObjects[a] = searchablesObjects[i];
                a++;
            }
            if (a >= 5) {
                break;
            }
        }
        for (Searchable similarObject : similarObjects) {
            if (similarObject != null) {
                System.out.println(similarObject);
            }
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
