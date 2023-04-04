/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proccess_TEST;

/**
 *
 * @author Paul's Laptop
 */

import com.laserfiche.api.client.model.AccessKey;
import com.laserfiche.repository.api.RepositoryApiClient;
import com.laserfiche.repository.api.RepositoryApiClientImpl;
import com.laserfiche.repository.api.clients.impl.model.Entry;
import com.laserfiche.repository.api.clients.impl.model.ODataValueContextOfIListOfEntry;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.function.Consumer;

public class LaserficheEntry {
    private final RepositoryApiClient client;

    public LaserficheEntry(String servicePrincipalKey, String accessKeyBase64) {
        AccessKey accessKey = AccessKey.createFromBase64EncodedAccessKey(accessKeyBase64);
        this.client = RepositoryApiClientImpl.createFromAccessKey(servicePrincipalKey, accessKey);
    }

    public Entry getEntry(int entryId, String repositoryId) {
        return client.getEntriesClient()
                .getEntry(repositoryId, entryId, null).join();
    }

    public List<Entry> getChildEntries(int rootEntryId, String repositoryId) {
        ODataValueContextOfIListOfEntry result = client
                .getEntriesClient()
                .getEntryListing(repositoryId, rootEntryId, true, null, null, null, null, null, "name", null, null, null).join();
        return result.getValue();
    }

    public void downloadEntry(int entryId, String repositoryId, String fileName) {
        Consumer<InputStream> consumer = inputStream -> {
            File exportedFile = new File(fileName);
            try (FileOutputStream outputStream = new FileOutputStream(exportedFile)) {
                byte[] buffer = new byte[1024];
                while (true) {
                    int length = inputStream.read(buffer);
                    if (length == -1) {
                        break;
                    }
                    outputStream.write(buffer, 0, length);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        client.getEntriesClient()
                .exportDocument(repositoryId, entryId, null, consumer)
                .join();
    }

    public void closeClient() {
        client.close();
    }
}




