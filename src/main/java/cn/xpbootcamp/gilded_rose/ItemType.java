package cn.xpbootcamp.gilded_rose;

public enum ItemType {
    AgedBrie("Aged Brie"),
    BackstagePasses("Backstage passes to a TAFKAL80ETC concert"),
    Sulfuras("Sulfuras, Hand of Ragnaros"),
    Normal("Any")
    ;
    private final String name;
    ItemType(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}
