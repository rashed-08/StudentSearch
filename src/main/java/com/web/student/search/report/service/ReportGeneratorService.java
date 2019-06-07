package com.web.student.search.report.service;

import java.io.IOException;
import java.sql.SQLException;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

public interface ReportGeneratorService {
	
	public JasperPrint exportStudentPdf() throws SQLException, IOException, JRException;

}
