package com.darichey.dungeonCrawler.item.stack;

import com.darichey.dungeonCrawler.item.ItemBase;

public class ItemStack {
    /**
     * Number of items in the stack. -1 represents an infinite amount
     */
    public int amount;

    /**
     * Max number of items allowed in the stack
     */
    public static int maxAmount = 128;

    /**
     * Item in the stack
     */
    public ItemBase item;

    public ItemStack(ItemBase item) {
        this.item = item;
        this.amount = -1;
    }

    public ItemStack(ItemBase item, int amount) {
        this(item);
        setAmount(amount);
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount > maxAmount ? maxAmount : amount;
    }

    public void add(ItemStack stack) {
        if (stack.getItem() == this.getItem()) {
            this.setAmount(this.getAmount() + stack.getAmount());
        }
    }

    public ItemBase getItem() {
        return this.item;
    }
}
