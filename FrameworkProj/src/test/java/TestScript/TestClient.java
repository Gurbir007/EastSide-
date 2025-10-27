package TestScript;


import org.testng.annotations.Test;



import Base.Basetest;
import pages.Client;

public class TestClient extends Basetest {

    @Test
    public void ClientAdd() throws InterruptedException {

        Client client = new Client(driver);

        client.openClientForm();
        Thread.sleep(1000);

        client.AddNewClient("Jimmy", "Jimmy@gmail.com","Austral" , "8989898989");
        Thread.sleep(2000);

        client.SecondarAddres("Jimmy", "Jimmy@gmail.com", "Austral", "8989898989");
        Thread.sleep(2000);

        client.Jobdetail("New Job", "Austral");
        Thread.sleep(2000);

        System.out.println("✅ New Client is added successfully");
    }

}
