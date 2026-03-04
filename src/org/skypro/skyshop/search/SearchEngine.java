package org.skypro.skyshop.search;

public class SearchEngine {
    public Searchable[] searchablesObjects;

    public SearchEngine(int n) {
        this.searchablesObjects = new Searchable[n];
    }

    public Searchable[] search(String target) {
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
        return similarObjects;
    }

    public Searchable getSearchTerm(String target) throws BestResultNotFound {
        int[] bunchOfSimularities = new int[5];
        Searchable[] objects = this.search(target);
        byte i = 0;
        for (Searchable obj : objects) {
            int index = 0;
            int amountOfSimilarities = 0;
            if (obj == null) {
                continue;
            }
            String objName = obj.searchNameContent();
            int indexOfTarget = objName.indexOf(target, index);
            while (indexOfTarget != -1) {
                amountOfSimilarities++;
                index = indexOfTarget + target.length();
                indexOfTarget = objName.indexOf(target, index);
            }
            bunchOfSimularities[i] = amountOfSimilarities;
            i++;
        }
        int numberOfBestResult = 0;
        int maxAmount = 0;
        for (int j = 0; j < bunchOfSimularities.length; j++) {
            if (maxAmount < bunchOfSimularities[j]) {
                maxAmount = bunchOfSimularities[j];
                numberOfBestResult = j;
            }
        }
        if (objects[numberOfBestResult] == null) {
            throw new BestResultNotFound(target);
        }
        return objects[numberOfBestResult];
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
