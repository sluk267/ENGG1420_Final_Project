/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paul_Testing;

/**
 *
 * @author Paul's Laptop
 */
public class Processor {
    private ProcessingElement processingElement;

    public Processor(ProcessingElement processingElement) {
        this.processingElement = processingElement;
    }

    public void process_data(String input_path, String output_path) {
        if (processingElement instanceof LocalProcessingElement) {
            LocalProcessingElement localProcessingElement = (LocalProcessingElement) processingElement;
            localProcessingElement.process_input(input_path);
            localProcessingElement.process_output(output_path);
        } else if (processingElement instanceof RemoteProcessingElement) {
            RemoteProcessingElement remoteProcessingElement = (RemoteProcessingElement) processingElement;
            remoteProcessingElement.setRepositoryId(repositoryId);
            remoteProcessingElement.setServicePrincipalKey(servicePrincipalKey);
            remoteProcessingElement.setAccessKeyBase64(accessKeyBase64);
            remoteProcessingElement.process_input(input_path);
            remoteProcessingElement.process_output(output_path);
        } else {
            throw new IllegalArgumentException("Unsupported ProcessingElement type: " + processingElement.getClass().getName());
        }
    }
}
