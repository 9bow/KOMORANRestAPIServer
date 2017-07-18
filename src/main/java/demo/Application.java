package demo;

import com.google.gson.Gson;
import static spark.Spark.*;


public class Application {
	private static KOMORANDemo komoran = new KOMORANDemo();
	private static Gson gson = new Gson();

	public static void main(String[] args) {
		port(8080);

		get("/demo", (req, res) -> {
			String query = req.queryParams("sentence") == null ? "바람과 함께 사라지다를 봤어." : req.queryParams("sentence");
			String modelType = req.queryParams("model_type") == null ? "full" : req.queryParams("model_type");

			komoran.setUserInput(query, modelType);
			komoran.analyze();

			return gson.toJson(komoran);
		});
	}
}
