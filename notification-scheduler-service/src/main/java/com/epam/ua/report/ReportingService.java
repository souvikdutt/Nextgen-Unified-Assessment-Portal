package com.epam.ua.report;

public class ReportingService {

    public void generateReportAndSendMail() {
        ExcelGenerateReport report = new ExcelGenerateReport();
        report.createExcel();
    }
}
