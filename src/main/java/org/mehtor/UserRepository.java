package org.mehtor;

import com.google.gson.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserRepository {
	
	public List<User> getUsers(int count){
		List<User> users = new ArrayList<>();
		
		Scanner sc ;
		String jsonData ="";
		try {
			sc=new Scanner(new URL("https://randomuser.me/api/?results="+count).openStream());
			//System.out.println(sc.nextLine());
			jsonData = sc.nextLine();
			//System.out.println("jsonData....:"+jsonData);
			//System.out.println("--------------------------------");
		}
		catch (
				IOException e) {
			e.printStackTrace();
		}
		
		Gson gson = new Gson();
		
		JsonElement jsonElement = JsonParser.parseString(jsonData);
		//System.out.println("jsonElement.......:"+jsonElement);
		//System.out.println("--------------------------------");
		
		//jsonElement içinde { ile başladığı için bir json object olduğunu biliyoruz.Bu yüzden içindeki jsonObjecti
		// almak için geAsObject metodunu kullanıyoruz:
		JsonObject asJsonObject = jsonElement.getAsJsonObject();
		//jsonObject içinde bizi ilgilendiren User ddatalari results kısmında olduğu için get  içib results yazıyoruz.
		//ardından results kısmında[ ile başladığı için bir json array olduğunu biliyoruz. Bu yüzdem içindeki
		// jsonArray'i almak için getAsJsonArray
		JsonArray resultsJsonArray = asJsonObject.get("results").getAsJsonArray();
		//System.out.println("resultsJsonArray.....:"+resultsJsonArray);
		//System.out.println("--------------------------------");
		for (int i = 0; i <resultsJsonArray.size() ; i++) {
			JsonObject userJsonObject = resultsJsonArray.get(i).getAsJsonObject();
		//	System.out.println("userJsonObject.....:"+userJsonObject);
		//	System.out.println("--------------------------------");
			User user =gson.fromJson(userJsonObject, User.class);  //parametrede Class<T> şeklinde bir yapi gorurseniz
			// vereceginiz sınıfın sonuna  .class ekleyin
			//System.out.println("user..............:"+user);
			//System.out.println("--------------------------------");
			users.add(user);
		}
		
		return users;
	}
	
	
	
}