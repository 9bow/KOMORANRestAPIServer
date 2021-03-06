package api;

import com.google.gson.Gson;
import static spark.Spark.*;


public class Application {
	private static KOMORANDemo komoran = new KOMORANDemo();
	private static Gson gson = new Gson();

	public static void main(String[] args) {
		port(8080);

		get("/api", (req, res) -> {
			String query = req.queryParams("query") == null ? "바람과 함께 사라지다를 봤어." : req.queryParams("query");
			String modelType = req.queryParams("model_type") == null ? "full" : req.queryParams("model_type");

			komoran.setUserInput(query, modelType);
			komoran.analyze();

			return gson.toJson(komoran);
		});
	}
}
