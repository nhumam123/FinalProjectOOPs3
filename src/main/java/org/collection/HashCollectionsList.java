package org.collection;
import org.product.ProductOrder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class HashCollectionsList<O> extends HashMap {

    private HashMap<String, O> dataHash;

    public HashCollectionsList() {
        this.dataHash = new HashMap<String, O>();
    }

    @Override
    public Collection values() {
        return dataHash.values();
    }

    public boolean exist(String datahash) {
        return dataHash.containsKey(datahash);
    }

    public boolean addData(String datahash, O data) {
        if (!exist(datahash)) {
            dataHash.put(datahash, data);
        } else {
            return false;
        }
        return true;
    }
    public void  deleteData(String datahash) {
        dataHash.remove(datahash);
    }

    public O getData(String datahash) {
        return dataHash.get(datahash);
    }

    public boolean updateData(String datahash, O updatedData) {
        if (exist(datahash)) {
            O temp = dataHash.get(datahash);
            dataHash.remove(datahash);
            dataHash.put(datahash, updatedData);
        } else {
            return false;
        }
        return true;
    }

    public void resetData() {
        dataHash.clear();
    }

    public ArrayList convertToArrayList() {
        Collection<O> listCollection = dataHash.values();
        ArrayList<O>  convertedArrayList = new ArrayList<>(listCollection);
        return convertedArrayList;
    }

}
