package knu.nono.yesgram.repository;

import knu.nono.yesgram.domain.MockUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MockUserRepository extends JpaRepository<MockUser, Long> {
}
