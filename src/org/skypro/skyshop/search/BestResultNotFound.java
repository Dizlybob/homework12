package org.skypro.skyshop.search;

public class BestResultNotFound extends Exception {

    public String name;

    public BestResultNotFound(String name) {
      super(name);
    }

    @Override
    public String toString() {
      return "BestResultNotFound{" +
              "Не было найдено лучшего результата по запросу '" + name + "'!}";
    }
}
