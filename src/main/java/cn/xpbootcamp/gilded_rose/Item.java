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

    public void updateQuality() {
        switch (itemType) {
            case Normal:
                normalItemUpdateQuality();
                break;
            case AgedBrie:
                agedBrieItemUpdateQuality();
                break;
            case BackstagePasses:
                backstagePassesItemUpdateQuality();
                break;
            case Sulfuras:
                break;
        }
    }

    void normalItemUpdateQuality() {
        if (quality > 0) {
            quality -= 1;
        }
        sellIn -= 1;
        if (sellIn < 0 && quality > 0) {
            quality -= 1;
        }
    }

    void agedBrieItemUpdateQuality() {
        if (quality < 50) {
            quality += 1;
        }
        sellIn -= 1;
        if (sellIn < 0 && quality < 50) {
            quality += 1;
        }
    }

    void backstagePassesItemUpdateQuality() {
        if (quality < 50) {
            quality += 1;
            if (sellIn < 11) {
                if (quality < 50) {
                    quality += 1;
                }
            }

            if (sellIn < 6) {
                if (quality < 50) {
                    quality += 1;
                }
            }
        }
        sellIn -= 1;

        if (sellIn < 0) {
            quality = 0;
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
