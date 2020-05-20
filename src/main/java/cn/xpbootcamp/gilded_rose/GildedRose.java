package cn.xpbootcamp.gilded_rose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void update_quality() {
        for (int i = 0; i < items.length; i++) {
            switch (items[i].getItemType()) {
                case Normal:
                    if (items[i].getQuality() > 0) {
                        items[i].setQuality(items[i].getQuality() - 1);
                    }
                    items[i].setSellIn(items[i].getSellIn() - 1);
                    if (items[i].getSellIn() < 0 && items[i].getQuality() > 0) {
                        items[i].setQuality(items[i].getQuality() - 1);
                    }
                    break;
                case AgedBrie:
                    if (items[i].getQuality() < 50) {
                        items[i].setQuality(items[i].getQuality() + 1);
                    }
                    items[i].setSellIn(items[i].getSellIn() - 1);
                    if (items[i].getSellIn() < 0 && items[i].getQuality() < 50) {
                        items[i].setQuality(items[i].getQuality() + 1);
                    }
                    break;
                case BackstagePasses:
                    if (items[i].getQuality() < 50) {
                        items[i].setQuality(items[i].getQuality() + 1);
                        if (items[i].getSellIn() < 11) {
                            if (items[i].getQuality() < 50) {
                                items[i].setQuality(items[i].getQuality() + 1);
                            }
                        }

                        if (items[i].getSellIn() < 6) {
                            if (items[i].getQuality() < 50) {
                                items[i].setQuality(items[i].getQuality() + 1);
                            }
                        }
                    }
                    items[i].setSellIn(items[i].getSellIn() - 1);

                    if (items[i].getSellIn() < 0) {
                        items[i].setQuality(0);
                    }
                    break;
                case Sulfuras:
                    break;
            }
        }
    }
}
