package com.service;
import com.database.*;

import java.sql.ResultSet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;


@Path("/Library_mgt")
public class Library_Reporting {

	@GET 
	   @Path("/subject") 
	   @Produces(MediaType.APPLICATION_JSON) 
	public String getSubjectWiseMember() {
		try {
		ResultSet result=DBmanager.ReportDB();
		JSONArray jsonArray = new JSONArray();
		while(result.next()) {
			JSONObject object = new JSONObject();
			object.put("book_name",result.getString(1));
			object.put("author_name",result.getString(2));
			object.put("number_of_copies",result.getInt(3));
			jsonArray.put(object);
			}
		return jsonArray.toString();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
