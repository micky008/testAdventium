package com.msc.testtech.adventium.services.taxes;

import com.msc.testtech.adventium.entity.GenerateLine;
import com.msc.testtech.adventium.entity.Line;
import com.msc.testtech.adventium.entity.Product;
import com.msc.testtech.adventium.entity.Total;
import com.msc.testtech.adventium.entity.subentity.TaxeType;
import com.msc.testtech.adventium.repository.TaxeRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michael
 */
public class TaxeService {

    private TaxeRepository taxeRepo = new TaxeRepository();

    public Total calculateBill(List<Line> lines) {
        Total total = new Total();
        List<GenerateLine> generatedLines = new ArrayList<>(lines.size());
        for (Line line : lines) {

            double amountNoTax = line.getQte() * line.getProduct().getPrice();
            double taxe = getTaxe(line.getProduct().getTaxeType());
            if (line.getProduct().isImported()) {
                taxe += getTaxe(TaxeType.IMPORT);
            }
            // Pht+somme(arrondi(Pht*t/100))
            double taxeCalculated = line.getProduct().getPrice() * taxe / 100 * line.getQte();
            total.setTaxeAdded(total.getTaxeAdded() + round5(taxeCalculated));
            double fullAmount = round5(amountNoTax + taxeCalculated);
            GenerateLine gl = new GenerateLine(line);
            gl.setCalculedPrice(fullAmount);
            generatedLines.add(gl);
            total.setAllTaxeIncluded(total.getAllTaxeIncluded() + fullAmount);
        }
        total.setGeneratedLines(generatedLines);
        return total;
    }

    private double getTaxe(TaxeType mt) {
        return taxeRepo.getTaxe(mt);
    }

    private double round5(double x) {
        return Math.round(x * 20) / 20.0;
    }

}
