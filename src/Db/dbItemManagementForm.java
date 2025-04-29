package Db;

import  Model.itemManagementModel;
import java.util.ArrayList;

public class dbItemManagementForm {

    private static ArrayList<itemManagementModel> list;

    public static ArrayList<itemManagementModel> getInstance(){
        if (list == null) {
            list = new ArrayList<>();
        }
        return list;
    }

    private dbItemManagementForm(){}
}