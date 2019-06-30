package org.vin.restfulspring;

import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.vin.restfulspring.model.Address;
import org.vin.restfulspring.model.Friend;

import java.util.ArrayList;
import java.util.List;

public class FriendTest {


    @Test
    public void testCrud(){
        RestTemplate restTemplate = new RestTemplate();

        String url= "http://localhost:8080/friend";

        Friend friend=new Friend();
        friend.setFirstName("Hell00");
        friend.setLastName("wooo00");
        Address address = new Address();
        address.setCity("Manchester");
        address.setState("CT");
        address.setStreetName("HorizonWay");
        List<Address> addresses = new ArrayList<>();
        addresses.add(address);
        friend.setAddresses(addresses);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
     //   headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
        HttpEntity<Friend> entity = new HttpEntity<Friend>(friend, headers);

        ResponseEntity<Friend> responseEntity = restTemplate.exchange(url,HttpMethod.POST,entity,Friend.class);

        System.out.println(responseEntity.getBody());

      //  ResponseEntity<Friend> friend1= restTemplate.postForEntity(url,friend,Friend.class);

    }
}
