package org.vin.restfulspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vin.restfulspring.model.Friend;
import org.vin.restfulspring.repository.FriendRepository;

import java.util.List;
import java.util.Optional;

@Service("friendService")
public class FriendServiceImpl implements FriendService {

    @Qualifier("friendRepository")
    @Autowired
    private FriendRepository friendRepository;

    @Override
    @Transactional
    public Friend create(Friend friend){
        return friendRepository.save(friend);
    }

    @Override
    @Transactional
    public List<Friend> readAll(){
        return  friendRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Friend> readOne(Long id){
        return friendRepository.findById(id);
    }

    @Override
    @Transactional
    public Friend update(Friend friend){
        return friendRepository.saveAndFlush(friend);
    }

    @Override
    @Transactional
    public Long updateAndReturnCount(Friend friend){
        return friendRepository.updateRecord(friend.getFirstName(), friend.getLastName(),friend.getId());
    }

    @Override
    @Transactional
    public Long delete(Friend friend){
        return friendRepository.deleteRecord(friend.getId());
    }
}
