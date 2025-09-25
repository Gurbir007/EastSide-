package TestScript;


import org.testng.annotations.Test;

import Base.Basetest;
import pages.Client;

public class TestClient extends Basetest {

    @Test
    public void ClientAdd() throws InterruptedException {

        Client client = new Client(driver);

        // Open form
        client.openClientForm();
        Thread.sleep(1000);

        // Add new client with billing address → dropdown 4th option select hoga
        client.AddNewClient("Jimmy", "Jimmy@gmail.com","Austral" , "8989898989");
        Thread.sleep(2000);

        // Secondary Address
        client.SecondarAddres("Jimmy", "Jimmy@gmail.com", "Austral", "8989898989");
        Thread.sleep(2000);

        // Job detail
        client.Jobdetail("New Job", "Austral");
        Thread.sleep(2000);

        System.out.println("✅ New Client is added successfully");
    }

}
