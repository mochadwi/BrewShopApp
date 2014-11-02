package com.arlbrew.brewshop.storage.style;

import com.arlbrew.brewshop.storage.NameComparator;
import com.arlbrew.brewshop.storage.Nameable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BjcpCategory implements Nameable {
    private String name;
    private int number;
    private BjcpGuidelines guidelines;
    private List<CommercialExample> commercialExamples;
    private List<BjcpSubcategory> subcategories;

    public BjcpCategory() {
        name = "";
        subcategories = new ArrayList<BjcpSubcategory>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return number;
    }

    @Override
    public String toString() {
        return getName();
    }

    public BjcpGuidelines getGuidelines() {
        return guidelines;
    }

    public List<CommercialExample> getCommercialExamples() {
        return commercialExamples;
    }

    public List<BjcpSubcategory> getSubcategories() {
        Collections.sort(subcategories, new NameComparator());
        return subcategories;
    }

    public int findSubcategoryIdx(String name) {
        for (BjcpSubcategory category : subcategories) {
            if (category.getName().equals(name)) {
                return subcategories.indexOf(category);
            }
        }
        return -1;
    }

    public BjcpSubcategory findSubcategoryByName(String name) {
        for (BjcpSubcategory category : subcategories) {
            if (category.getName().equals(name)) {
                return category;
            }
        }
        return null;
    }
}
