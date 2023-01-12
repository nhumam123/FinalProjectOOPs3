package org.collection;
import java.util.HashMap;

public class HashCollectionsList<O>  {
    private HashMap<String, O> Users;

    public HashCollectionsList() {
        this.Users = new HashMap<String, O>();
    }

    public boolean exist(String userhash) {
        return Users.containsKey(userhash);
    }

    public boolean addUser(String userhash, O user) {
        if (!exist(userhash)) {
            Users.put(userhash, user);
        } else {
            return false;
        }
        return true;
    }
    public void  deleteUser(String userhash) {
        Users.remove(userhash);
    }

    public O getUser(String userhash) {
        return Users.get(userhash);
    }
    public boolean updateUser(String userhash, O updatedUser) {
        if (exist(userhash)) {
            O temp = Users.get(userhash);
            Users.remove(userhash);
            Users.put(userhash, updatedUser);
        } else {
            return false;
        }
        return true;
    }

}
