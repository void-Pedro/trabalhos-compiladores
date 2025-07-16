package org.ufscar;

import org.xhtmlrenderer.pdf.ITextRenderer;
import java.io.FileOutputStream;

public class PDFGen {
    public static void createPdfFromHtml(String html, String pdfPath) throws Exception {
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);
        renderer.layout();
        try (FileOutputStream fos = new FileOutputStream(pdfPath)) {
            renderer.createPDF(fos);
        }
    }
}
