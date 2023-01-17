package com.msc.testtech.adventium.repository;

import com.msc.testtech.adventium.entity.Product;
import com.msc.testtech.adventium.entity.subentity.TaxeType;

/**
 *
 * @author Michael
 */
public class TaxeRepository {

    public double getTaxe(TaxeType mt) {
        switch (mt) {
            case BOOK:
                return 10;
            case COMMON:
                return 20;
            case FIRST_AID:
                return 0;
            case IMPORT:
                return 5;
            default:
                return 20;
        }
    }

}
