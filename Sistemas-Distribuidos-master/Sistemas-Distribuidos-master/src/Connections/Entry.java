package Connections;

import java.util.ArrayDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Entry{
    public final Condition cond;
    public final ArrayDeque<byte[]> queue = new ArrayDeque<>();
    public Lock lock = new ReentrantLock();
    public boolean alive = true;
    public Entry()
    {
        cond = this.lock.newCondition();
    }
    public void Print()
    {
        System.out.println("Dados da queue");
        for (var v : queue) {
            System.out.print( new String(v) + " ");
        }
    }
    int waiters = 0;
}
