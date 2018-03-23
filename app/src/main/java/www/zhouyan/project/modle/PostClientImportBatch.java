package www.zhouyan.project.modle;

import java.util.ArrayList;

/**
 * Created by zhouyan on 17/8/2.
 */

public class PostClientImportBatch {
    int clienttype;
    private ArrayList<BulkImport> clients;

    public int getClienttype() {
        return clienttype;
    }

    public void setClienttype(int clienttype) {
        this.clienttype = clienttype;
    }

    public ArrayList<BulkImport> getClients() {
        return clients;
    }

    public void setClients(ArrayList<BulkImport> clients) {
        this.clients = clients;
    }
}
