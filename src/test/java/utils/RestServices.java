package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RestServices {
	public static RequestSpecification reqspec;
	public static RequestSpecBuilder reqbuild;
	public static ReadConfig config = ReadConfig.getInstance();

	public static RequestSpecification requestSpecification() {
		try {
			// System.out.println(config.getBaseUrl());
			if (reqspec == null) {
				{
					reqspec = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2").build();
				}

				return reqspec;
			}

			return reqspec;
		} catch (Exception e) {
			e.printStackTrace();
			return reqspec;
		}
	}

	public String getPayload(int id, String petName) {
		String payload = "{\r\n" + "    \"id\": " + id + ",\r\n" + "  	 \"category\": {\r\n" + "    \"id\": 0,\r\n"
				+ "    \"name\": \"string\"\r\n" + "  },\r\n" + "    \"name\": \"" + petName + "\",\r\n"
				+ "    \"status\": \"available\"\r\n" + "  }";
		return payload;
	}

	public static void main(String args[]) {
		RestServices rs = new RestServices();
		System.out.println(rs.getPayload(123, "dd"));
	}
}
