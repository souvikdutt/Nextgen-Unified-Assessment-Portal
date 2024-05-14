package com.epam.ua.report;

import com.epam.ua.mail.SendMailer;
import com.epam.ua.model.MentorNotification;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HeaderFooter;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.activation.DataSource;
import javax.mail.util.ByteArrayDataSource;
import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExcelGenerateReport {

    private CellStyle cs = null;
    private CellStyle csBold = null;
    private CellStyle csTop = null;
    private CellStyle csRight = null;
    private CellStyle csBottom = null;
    private CellStyle csLeft = null;
    private CellStyle csTopLeft = null;
    private CellStyle csTopRight = null;
    private CellStyle csBottomLeft = null;
    private CellStyle csBottomRight = null;

    public static void main(String[] args) {

        ExcelGenerateReport myReport = new ExcelGenerateReport();
        myReport.createExcel();

    }

    public void createExcel() {

        try {

            Workbook wb = new XSSFWorkbook();
            Sheet sheet = wb.createSheet("Status Report");

            //Setup some styles that we need for the Cells
            setCellStyles(wb);

            //Get current Date and Time
            Date date = new Date(System.currentTimeMillis());
            DateFormat df = new SimpleDateFormat("MM/dd/yy HH:mm:ss");

            //Set Column Widths
            sheet.setColumnWidth(0, 2500);
            sheet.setColumnWidth(1, 2500);
            sheet.setColumnWidth(2, 6000);
            sheet.setColumnWidth(3, 10000);
            sheet.setColumnWidth(4, 3000);

            //Setup the Page margins - Left, Right, Top and Bottom
            sheet.setMargin(Sheet.LeftMargin, 0.25);
            sheet.setMargin(Sheet.RightMargin, 0.25);
            sheet.setMargin(Sheet.TopMargin, 0.75);
            sheet.setMargin(Sheet.BottomMargin, 0.75);

            //Setup the Header and Footer Margins
            sheet.setMargin(Sheet.HeaderMargin, 0.25);
            sheet.setMargin(Sheet.FooterMargin, 0.25);

            //If you are using HSSFWorkbook() instead of XSSFWorkbook()
            //HSSFPrintSetup ps = (HSSFPrintSetup) sheet.getPrintSetup();
            //ps.setHeaderMargin((double) .25);
            //ps.setFooterMargin((double) .25);

            //Set Header Information
            Header header = sheet.getHeader();
            header.setLeft("*** ORIGINAL COPY ***");
            header.setCenter(HSSFHeader.font("Arial", "Bold") +
                    HSSFHeader.fontSize((short) 14) + "SAMPLE ORDER");
            header.setRight(df.format(date));

            //Set Footer Information with Page Numbers
            Footer footer = sheet.getFooter();
            footer.setRight("Page " + HeaderFooter.page() + " of " +
                    HeaderFooter.numPages());


            int rowIndex = 0;
            rowIndex = insertHeaderInfo(sheet, rowIndex);
            rowIndex = insertDetailInfo(sheet, rowIndex);

/*   //Write the Excel file
   FileOutputStream fileOut = null;
   fileOut = new FileOutputStream("Mentor_Program_Report.xlsx");
   wb.write(fileOut);
   fileOut.close();*/
            System.out.println("File is generated");

            //Send to mail
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            wb.write(bos); // write excel data to a byte array
            bos.close();

// Now use your ByteArrayDataSource as
            DataSource fds = new ByteArrayDataSource(bos.toByteArray(), "application/vnd.ms-excel");

            SendMailer sm = new SendMailer();
            sm.send(fds);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void setCellStyles(Workbook wb) {

        //font size 10
        Font f = wb.createFont();
        f.setFontHeightInPoints((short) 10);

        //Simple style
        cs = wb.createCellStyle();
        cs.setFont(f);

        //Bold Fond
        Font bold = wb.createFont();
        bold.setBoldweight(Font.BOLDWEIGHT_BOLD);
        bold.setFontHeightInPoints((short) 10);

        //Bold style
        csBold = wb.createCellStyle();
        csBold.setBorderBottom(CellStyle.BORDER_THIN);
        csBold.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        csBold.setFont(bold);

        //Setup style for Top Border Line
        csTop = wb.createCellStyle();
        csTop.setBorderTop(CellStyle.BORDER_THIN);
        csTop.setTopBorderColor(IndexedColors.BLACK.getIndex());
        csTop.setFont(f);

        //Setup style for Right Border Line
        csRight = wb.createCellStyle();
        csRight.setBorderRight(CellStyle.BORDER_THIN);
        csRight.setRightBorderColor(IndexedColors.BLACK.getIndex());
        csRight.setFont(f);

        //Setup style for Bottom Border Line
        csBottom = wb.createCellStyle();
        csBottom.setBorderBottom(CellStyle.BORDER_THIN);
        csBottom.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        csBottom.setFont(f);

        //Setup style for Left Border Line
        csLeft = wb.createCellStyle();
        csLeft.setBorderLeft(CellStyle.BORDER_THIN);
        csLeft.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        csLeft.setFont(f);

        //Setup style for Top/Left corner cell Border Lines
        csTopLeft = wb.createCellStyle();
        csTopLeft.setBorderTop(CellStyle.BORDER_THIN);
        csTopLeft.setTopBorderColor(IndexedColors.BLACK.getIndex());
        csTopLeft.setBorderLeft(CellStyle.BORDER_THIN);
        csTopLeft.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        csTopLeft.setFont(f);

        //Setup style for Top/Right corner cell Border Lines
        csTopRight = wb.createCellStyle();
        csTopRight.setBorderTop(CellStyle.BORDER_THIN);
        csTopRight.setTopBorderColor(IndexedColors.BLACK.getIndex());
        csTopRight.setBorderRight(CellStyle.BORDER_THIN);
        csTopRight.setRightBorderColor(IndexedColors.BLACK.getIndex());
        csTopRight.setFont(f);

        //Setup style for Bottom/Left corner cell Border Lines
        csBottomLeft = wb.createCellStyle();
        csBottomLeft.setBorderBottom(CellStyle.BORDER_THIN);
        csBottomLeft.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        csBottomLeft.setBorderLeft(CellStyle.BORDER_THIN);
        csBottomLeft.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        csBottomLeft.setFont(f);

        //Setup style for Bottom/Right corner cell Border Lines
        csBottomRight = wb.createCellStyle();
        csBottomRight.setBorderBottom(CellStyle.BORDER_THIN);
        csBottomRight.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        csBottomRight.setBorderRight(CellStyle.BORDER_THIN);
        csBottomRight.setRightBorderColor(IndexedColors.BLACK.getIndex());
        csBottomRight.setFont(f);

    }

    private int insertHeaderInfo(Sheet sheet, int index) {

        int rowIndex = index;
        Row row = null;
        Cell c = null;

        row = sheet.createRow(rowIndex);
        c = row.createCell(0);
        c.setCellValue("Id");
        c.setCellStyle(csBold);
        c = row.createCell(1);
        c.setCellValue("Mentor Name");
        c.setCellStyle(csBold);
        c = row.createCell(2);
        c.setCellValue("Mentee Name");
        c.setCellStyle(csBold);
        c = row.createCell(3);
        c.setCellValue("Created by");
        c.setCellStyle(csBold);
        c = row.createCell(4);
        c.setCellValue("Submitted On");
        c.setCellStyle(csBold);

        return rowIndex;

    }

    private int insertDetailInfo(Sheet sheet, int index) {

        int rowIndex = 0;
        Row row = null;
        Cell c = null;

        for (int i = 1; i < getMentorData().size(); i++) {

            rowIndex = index + i;
            row = sheet.createRow(rowIndex);
            c = row.createCell(0);
            c.setCellValue(i);
            c.setCellStyle(cs);
            c = row.createCell(1);
            c.setCellValue(getMentorData().get(i).getMentorName());
            c.setCellStyle(cs);
            c = row.createCell(2);
            c.setCellValue(getMentorData().get(i).getMenteeName());
            c.setCellStyle(cs);
            c = row.createCell(3);
            c.setCellValue(getMentorData().get(i).getCreatedBy());
            c.setCellStyle(cs);
            c = row.createCell(4);
            c.setCellValue(getMentorData().get(i).getSubmittedOn());
            c.setCellStyle(cs);

        }

        return rowIndex;

    }

    public List<MentorNotification> getMentorData() {
        return List.of(
                getMentor1(),
                getMentor2(),
                getMentor3()
        );
    }

    private MentorNotification getMentor1() {
        return new MentorNotification().setAssocId("123")
                .setMentorMail("venkateswara_garikipati@epam.com")
                .setMentorName("venkateswara garikipati@epam.com")
                .setMenteeMail("Shivakrishna_kurremula@epam.com")
                .setMenteeName("Shivakrishna kurremula")
                .setCreatedBy("prakhar_agarwal@epam.com")
                .setSubmittedOn("12-12-2021");

    }

    private MentorNotification getMentor2() {
        return new MentorNotification().setAssocId("123")
                .setMenteeMail("Shivakrishna_kurremula@epam.com")
                .setMenteeName("Shivakrishna kurremula")
                .setMentorMail("souvik_dutta@epam.com")
                .setMentorName("souvik dutta")
                .setCreatedBy("venkateswara_garikipati@epam.com")
                .setSubmittedOn("19-12-2021");

    }

    private MentorNotification getMentor3() {
        return new MentorNotification().setAssocId("123")
                .setMentorMail("venkateswara_garikipati@epam.com")
                .setMentorName("venkateswara garikipati@epam.com")
                .setMenteeMail("prakhar_agarwal@epam.com")
                .setMenteeName("prakhar agarwal")
                .setCreatedBy("prakhar_agarwal@epam.com")
                .setSubmittedOn("29-12-2021");

    }
}