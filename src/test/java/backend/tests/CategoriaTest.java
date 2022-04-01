package backend.tests;

import backend.framework.PedidoYaAPIFramework;
import backend.model.Categoria;
import backend.model.Comercio;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CategoriaTest {
	
	@Test(description = "Parte 2 Ejercicio 1-a")
	public void testCategoriaEndpoint() {
		Gson g = new Gson();
		Assert.assertTrue(Boolean.parseBoolean(PedidoYaAPIFramework.postCategoria("new cat").then().assertThat().statusCode(HttpStatus.SC_OK).extract().response().asString()));
		Response getCat = PedidoYaAPIFramework.getCategoria()
				.then()
				.assertThat()
				.statusCode(HttpStatus.SC_OK)
				.and()
				.body(matchesJsonSchemaInClasspath("categoriasSchema.json"))
				.extract().response();
		Categoria c = g.fromJson(g.toJson(getCat.jsonPath().getList("").get(getCat.jsonPath().getList("").size()-1)), Categoria.class);
		Assert.assertTrue(Boolean.parseBoolean(PedidoYaAPIFramework.deleteCategoria(c.getIdCategoria()).then().assertThat().statusCode(HttpStatus.SC_OK).extract().response().asString()));
	}

	@Test(description = "Parte 2 Ejercicio 1-b")
	public void testPedidos() throws IOException {
		Gson g = new Gson();
		Response getCom = PedidoYaAPIFramework.getComercio()
				.then()
				.assertThat()
				.statusCode(HttpStatus.SC_OK)
				.and()
				.body(matchesJsonSchemaInClasspath("comerciosSchema.json"))
				.extract().response();
		Comercio c = g.fromJson(g.toJson(getCom.jsonPath().getList("").get(0)), Comercio.class);
		PedidoYaAPIFramework.postPedido(new String(Files.readAllBytes(Paths.get("src/test/resources/pedido.json"))).replace("\"idComercio\": -1","\"idComercio\": "+c.getIdComercio())).then().assertThat().statusCode(HttpStatus.SC_CREATED);
	}

	@Test(description = "Parte 2 Ejercicio 1-c")
	public void testLocalidades() {
		Response getCom = PedidoYaAPIFramework.getLocalidades()
				.then()
				.assertThat()
				.statusCode(HttpStatus.SC_OK)
				.and()
				.body(matchesJsonSchemaInClasspath("localidadesSchema.json"))
				.extract().response();
		Assert.assertEquals(getCom.jsonPath().getList("").size(),27);
	}

}
