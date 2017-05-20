package net.ninebow.dev.komoran.api;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class APIController {
	private static KOMORANDemo komoran = new KOMORANDemo();


    @RequestMapping("/api")
    public KOMORANDemo demo(@RequestParam(value="query", defaultValue="") String query
    		, @RequestParam(value="model_type", defaultValue="full") String modelType) {

    	this.komoran.setUserInput(query, modelType);
    	this.komoran.analyze();

    	return this.komoran;
    }
}
