package com.example.vaadinchart;

import com.vaadin.addon.charts.model.DataSeries;
import com.vaadin.addon.charts.model.DataSeriesItem;

public class ChartsData {
	public DataSeries getData() {
		DataSeries series = new DataSeries();
		series.setName("Total Reindeer Population");
		series.add(new DataSeriesItem(1959, 181091));
		series.add(new DataSeriesItem(1960, 201485));
		series.add(new DataSeriesItem(1961, 188105));
		series.add(new DataSeriesItem(1962, 177206));
		
		return series;
	}
	
	public DataSeries getData2() {
		DataSeries series = new DataSeries();
		series.setName("Total Reindeer Population");
		series.add(new DataSeriesItem(1959, 110212));
		series.add(new DataSeriesItem(1960, 140255));
		series.add(new DataSeriesItem(1961, 177252));
		series.add(new DataSeriesItem(1962, 200101));
		
		return series;
	}
}
