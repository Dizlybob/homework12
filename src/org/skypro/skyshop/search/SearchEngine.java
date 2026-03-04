package org.skypro.skyshop.search;

import java.util.ArrayList;

public class SearchEngine {
    public ArrayList<Searchable> searchablesObjects;

    public SearchEngine() {
        this.searchablesObjects = new ArrayList<>();
    }

    public ArrayList<Searchable> search(String target) {
        ArrayList<Searchable> similarObjects = new ArrayList<>();
        for (Searchable object : searchablesObjects) {
            if (object != null && object.searchTerm().contains(target)) {
                similarObjects.add(object);
            }
        }
        return similarObjects;
    }

    public Searchable getSearchTerm(String target) throws BestResultNotFound {
        ArrayList<Integer> bunchOfSimularities = new ArrayList<>();
        ArrayList<Searchable> objects = this.search(target);
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
            bunchOfSimularities.add(amountOfSimilarities);
        }
        int numberOfBestResult = 0;
        int maxAmount = 0;
        int j = 0;
        for (int num  : bunchOfSimularities) {
            if (maxAmount < num) {
                maxAmount = num;
                numberOfBestResult = j;
            }
            j++;
        }
        if (maxAmount == 0) {
            throw new BestResultNotFound(target);
        }
        return objects.get(numberOfBestResult);
    }

    public void add(Searchable obj) {
        searchablesObjects.add(obj);
    }
}
