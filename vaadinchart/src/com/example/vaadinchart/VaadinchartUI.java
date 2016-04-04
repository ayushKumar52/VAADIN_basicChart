package com.example.vaadinchart;

import javax.servlet.annotation.WebServlet;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.Configuration;
import com.vaadin.addon.charts.model.DataSeries;
import com.vaadin.addon.charts.model.DataSeriesItem;
import com.vaadin.addon.charts.model.ListSeries;
import com.vaadin.addon.charts.model.PlotOptionsLine;
import com.vaadin.addon.charts.model.XAxis;
import com.vaadin.addon.charts.model.YAxis;
import com.vaadin.addon.charts.model.style.SolidColor;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("vaadinchart")
public class VaadinchartUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = VaadinchartUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		layout.setSpacing(true);

		// Chart Bar
		Chart chart = new Chart(ChartType.BAR);
		chart.setWidth("400px");
		chart.setHeight("300px");

		// Modify the default configuration a bit
		Configuration conf = chart.getConfiguration();
		conf.setTitle("Random");
		conf.setSubTitle("This is a test Chart");
		conf.getLegend().setEnabled(false); // Disable legend

		// Data
		ListSeries series = new ListSeries("Diameter");
		series.setData(49, 121, 128, 68, 1430, 1250, 511, 495, 734);
		conf.addSeries(series);

		// axes
		XAxis x = new XAxis();
		x.setCategories("First", "Second", "Third", "Fourth", "Fifth", "Sixth", "Seventh", "Eighth", "Ninth", "Tenth");
		conf.addxAxis(x);

		YAxis y = new YAxis();
		y.setTitle("Values");
		y.getLabels().setFormatter("f() {return Math.floor(value/50) + \'u\'}");
		conf.addyAxis(y);

		// chart 2 Line
		Chart chart2 = new Chart(ChartType.LINE);
		conf = chart2.getConfiguration();
		conf.setTitle("Chart No 2");
		conf.getxAxis().setTitle("year");
		conf.getxAxis().setTitle("Some One's sallary");

		// Data 1
		DataSeries dataset = new DataSeries("Fist Sallary");
		dataset = new ChartsData().getData();
		conf.addSeries(dataset);
		
		DataSeries dataset2 = new DataSeries("Second Sallary");
		dataset2 = new ChartsData().getData2();
		conf.addSeries(dataset2);
		
		// configuring colors
		PlotOptionsLine opt1 = new PlotOptionsLine();
		opt1.setColor(SolidColor.DARKGREEN);
		dataset.setPlotOptions(opt1);
		
		PlotOptionsLine opt2 = new PlotOptionsLine();
		opt2.setColor(SolidColor.BLUEVIOLET);
		dataset2.setPlotOptions(opt2);
		
		
		layout.addComponents(chart, chart2);
		setContent(layout);
	}

}