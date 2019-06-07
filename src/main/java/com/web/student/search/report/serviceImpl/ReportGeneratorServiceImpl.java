package com.web.student.search.report.serviceImpl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.web.student.search.report.service.ReportGeneratorService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Service
public class ReportGeneratorServiceImpl implements ReportGeneratorService {

	@Autowired
	private ResourceLoader resource;

	@Autowired
	@Qualifier("jdbc")
	public JdbcTemplate jdbcTemplate;
	
	@Override
	public JasperPrint exportStudentPdf() throws SQLException, IOException, JRException  {
		Connection con = jdbcTemplate.getDataSource().getConnection();
		String path = resource.getResource("classpath:UserReport.jrxml").getURI().getPath();
		JasperReport jasperReport = JasperCompileManager.compileReport(path);
		Map<String, Object> parameter = new HashMap<String, Object>();
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, con);
		if (!con.isClosed()) {
			con.close();
		}
		return jasperPrint;

	}

	public JasperPrint exportStudentProfilePdf() throws SQLException, IOException, JRException {
		Connection con = jdbcTemplate.getDataSource().getConnection();
		String path = resource.getResource("classpath:StudentWithProfile.jrxml").getURI().getPath();
		System.out.println(path);
		JasperReport jasperReport = JasperCompileManager.compileReport(path);
		Map<String, Object> parameter = new HashMap<String, Object>();
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, con);
		if (!con.isClosed()) {
			con.close();
		}
		return jasperPrint;
	}
}
