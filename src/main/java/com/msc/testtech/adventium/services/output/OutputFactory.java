package com.msc.testtech.adventium.services.output;

/**
 *
 * @author Michael
 */
public class OutputFactory {

    public enum OutputType {
        CONSOLE, PDF;
    }

    //TODO setting this in real setup default factory (with config File for exemple)
    private Output outputConsole = new ConsoleOutput();
    private Output outputPdf = new PdfOutput();

    public Output getDefaultOutput() {
        return outputPdf;
    }

    public Output specificOutput(OutputType ot) {
        switch (ot) {
            case CONSOLE:
                return outputConsole;
            case PDF:
                return outputPdf;
            default:
                return outputPdf;
        }
    }

}
