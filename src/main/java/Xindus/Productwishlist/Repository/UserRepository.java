package Xindus.Productwishlist.Repository;

import Xindus.Productwishlist.Entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer> {
}
