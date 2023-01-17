package com.msc.testtech.adventium.entity;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Michael
 */
@Getter
@Setter
public class GenerateLine extends Line {

    private double calculedPrice;

    public GenerateLine(Line line) {
        this.product = line.product;
        this.qte = line.qte;
    }

}
