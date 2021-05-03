/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import org.json.JSONObject;

/**
 * REST Web Service
 *
 * @author component
 */
@Path("location")
public class Location {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Location
     */
    public Location() {
    }

    /**
     * Retrieves representation of an instance of service.Location
     * @return an instance of java.lang.String
     */
    @GET
    @Path("location/Arovince")
    @Produces("application/json")
    public String getJson() throws IOException {
        FileWriter file = new FileWriter("/home/component/NetBeansProjects/ArovinceAndSchool/web/api/Arovince.json");
        JSONObject jsonArray = null;

        try {
            URL url = new URL("https://opend.data.go.th/get-ckan/datastore_search?resource_id=df922923-e009-4dee-92fc-d963a86ce4b8");  
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("api-key", "XOe9aVTolOhCbyTU103IqAKTNNNPX8b5");
            String line = "";
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder response = new StringBuilder();

            try {
                while((line = bufferedReader.readLine()) != null) {
                    file.write(line);
                    response.append(line);
                }
            } catch (IOException var10) {
            }

            file.close();
            bufferedReader.close();
            jsonArray = new JSONObject(response.toString());
            return jsonArray.toString(4);
        } catch (Exception var11) {
            return "" + var11;
        }
    }
        
    @GET
    @Path("location/School")
    @Produces("application/json")
    public String getJsonnew() throws IOException {
        FileWriter file = new FileWriter("/home/component/NetBeansProjects/ArovinceAndSchool/web/api/School.json");
        JSONObject jsonArray = null;

        try {
            URL url = new URL("https://opend.data.go.th/get-ckan/datastore_search?resource_id=535fa018-7e31-42cb-99bb-15525be05373");  
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("api-key", "XOe9aVTolOhCbyTU103IqAKTNNNPX8b5");
            String line = "";
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder response = new StringBuilder();

            try {
                while((line = bufferedReader.readLine()) != null) {
                    file.write(line);
                    response.append(line);
                }
            } catch (IOException var10) {
            }

            file.close();
            bufferedReader.close();
            jsonArray = new JSONObject(response.toString());
            return jsonArray.toString(4);
        } catch (Exception var11) {
            return "" + var11;
        }
    }

    /**
     * PUT method for updating or creating an instance of Location
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
   @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
