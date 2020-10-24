package com.comulynx.wallet.rest.api.jwt.hazelcast.api.wrapper.jwt.token.hazelcast;


import static java.util.Collections.emptyList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.comulynx.wallet.rest.api.model.Webuser;
import com.comulynx.wallet.rest.api.repository.WebuserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private WebuserRepository userRepository;

    public UserDetailsServiceImpl() {
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	Webuser applicationUser = userRepository.findByUsername(username);

        if (applicationUser == null) {
            System.out.println("[username => "+username+"]"+" NO USER FOUND!!!!");
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
    }
}
