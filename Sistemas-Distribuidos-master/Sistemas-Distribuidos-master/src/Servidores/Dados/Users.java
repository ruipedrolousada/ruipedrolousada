package Servidores.Dados;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class InfoUser{
    String password;
    boolean isAdmin;
    public InfoUser(String password,boolean isAdmin)
    {
        this.password = password;
        this.isAdmin = isAdmin;
    }
}

public class Users {
    HashMap<String,InfoUser> allUsers = new HashMap<>();
    Lock lock = new ReentrantLock();
    public Users()
    {

    }

    public void addUser(String username,String password,boolean isAdmin)
    {
        lock.lock();
        try{
            allUsers.put(username,new InfoUser(password, isAdmin));
        }finally{ lock.unlock();}
    }

    public boolean isAdmin(String username)
    {
        var info = allUsers.get(username);
        if (info == null) return false;
        return info.isAdmin;
    }

    public boolean checkUser(String username,String password)
    {
        lock.lock();
        try{
            var info = allUsers.get(username);
            if (info == null) return false;

            return info.password.equals(password);
        }finally{ lock.unlock();}
    }
}
