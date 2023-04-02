/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paul_Testing;

/**
 *
 * @author Paul's Laptop
 */
import com.google.gson.Gson;
import java.io.FileReader;

import com.laserfiche.api.client.model.AccessKey;
import com.laserfiche.repository.api.RepositoryApiClient;
import com.laserfiche.repository.api.RepositoryApiClientImpl;
import com.laserfiche.repository.api.clients.impl.model.Entry;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String scenarioFile = "TestJSON.json";
        String servicePrincipalKey = "9fVC9F9aS9w4_Atix-aO";
        String accessKeyBase64 = "ewoJImN1c3RvbWVySWQiOiAiMTQwMTM1OTIzOCIsCgkiY2xpZW50SWQiOiAiOTQyMmIzNmQtYjdlNC00N2JjLTkxNzQtZDMyYjY5Zjk2MDY5IiwKCSJkb21haW4iOiAibGFzZXJmaWNoZS5jYSIsCgkiandrIjogewoJCSJrdHkiOiAiRUMiLAoJCSJjcnYiOiAiUC0yNTYiLAoJCSJ1c2UiOiAic2lnIiwKCQkia2lkIjogIk9VZ0JkekMya2VvWEJpRXg2RW5lQ1A1SGQzaGE0N3g0cWVsZGh0TkhHQmciLAoJCSJ4IjogIldibWM1endGa3VJWFU5QjRNYVNTM1NwUnJYNDBic2k2RHVIQ3hZYXVXUkEiLAoJCSJ5IjogIjhOdW16ejBwN2pxcm45Y2lqczBuZVFQa3l0S2s2dlphdHhnMThsQnBPbE0iLAoJCSJkIjogIkpOd1duT29ITG4wNUctNTR4aG5oWXV0Mjd2VzhWWUhDSkpHQzE5VVZQTGMiLAoJCSJpYXQiOiAxNjc3Mjk3ODQ1Cgl9Cn0";
		String repositoryId = "r-0001d410ba56";
                AccessKey accessKey = AccessKey.createFromBase64EncodedAccessKey(accessKeyBase64);

        RepositoryApiClient client = RepositoryApiClientImpl.createFromAccessKey(
                servicePrincipalKey, accessKey);
        
        try {
            Gson gson = new Gson();
            Scenario scenario = gson.fromJson(new FileReader(scenarioFile), Scenario.class);

            // Initialize the Laserfiche client
            LaserficheClient client = new LaserficheClient(servicePrincipalKey, accessKeyBase64, repositoryId);

            // Create a list of processing elements from the scenario
            List<ProcessingElement> processingElements = scenario.createProcessingElements(client);

            // Execute the scenario
            List<Entry> finalOutput = scenario.run(client, processingElements);

            // Print the final output to the console
            for (Entry entry : finalOutput) {
                System.out.println(entry.getPath());
            }

        }
    }
}
