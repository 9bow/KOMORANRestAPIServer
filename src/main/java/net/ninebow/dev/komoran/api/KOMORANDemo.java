package net.ninebow.dev.komoran.api;

import java.util.List;

import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.util.common.model.Pair;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;


public class KOMORANDemo {
	// User Input
	private String queryString;				// user input query - sentence to analyze
	private boolean useModelSizeFull;		// if true, use Full-size model - if not, use Light-size model

	// KOMORAN Instances
	private static Komoran komoran_full;	// full-size model
	private static Komoran komoran_light;	// light-size model

	// Analyze Result
	private List<Pair<String, String>> queryResult = null;


	public KOMORANDemo() {
		System.out.print("Loading models...");
		this.komoran_full = new Komoran(DEFAULT_MODEL.FULL);
		this.komoran_light = new Komoran(DEFAULT_MODEL.LIGHT);
		System.out.println("DONE");
	}


	public void setUserInput(String query, String modelType) {
		this.queryString = (query.trim().length() > 0) ? query.trim() : "바람과 함께 사라지다를 봤어."; 
		this.useModelSizeFull = modelType.toLowerCase().equals("full") ? true : false;
	}


	public void analyze() {
		Komoran model = (this.useModelSizeFull) ? this.komoran_full : this.komoran_light;

		this.queryResult = model.analyze(this.queryString).getList();

		System.out.println(">> Query: "+ this.queryString);
		System.out.println(">> Model: "+ ((this.useModelSizeFull) ? "Full" : "Light"));
		System.out.println(">> Result: "+ this.queryResult);
	}

	public List<Pair<String, String>> getQueryResult() {
		return queryResult;
	}

	public String getQueryString() {
		return queryString;
	}

	public boolean isUseModelSizeFull() {
		return useModelSizeFull;
	}

}
