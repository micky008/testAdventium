package com.msc.testtech.adventium.entity;

import com.msc.testtech.adventium.entity.subentity.TaxeType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Michael
 */
@Getter
@Setter
@NoArgsConstructor
public class Product {
    
    protected double price;
    protected boolean isImported;
    protected String description;
    protected TaxeType taxeType = TaxeType.COMMON;
    
    protected Product(TaxeType tt) {
        this.taxeType = tt;
    }
    
    

}
