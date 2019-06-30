package org.vin.restfulspring.service;

import org.vin.restfulspring.model.Friend;

import java.util.List;
import java.util.Optional;

public interface FriendService {
    Friend create(Friend friend);

    List<Friend> readAll();

    Optional<Friend> readOne(Long id);

    Friend update(Friend friend);

    Long updateAndReturnCount(Friend friend);

    Long delete(Friend friend);
}
