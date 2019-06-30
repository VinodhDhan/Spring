package org.vin.restfulspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.vin.restfulspring.model.Friend;
import org.vin.restfulspring.model.Friends;
import org.vin.restfulspring.service.FriendService;

import javax.xml.bind.ValidationException;

@RestController
public class FriendController {

    @Autowired
    FriendService friendService;

    @GetMapping(value = "/friend", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Friends readAll() {
        Friends friends = new Friends();
        friends.setFriends(friendService.readAll());
        return friends;
    }


    @PostMapping(value = "/friend", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    Friend create(@RequestBody Friend friend) throws ValidationException {
        if(friend.getFirstName()!=null){
            return friendService.create(friend);
        }
        else throw new ValidationException("Friend cannot be null");
    }



}
