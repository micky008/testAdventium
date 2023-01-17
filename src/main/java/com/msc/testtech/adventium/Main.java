package com.msc.testtech.adventium;

import com.msc.testtech.adventium.entity.Line;
import com.msc.testtech.adventium.entity.Product;
import com.msc.testtech.adventium.entity.Total;
import com.msc.testtech.adventium.entity.subentity.Book;
import com.msc.testtech.adventium.entity.subentity.FirstAid;
import com.msc.testtech.adventium.services.output.OutputFactory;
import com.msc.testtech.adventium.services.taxes.TaxeService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michael
 */
public class Main {

    private Product createProd(boolean imported, String descr, double price) {
        Product p = new Product();
        p.setDescription(descr);
        p.setImported(imported);
        p.setPrice(price);
        return p;
    }

    private Book createLivre(boolean imported) {
        Book book = new Book();
        book.setDescription("livre");
        book.setImported(imported);
        book.setPrice(12.49);
        return book;
    }

    private FirstAid createFirstAid(boolean imported, String descr, double price) {
        FirstAid fa = new FirstAid();
        fa.setDescription(descr);
        fa.setImported(imported);
        fa.setPrice(price);
        return fa;
    }

    private List<Line> input1() {
        List<Line> lines = new ArrayList<>(3);
        Line l1 = new Line();
        l1.setProduct(createLivre(false));
        l1.setQte(2);

        Line l2 = new Line();
        l2.setProduct(createProd(false, "CD Musical", 14.99));
        l2.setQte(1);

        Line l3 = new Line();
        l3.setProduct(createFirstAid(false, "barres de chocolat importées", 0.85));
        l3.setQte(3);

        lines.add(l1);
        lines.add(l2);
        lines.add(l3);

        return lines;
    }

    private List<Line> input2() {
        List<Line> lines = new ArrayList<>(3);
        Line l1 = new Line();
        l1.setProduct(createFirstAid(true, "boites de chocolats", 10));
        l1.setQte(2);

        Line l2 = new Line();
        l2.setProduct(createProd(true, "flacons de parfum", 47.50));
        l2.setQte(3);

        lines.add(l1);
        lines.add(l2);
        return lines;
    }

    private List<Line> input3() {
        List<Line> lines = new ArrayList<>(4);
        Line l1 = new Line();
        l1.setProduct(createProd(true, "flacons de parfum", 27.99));
        l1.setQte(2);

        Line l2 = new Line();
        l2.setProduct(createProd(false, "flacons de parfum", 18.99));
        l2.setQte(1);

        Line l3 = new Line();
        l3.setProduct(createFirstAid(false, "pilules contre la migraine", 9.75));
        l3.setQte(3);

        Line l4 = new Line();
        l4.setProduct(createFirstAid(true, "boites de chocolats", 11.25));
        l4.setQte(2);

        lines.add(l1);
        lines.add(l2);
        lines.add(l3);
        lines.add(l4);

        return lines;

    }

    private void go1() {
        List<Line> lines = input1();
        totalAndPrint("input1",lines);
    }

    private void go2() {
        List<Line> lines = input2();
        totalAndPrint("input2",lines);
    }

    private void go3() {
        List<Line> lines = input3();
        totalAndPrint("input3",lines);
    }

    private void totalAndPrint(String header,  List<Line> lines) {

        TaxeService ts = new TaxeService();
        Total t = ts.calculateBill(lines);

        OutputFactory of = new OutputFactory();
        System.out.println(header);
        of.specificOutput(OutputFactory.OutputType.CONSOLE).print(t);
        System.out.println();

    }

    public void launch() {
        go1();
        go2();
        go3();
    }

    public static void main(String[] args) {
        new Main().launch();
    }
}
