package com.msc.testtech.adventium.services.output;

import com.msc.testtech.adventium.entity.GenerateLine;
import com.msc.testtech.adventium.entity.Total;

/**
 *
 * @author Michael
 */
class ConsoleOutput implements Output {

    @Override
    public void print(Total total) {

        for (GenerateLine line : total.getGeneratedLines()) {
            System.out.printf("%d %s à %.2f : %.2f€%n", (int)line.getQte(), line.getProduct().getDescription(), line.getProduct().getPrice(), line.getCalculedPrice());
        }
        System.out.printf("Montant des taxes : %.2f€%n", total.getTaxeAdded());
        System.out.printf("Total  : %.2f€%n" , total.getAllTaxeIncluded());
    }

}
