package www.zhouyan.project.modle;

import java.util.ArrayList;

/**
 * Created by mac on 18/1/8.
 */

public class CustomerListSource {
    private  int totalcount;
    private String excelid;
    private int resulttype;// "1、字母索引，2、分步输出",
    private ArrayList<Customer> clientinfos;
    private ArrayList<Clientletters> clientletters;

    public ArrayList<Clientletters> getClientletters() {
        return clientletters;
    }

    public void setClientletters(ArrayList<Clientletters> clientletters) {
        this.clientletters = clientletters;
    }

    public int getResulttype() {
        return resulttype;
    }

    public void setResulttype(int resulttype) {
        this.resulttype = resulttype;
    }

    public int getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(int totalcount) {
        this.totalcount = totalcount;
    }

    public String getExcelid() {
        return excelid;
    }

    public void setExcelid(String excelid) {
        this.excelid = excelid;
    }

    public ArrayList<Customer> getClientinfos() {
        return clientinfos;
    }

    public void setClientinfos(ArrayList<Customer> clientinfos) {
        this.clientinfos = clientinfos;
    }
    public static class Clientletters {


        private ArrayList<Customer> clientinfos;
        private String letter;

        public ArrayList<Customer> getClientinfos() {
            return clientinfos;
        }

        public void setClientinfos(ArrayList<Customer> clientinfos) {
            this.clientinfos = clientinfos;
        }

        public String getLetter() {
            return letter;
        }

        public void setLetter(String letter) {
            this.letter = letter;
        }
    }

}
