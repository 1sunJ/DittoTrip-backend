package site.dittotrip.ditto_trip.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.dittotrip.ditto_trip.item.domain.UserItem;
import site.dittotrip.ditto_trip.user.domain.User;

import java.util.List;

public interface UserItemRepository extends JpaRepository<UserItem, Long> {


}
