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

    public void updateQuality() {
        switch (itemType) {
            case Normal:
                if (quality > 0) {
                    quality -= 1;
                }
                sellIn -= 1;
                if (sellIn < 0 && quality > 0) {
                    quality -= 1;
                }
                break;
            case AgedBrie:
                if (quality < 50) {
                    quality += 1;
                }
                sellIn -= 1;
                if (sellIn < 0 && quality < 50) {
                    quality += 1;
                }
                break;
            case BackstagePasses:
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
                break;
            case Sulfuras:
                break;
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
