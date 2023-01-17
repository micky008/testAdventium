package com.msc.testtech.adventium.entity;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Michael
 */
@Getter
@Setter
public class Total {

    private List<GenerateLine> generatedLines;
    private double allTaxeIncluded;
    private double taxeAdded;
    
}
