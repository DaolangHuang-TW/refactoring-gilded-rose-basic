package cn.xpbootcamp.gilded_rose;

public class Item {

    private String name;

    private int sellIn;

    private int quality;

    private ItemType itemType;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        if (name == ItemType.AgedBrie.getName()) {
            this.itemType = ItemType.AgedBrie;
        } else if (name == ItemType.BackstagePasses.getName()) {
            this.itemType = ItemType.BackstagePasses;
        } else if (name == ItemType.Sulfuras.getName()) {
            this.itemType = ItemType.Sulfuras;
        } else {
            this.itemType = ItemType.Normal;
        }
    }

    public String getName() {
        return name;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getQuality() {
        return quality;
    }


    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
