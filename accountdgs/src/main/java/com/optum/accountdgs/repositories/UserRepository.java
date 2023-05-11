package com.optum.accountdgs.repositories;

import com.optum.accountdgs.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;




public interface UserRepository extends JpaRepository<User,String>{

}
