/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paul_Testing;

/**
 *
 * @author Paul's Laptop
 */
import com.laserfiche.client.api.LFApiClient;
import com.laserfiche.client.api.LFRepositoryClient;
import com.laserfiche.client.api.model.DestinationPath;
import com.laserfiche.client.api.model.LFItem;
import com.laserfiche.client.api.model.LFItemInfo;
import com.laserfiche.client.api.model.Query;
import com.laserfiche.client.api.model.QueryResult;
import com.laserfiche.repository.api.clients.impl.model.Entry;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;

import com.laserfiche.repositoryaccess.RepositoryAccess;
import com.laserfiche.repositoryaccess.ServiceFactory;
import com.laserfiche.repositoryaccess.ServiceFactoryConfiguration;
import com.laserfiche.repositoryaccess.Session;
import com.laserfiche.repositoryaccess.SessionConfiguration;
import com.laserfiche.repositoryaccess.SessionInfo;

public class RemoteProcessingElement extends ProcessingElement {

    private String servicePrincipalKey = "9fVC9F9aS9w4_Atix-aO";
    private String accessKeyBase64 = "ewoJImN1c3RvbWVySWQiOiAiMTQwMTM1OTIzOCIsCgkiY2xpZW50SWQiOiAiOTQyMmIzNmQtYjdlNC00N2JjLTkxNzQtZDMyYjY5Zjk2MDY5IiwKCSJkb21haW4iOiAibGFzZXJmaWNoZS5jYSIsCgkiandrIjogewoJCSJrdHkiOiAiRUMiLAoJCSJjcnYiOiAiUC0yNTYiLAoJCSJ1c2UiOiAic2lnIiwKCQkia2lkIjogIk9VZ0JkekMya2VvWEJpRXg2RW5lQ1A1SGQzaGE0N3g0cWVsZGh0TkhHQmciLAoJCSJ4IjogIldibWM1endGa3VJWFU5QjRNYVNTM1NwUnJYNDBic2k2RHVIQ3hZYXVXUkEiLAoJCSJ5IjogIjhOdW16ejBwN2pxcm45Y2lqczBuZVFQa3l0S2s2dlphdHhnMThsQnBPbE0iLAoJCSJkIjogIkpOd1duT29ITG4wNUctNTR4aG5oWXV0Mjd2VzhWWUhDSkpHQzE5VVZQTGMiLAoJCSJpYXQiOiAxNjc3Mjk3ODQ1Cgl9Cn0";
    private String repositoryId = "r-0001d410ba56";

    public RemoteProcessingElement(String servicePrincipalKey, String accessKeyBase64, String repositoryId) {
        this.servicePrincipalKey = servicePrincipalKey;
        this.accessKeyBase64 = accessKeyBase64;
        this.repositoryId = repositoryId;
    }

    @Override
    public void process_input(Entry entry) {
        if (entry.is_local()) {
            // Assume entry is a local file
            Path localFilePath = Paths.get(entry.get_path());
            if (!Files.exists(localFilePath)) {
                System.out.println("Local file does not exist: " + localFilePath.toString());
                return;
            }

            // Initialize Laserfiche API client
            LFApiClient apiClient = new LFApiClient(servicePrincipalKey, accessKeyBase64);
            LFRepositoryClient repositoryClient = apiClient.getRepositoryClient(repositoryId);

            // Create destination path for Laserfiche item
            String itemName = localFilePath.getFileName().toString();
            DestinationPath destinationPath = DestinationPath.root().append(itemName);

            // Upload local file to Laserfiche
            LFItem item = repositoryClient.uploadDocument(localFilePath.toFile(), destinationPath, null, null);
            System.out.println("Uploaded file to Laserfiche: " + item.getFullPath());
        } else {
            // Assume entry is a remote file in Laserfiche
            // Initialize Laserfiche API client
            LFApiClient apiClient = new LFApiClient(servicePrincipalKey, accessKeyBase64);
            LFRepositoryClient repositoryClient = apiClient.getRepositoryClient(repositoryId);

            // Get info for Laserfiche item
            String itemPath = entry.get_path();
            Query query = new Query();
            query.addFilter("FullPath", Query.Operator.EQUALS, itemPath);
            QueryResult queryResult = repositoryClient.getItems(query);
            List<LFItemInfo> items = queryResult.getItems();
            if (items.size() != 1) {
                System.out.println("Item not found or multiple items with same path: " + itemPath);
                return;
            }
            LFItemInfo itemInfo = items.get(0);

            // Download Laserfiche item to local file
            String localFilePathString = "/path/to/local/folder/" + itemInfo.getName();
            Path localFilePath = Paths.get(localFilePathString);
            repositoryClient.downloadDocument(itemInfo, localFilePath.toFile());
            System.out.println("Downloaded file from Laserfiche: " + itemPath);
        }
    }
    @Override
    public void process_output(OutputStream output) throws IOException {
        // Authenticate with Laserfiche
        ServiceFactoryConfiguration config = new ServiceFactoryConfiguration(servicePrincipalKey,
                Base64.getDecoder().decode(accessKeyBase64));
        ServiceFactory serviceFactory = ServiceFactory.getInstance(config);
        SessionInfo sessionInfo = new SessionInfo(repositoryId);
        SessionConfiguration sessionConfig = new SessionConfiguration(sessionInfo);
        try (Session session = serviceFactory.createReadOnlySession(sessionConfig)) {
            // Get the file contents from Laserfiche
            byte[] fileContents = RepositoryAccess.getFile(session, getPath());
            
            // Write the file contents to the output stream
            output.write(fileContents);
        } catch (Exception e) {
            throw new IOException("Error retrieving file from Laserfiche repository", e);
        }
    }

}