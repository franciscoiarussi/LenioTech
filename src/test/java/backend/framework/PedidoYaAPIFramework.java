package backend.framework;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.TestProperties;

public class PedidoYaAPIFramework {

    private static final String URL= TestProperties.getInstance().getString("backend.challenge.base.url");
    private static final String CATEGORIA_URL= "api/Categoria";
    private static final String PEDIDO_URL= "api/Pedido";
    private static final String COMERCIO_URL= "api/Comercio";
    private static final String LOCALIDAD_URL= "api/Localidad";

    private static RequestSpecification pedidoYaSpecification(){
        return RestAssured.given()
                .baseUri(URL);
    }

    public static Response postCategoria(String name){
        String body="{\"nombre\": \""+name+"\"}";
        return pedidoYaSpecification()
                .contentType("application/json")
                .body(body)
                .post(CATEGORIA_URL);
    }

    public static Response getCategoria(){
        return pedidoYaSpecification()
                .get(CATEGORIA_URL);
    }

    public static Response deleteCategoria(String id){
        return pedidoYaSpecification()
                .delete(CATEGORIA_URL+"/"+id);
    }

    public static Response postPedido(String body){
        return pedidoYaSpecification()
                .contentType("application/json")
                .body(body)
                .post(PEDIDO_URL);
    }

    public static Response getComercio(){
        return pedidoYaSpecification()
                .get(COMERCIO_URL);
    }

    public static Response getLocalidades(){
        return pedidoYaSpecification()
                .get(LOCALIDAD_URL);
    }
}
