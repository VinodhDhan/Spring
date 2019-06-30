package org.vin.restfulspring.repository;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.vin.restfulspring.model.Friend;

@Repository("friendRepository")
public interface FriendRepository extends JpaRepository<Friend, Long> {

    @Modifying
    @Query("update Friend f set f.firstName=?1, f.lastName=?2 where f.id=?3")
    Long updateRecord(String firstName, String lastName, Long id);

    @Modifying
    @Query("delete from Friend f where f.id=?1")
    Long deleteRecord(Long id);
}
