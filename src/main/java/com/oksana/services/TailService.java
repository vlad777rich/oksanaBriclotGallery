package com.oksana.services;

import com.oksana.dao.TailDao;
import com.oksana.entities.Tail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TailService {
    private TailDao tailDao;

    public TailService(TailDao tailDao) {
        this.tailDao = tailDao;
    }

    public List<Tail> getAllTails() {
        return tailDao.getAllTails();
    }

    public void addTail(Tail tail) {
        tailDao.addTail(tail);
    }

    public void deleteTailByName(String name) {
        tailDao.deleteTailByName(name);
    }

    public List<Tail> getAllProductsByType(String type) {
        return tailDao.getAllProductsByType(type);
    }

    public Tail getTailByName(String name) {
        return tailDao.getTailByName(name);
    }

    public void deleteAllTails() {
        tailDao.deleteAllTails();
    }
}
